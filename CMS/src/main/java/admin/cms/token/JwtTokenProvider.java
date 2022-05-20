package admin.cms.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {


    public String makeJwtToken() {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // 헤더의 타입(typ)을 지정할 수 있습니다. jwt를 사용하기 때문에 Header.JWT_TYPE로 사용해줍니다.
                .setIssuer("fresh") //등록된 클레임 중, 토큰 발급자(iss)를 설정할 수 있습니다.
                .setIssuedAt(now) // 등록된 클레임 중, 발급 시간(iat)를 설정할 수 있습니다. Date 타입만 추가가 가능합니다.
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis())) // 등록된 클레임 중, 만료 시간(exp)을 설정할 수 있습니다. 마찬가지로 Date 타입만 추가가 가능합니다.
                .claim("id", "아이디") //비공개 클레임을 설정할 수 있습니다. (key-value)
                .claim("email", "ajufresh@gmail.com")
                .signWith(SignatureAlgorithm.HS256, "secret") // 해싱 알고리즘과 시크릿 키를 설정할 수 있습니다.
                .compact();
    }

    //private
    public Claims parsingToken(String token) {

        validationAuthorizationHeader(token);
        return Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody();
    }

    private void validationAuthorizationHeader(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException();
        }
    }

    private String extractToken(String authorizationHeader) {
        return authorizationHeader.substring(6);
    }
}
