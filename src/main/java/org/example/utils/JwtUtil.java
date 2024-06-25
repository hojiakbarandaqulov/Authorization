package org.example.utils;

import io.jsonwebtoken.*;
import org.example.dto.jwt.JwtDTO;
import org.example.enums.ProfileRole;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JwtUtil {
    private static final  int tokenLiveTime = 1000 * 3600 * 48;
    private static final  String secretKey  = "diufghidgnjhbgbggkhdnsfgkjldfs ngldbknlfjg nk.gjewrn f;oewrfnerkn f MAZGIdfjbvhdniuvbdfiulbdvhjubd  ihfvbd ovsnm;acsd,m/ldcknmdlfjkcvndlvkjm dflnvmd fvkj dnfovdfnkv.jdfnvkjdf nvkjdfnv jfvniodfmp";

    public static String encode(Integer profileId, String username, ProfileRole role) {
        JwtBuilder jwtBuilder= Jwts.builder();
        jwtBuilder.issuedAt(new Date());

        SignatureAlgorithm sa=SignatureAlgorithm.HS512;
        SecretKeySpec secretKeySpec=new SecretKeySpec(secretKey.getBytes(),sa.getJcaName());

        jwtBuilder.signWith(secretKeySpec,sa);

        jwtBuilder.claim("id",profileId);
        jwtBuilder.claim("role",role);
        jwtBuilder.claim("username",username);

        jwtBuilder.expiration(new Date(System.currentTimeMillis()+tokenLiveTime));
        jwtBuilder.issuer("Authorization");
        return jwtBuilder.compact();
    }
    public static JwtDTO decode(String token) {
        SignatureAlgorithm sa=SignatureAlgorithm.HS512;
        SecretKeySpec secretKeySpec=new SecretKeySpec(secretKey.getBytes(),sa.getJcaName());
        JwtParser jwtParser=Jwts.parser()
                .verifyWith(secretKeySpec)
                .build();
        Jws<Claims> jws=jwtParser.parseSignedClaims(token);
        Claims claims= jws.getPayload();

        Long id= (Long) claims.get("id");
        String username= (String) claims.get("username");
        String role= (String) claims.get("role");
        if (role!=null){
            ProfileRole profileRole=ProfileRole.valueOf(role);
            return new JwtDTO(id, username, profileRole);
        }
        return new JwtDTO(id);
    }
}
