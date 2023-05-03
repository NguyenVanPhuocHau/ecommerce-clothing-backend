package vn.edu.hcmuaf.fit.ecommerceclothingbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.constant.ERole;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Cart;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Roles;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.User;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.UserInformation;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.jwt.JwtUtils;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.jwt.UserDetailsImpl;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.LoginRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.request.RegisterRequest;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response.JwtResponse;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.payload.response.MessageResponse;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.RoleRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.UserRepository;

import javax.validation.Valid;
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
        System.out.println(loginRequest.getEmail());
        System.out.println(loginRequest.getPassword());
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

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getId(), 200, userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/check-email")
    public ResponseEntity<?> checkEmail(@RequestBody RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(400, "Email đã được sử dụng!"));
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        UserInformation userInformation = new UserInformation();
        userInformation.setFullName(registerRequest.getFullName());
        userInformation.setBirthday(registerRequest.getBirthday());
        userInformation.setGender(registerRequest.getGender());
        userInformation.setUser(user);
        user.setInformation(userInformation);
        user.setCreateAt(Calendar.getInstance());

        Set<Roles> roles = new HashSet<>();


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
        Roles userRole = roleRepository.findRolesByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);
        user.setStatus("acitve");
        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);
        userRepository.save(user);
//        return ResponseEntity.ok(new MessageResponse("successfully!"));

//        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
        MessageResponse messageResponse = new MessageResponse(200, "successfully!");
        return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
    }

    @GetMapping("/findEmail")
    public String getHau() {

        return "jkaslkdfjas";
    }
//    @GetMapping("/findEmail")
//    public String getk() {
//        return "ksfjdksf";
//    }
}