package org.example.config;

import org.example.entity.ProfileEntity;
import org.example.enums.ProfileRole;
import org.example.enums.ProfileStatus;
import org.example.exp.AppBadException;
import org.example.repository.ProfileRepository;
import org.example.utils.MD5Util;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final ProfileRepository profileRepository;

    public CommandLineAppStartupRunner(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ProfileEntity entity=new ProfileEntity();
        entity.setName("Valish");
        entity.setSurname("Valishev");
        entity.setEmail("hojiakbarandaqulov5@gmail.com");
        entity.setPassword(MD5Util.getMD5("1234"));
        entity.setRole(ProfileRole.ROLE_ADMIN);
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setVisible(true);
        Optional<ProfileEntity> byEmail = profileRepository.findByEmailAndVisibleTrue(entity.getEmail());
        if (byEmail.isEmpty()){
            profileRepository.save(entity);
        }
    }
}
