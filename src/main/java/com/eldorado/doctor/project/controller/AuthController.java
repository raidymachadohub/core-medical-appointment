package com.eldorado.doctor.project.controller;


import com.eldorado.doctor.project.builder.CustomerBuilder;
import com.eldorado.doctor.project.dto.CustomerDto;
import com.eldorado.doctor.project.enumerable.RolesEnum;
import com.eldorado.doctor.project.jwt.JwtProvider;
import com.eldorado.doctor.project.jwt.message.JwtResponse;
import com.eldorado.doctor.project.jwt.model.SignUp;
import com.eldorado.doctor.project.model.Customer;
import com.eldorado.doctor.project.model.Message;
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
public class AuthController extends BaseController {

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

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            sigIn.getUsername(),
                            sigIn.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtProvider.generateJwtToken(authentication);
            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (Exception ex) {
            return ResponseEntity.ok(new Message(ex.getMessage(), 400));
        }

    }

    @PostMapping("/auth/signup")
    public Message registerUser(@Valid @RequestBody SignUp signUp) {

        Message message = new Message();

        if (userService.existsByUsername(signUp.getUsername()) > 0) {
            message.setMessage("Email já existe!");
            message.setCode(400);
            return message;
        }

        Customer user = new Customer(signUp.getName(), signUp.getPhoto(), new Date(), signUp.getUsername(),
                encoder.encode(signUp.getPassword()));

        Set<String> strRoles = signUp.getRoles();
        Set<Roles> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
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
        this.userService.save(user);

        message.setMessage("Cliente criado!");
        message.setCode(200);
        return message;
    }
}
