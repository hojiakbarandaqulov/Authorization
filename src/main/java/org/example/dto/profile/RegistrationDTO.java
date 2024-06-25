package org.example.dto.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.enums.ProfileRole;

@Data
public class RegistrationDTO {
    @NotBlank(message = "name required")
    private String name;
    @NotBlank(message = "surname required")
    private String surname;
    @NotBlank(message = "email required")
    private String email;
    @NotBlank(message = "password required")
    private String password;
    @NotBlank(message = "role required")
    private ProfileRole role;
}
