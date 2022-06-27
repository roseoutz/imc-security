package io.ims.security.common.service.impl;

import io.ims.security.common.dto.TokenInfo;
import io.ims.security.common.service.JwtVerifyService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.jackson.io.JacksonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * packageName    : io.ims.security.common.service.impl
 * fileName       : JjwtVerifyService
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    : JsonWebToken 검증 구현체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public class JjwtVerifyService implements JwtVerifyService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final JacksonDeserializer<Map<String, Object>> deserializer = new JacksonDeserializer<Map<String, Object>>();

    @Override
    public Map<String, Object> getPayload(TokenInfo tokenInfo) {
        String token = tokenInfo.getToken();

        if( token == null || token.length() < 3 || !token.contains(".")) {
            return null;
        }

        String[] tokenArr = token.split("[.]");

        if(tokenArr.length < 2) {
            return null;
        }

        String encBody = tokenArr[1];

        return deserializer.deserialize(Decoders.BASE64URL.decode(encBody));
    }

    @Override
    public String getSub(TokenInfo tokenInfo) {
        final Claims claims = getClaim(tokenInfo);
        return claims.getSubject();
    }

    @Override
    public boolean validateToken(TokenInfo tokenInfo) {
        if( tokenInfo == null) {
            return false;
        }

        if( tokenInfo.getToken() == null) {
            return false;
        }

        try {
            this.getClaim(tokenInfo); // 정상 수행된다면 해당 토큰은 정상토큰

            return true;
        } catch (JwtException eje) {
            logger.error("[IMS Error] Jwt validate error, {}", eje.getMessage(), eje);
            return false;
        }
    }

    @Override
    public boolean isExpired(TokenInfo tokenInfo) {
        final Claims claims = getClaim(tokenInfo);
        final Date expireDate = claims.getExpiration();

        return expireDate.before(new Date());
    }


    private Claims getClaim(TokenInfo tokenInfo) {
        Key signKey = tokenInfo.getSignKey();

        if( tokenInfo.getTokenAlgType().isRSA()) {
            signKey = tokenInfo.getPublicKey();
        }

        return Jwts.parserBuilder()
                .setSigningKey(signKey)
                .build()
                .parseClaimsJws(tokenInfo.getToken())
                .getBody();
    }


}
