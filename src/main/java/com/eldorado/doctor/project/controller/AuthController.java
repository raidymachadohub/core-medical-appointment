package com.eldorado.doctor.project.controller;


import com.eldorado.doctor.project.dto.CustomerDto;
import com.eldorado.doctor.project.enumerable.RolesEnum;
import com.eldorado.doctor.project.jwt.JwtProvider;
import com.eldorado.doctor.project.jwt.message.JwtResponse;
import com.eldorado.doctor.project.jwt.model.SignUp;
import com.eldorado.doctor.project.model.Customer;
import com.eldorado.doctor.project.model.Roles;
import com.eldorado.doctor.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
public class AuthController extends BaseController{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/auth/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody CustomerDto sigIn) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sigIn.getUsername(),
                        sigIn.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUp signUp) {
        if(userService.existsByUsername(signUp.getUsername()) > 0) {
            return new ResponseEntity<String>("Username exists!",
                    HttpStatus.BAD_REQUEST);
        }

        Customer user = new Customer(signUp.getName(), signUp.getPhoto(), new Date(), signUp.getUsername(),
                 encoder.encode(signUp.getPassword()));

        Set<String> strRoles = signUp.getRoles();
        Set<Roles> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch(role) {
                case "admin":
                    Roles adminRole = userService.findById(new Long(RolesEnum.ROLE_ADMIN.getId()));
                    roles.add(adminRole);

                    break;
                case "pm":
                    Roles pmRole = userService.findById(new Long(RolesEnum.ROLE_PM.getId()));
                    roles.add(pmRole);

                    break;
                default:
                    Roles userRole = userService.findById(new Long(RolesEnum.ROLE_USER.getId()));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userService.userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}
