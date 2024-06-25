package org.example.service;

import org.example.dto.profile.RegistrationDTO;
import org.example.entity.ProfileEntity;
import org.example.exp.AppBadException;
import org.example.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService {
    private final ProfileRepository profileRepository;
    private final MailSenderService mailSenderService;

    public AuthorizationService(ProfileRepository profileRepository, MailSenderService mailSenderService) {
        this.profileRepository = profileRepository;
        this.mailSenderService = mailSenderService;
    }

    public String registration(RegistrationDTO dto) {
        Optional<ProfileEntity> byEmailAndVisibleTrue = profileRepository.findByEmailAndVisibleTrue(dto.getEmail());
        if (byEmailAndVisibleTrue.isPresent()) {
            throw new AppBadException("Email already exists");
        }
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName(dto.getName());
        profileEntity.setSurname(dto.getSurname());
        profileEntity.setEmail(dto.getEmail());
        profileEntity.setPassword(dto.getPassword());
        profileEntity.setRole(dto.getRole());

        return null;
    }


    public void sendRegistrationEmail(Integer profileId, String email) {
        // send email
        String url = "http://localhost:8080/auth/verification/" + profileId;
        String formatText = "<style>\n" +
                "    a:link, a:visited {\n" +
                "        background-color: #f44336;\n" +
                "        color: white;\n" +
                "        padding: 14px 25px;\n" +
                "        text-align: center;\n" +
                "        text-decoration: none;\n" +
                "        display: inline-block;\n" +
                "    }\n" +
                "\n" +
                "    a:hover, a:active {\n" +
                "        background-color: red;\n" +
                "    }\n" +
                "</style>\n" +
                "<div style=\"text-align: center\">\n" +
                "    <h1>Welcome to kun.uz web portal</h1>\n" +
                "    <br>\n" +
                "    <p>Please button lick below to complete registration</p>\n" +
                "    <div style=\"text-align: center\">\n" +
                "        <a href=\"%s\" target=\"_blank\">This is a link</a>\n" +
                "    </div>";
        String text = String.format(formatText, url);
        mailSenderService.send(email, "Complete registration", text);
//        emailHistoryService.crete(email, text); // create history

    }
}