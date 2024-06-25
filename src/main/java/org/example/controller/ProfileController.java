package org.example.controller;

import org.example.dto.profile.ProfileCreateDTO;
import org.example.entity.ProfileEntity;
import org.example.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableMethodSecurity(prePostEnabled = true)
@RestController
@RequestMapping("/profile/v1")
public class ProfileController {
    private final ProfileService profileService;
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    @PostMapping("/create")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ProfileEntity> createProfile(@RequestBody ProfileCreateDTO profile) {
        ProfileEntity entity = profileService.create(profile);
        return ResponseEntity.ok().body(entity);
    }
}
