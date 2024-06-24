package org.example.config;

import org.example.entity.ProfileEntity;
import org.example.repository.ProfileRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final ProfileRepository profileRepository;

    public CustomUserDetailService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ProfileEntity> byEmail = profileRepository.findByEmailAndVisibleTrue(username);
        if (byEmail.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        ProfileEntity profile = byEmail.get();
        return new CustomUserDetail(profile);
    }
}
