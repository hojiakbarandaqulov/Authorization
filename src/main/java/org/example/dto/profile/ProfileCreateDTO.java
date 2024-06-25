package org.example.dto.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.enums.ProfileRole;
import org.example.enums.ProfileStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileCreateDTO {
    private Long id;
    private String name;
    @NotBlank(message = "surname required")
    private String surname;
    @NotBlank(message = "email required")
    private String email;
    @NotBlank(message = "password required")
    private String password;
    private ProfileStatus status;
    private ProfileRole role;
}
