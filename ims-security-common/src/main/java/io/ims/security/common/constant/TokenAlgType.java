package io.ims.security.common.constant;

/**
 * packageName    : io.ims.security.common.constant
 * fileName       : TokenAlgType
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public enum TokenAlgType {
    HS256,
    HS384,
    HS512,

    RS256,
    RS384,
    RS512,

    PS256,
    PS384,
    PS512

    ;

    public boolean isRSA() {
        return this == RS256 || this == RS384 || this == RS512 ||
                this == PS256 || this == PS384 || this == PS512;
    }
}
