package io.myhome.security.common.service;

import io.myhome.security.common.dto.TokenInfo;

import java.util.Map;

/**
 * packageName    : io.myhome.security.common.service
 * fileName       : JwtService
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public interface JwtVerifyService {

    Map<String, Object> getPayload(TokenInfo tokenInfo);

    String getSub(TokenInfo tokenInfo);

    boolean validateToken(TokenInfo tokenInfo);

    boolean isExpired(TokenInfo tokenInfo);

}
