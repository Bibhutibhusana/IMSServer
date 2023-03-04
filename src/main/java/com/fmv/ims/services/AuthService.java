package com.fmv.ims.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fmv.ims.dto.UserDto;
import com.fmv.ims.models.ERole;
import com.fmv.ims.models.Role;
import com.fmv.ims.models.User;
import com.fmv.ims.payload.request.SignupRequest;
import com.fmv.ims.payload.response.JwtResponse;
import com.fmv.ims.payload.response.MessageResponse;
import com.fmv.ims.repos.RoleRepository;
import com.fmv.ims.repos.UserRepository;
import com.fmv.ims.security.jwt.JwtUtils;
import com.fmv.ims.security.services.UserDetailsImpl;

@Service
public class AuthService {
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	
	Logger logger = Logger.getLogger(AuthService.class);

	public ResponseEntity<?> authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
System.out.println(userDetails.getPassword());
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));

	}

	public ResponseEntity<?> registerUser(@Valid SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		List<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "orderManager":
					Role modRole = roleRepository.findByName(ERole.ROLE_OM)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_CC)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	public ResponseEntity<?> findByUserId(Long id) {
		try {
		User user = userRepository.findById(id).get();
		UserDto userRes = modelMapper.map(user, UserDto.class);
		return ResponseEntity.ok(userRes);
		}
		catch(Exception e) {
			logger.log(Logger.Level.ERROR,e);
			return ResponseEntity.ok("User Id Not Found");
		}
		
	}

}
