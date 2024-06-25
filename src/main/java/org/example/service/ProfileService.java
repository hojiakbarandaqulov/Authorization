package org.example.service;

import org.example.dto.profile.ProfileCreateDTO;
import org.example.entity.ProfileEntity;
import org.example.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileEntity create(ProfileCreateDTO profileCreateDTO) {
        ProfileEntity entity=new ProfileEntity();
        entity.setName(profileCreateDTO.getName());
        entity.setEmail(profileCreateDTO.getEmail());
        entity.setPassword(profileCreateDTO.getPassword());
        entity.setStatus(profileCreateDTO.getStatus());
        entity.setRole(profileCreateDTO.getRole());
        ProfileEntity saveProfile = profileRepository.save(entity);
        return saveProfile;
    }
}
