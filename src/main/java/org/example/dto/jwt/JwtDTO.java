package org.example.dto.jwt;

import lombok.Data;
import org.example.enums.ProfileRole;
@Data
public class JwtDTO {
    private Long id;
    private String username;
    private ProfileRole role;

    public JwtDTO(Long id, String username, ProfileRole role) {
        this.username = username;
        this.id = id;
        this.role = role;
    }

    public JwtDTO(Long id) {
        this.id = id;
    }
}

