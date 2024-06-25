package org.example.dto.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.example.enums.ProfileRole;
import org.example.enums.ProfileStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private ProfileRole role;
    private ProfileStatus status;
    private Boolean visible=Boolean.TRUE;
}
