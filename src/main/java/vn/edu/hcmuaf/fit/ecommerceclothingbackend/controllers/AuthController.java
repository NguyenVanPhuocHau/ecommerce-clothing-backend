package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.jwt.JwtUtils;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.jwt.UserDetailsImpl;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.LoginRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response.JwtResponse;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.RoleRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.UserRepository;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        JwtResponse jwtResponse = new JwtResponse();
//        jwtResponse.setToken(jwt);
//        jwtResponse.setName(userDetails.getName());
//        jwtResponse.setPhone(userDetails.getPhone());
//        jwtResponse.setAvatar(userDetails.getAvatar());
//        jwtResponse.setEmail(userDetails.getUsername());
//        jwtResponse.setRoles(roles);
//        jwtResponse.setId(userDetails.getId());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }
//    @PostMapping("/check-email")
//    public ResponseEntity<?> checkEmail(@RequestBody SignupRequest signUpRequest){
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity.ok(true);
//        }else{
//            return ResponseEntity.ok(false);
//        }
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("emailExist"));
//        }
//
//        // Create new user's account
////    User user = new User(signUpRequest.getEmail(),
////               signUpRequest.getEmail(),
////               encoder.encode(signUpRequest.getPassword()));
//        User user = new User();
//        user.setName(signUpRequest.getName());
//        user.setEmail(signUpRequest.getEmail());
//        user.setPassword(encoder.encode(signUpRequest.getPassword()));
//        user.setPhone(signUpRequest.getPhone());
//        user.setDatePost(Calendar.getInstance());
//        user.setDateModified(Calendar.getInstance());
//        user.setUserStatus("public");
//        user.setUserParent(0);
//        Set<String> strRoles = signUpRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
//        }
//
//        user.setRoles(roles);
//        userRepository.save(user);
//
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }
}