package io.ims.security.util;

import io.ims.security.dto.ImsUserDetail;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * packageName    : io.ims.security.util
 * fileName       : SecurityContextHelper
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public class SecurityContextHelper {

    private SecurityContextHelper() {}

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    public static boolean isLogin() {
        Authentication authentication = getAuthentication();

        if (authentication == null) {
            return false;
        }

        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }

        return authentication.isAuthenticated();
    }

    public static Optional<ImsUserDetail> getUserinfo() {
        if (!isLogin()) {
            return Optional.empty();
        }

        Authentication authentication = getAuthentication();

        return Optional.ofNullable((ImsUserDetail) authentication.getPrincipal());

    }

    public static String getLoginId() {
        return getUserinfo().map(ImsUserDetail::getUsername).orElse(null);
    }
    
}
