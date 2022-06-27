package io.ims.security.common.dto;

import io.ims.security.common.constant.TokenAlgType;
import lombok.Builder;
import lombok.Getter;

import java.security.PublicKey;

/**
 * packageName    : io.ims.security.common.dto
 * fileName       : TokenInfo
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
@Getter
@Builder
public class TokenInfo {

    private final String token;
    private TokenAlgType tokenAlgType;
    private PublicKey publicKey;
    private String kid;


}