package org.example.controller;

import org.apache.tomcat.util.http.parser.Authorization;
import org.example.dto.profile.RegistrationDTO;
import org.example.service.AuthorizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableMethodSecurity(prePostEnabled = true)
@RestController
@RequestMapping("/auth/v1")
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService service, AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }
    @PostMapping("/registration")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationDTO registrationDTO) {
        String body= authorizationService.registration(registrationDTO);
        return ResponseEntity.ok().body(body);
    }
}
