package io.myhome.security.filter;

import io.myhome.security.common.constant.OauthParams;
import io.myhome.security.common.dto.TokenInfo;
import io.myhome.security.common.service.JwtVerifyService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * packageName    : io.myhome.security.filter
 * fileName       : ImsOauthAuthorityCheckFilter
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public class ImsOauthAuthorityCheckFilter extends OncePerRequestFilter {

    private final JwtVerifyService verifyService;

    public ImsOauthAuthorityCheckFilter(JwtVerifyService verifyService) {
        this.verifyService = verifyService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = getToken(request);

        if (!Objects.isNull(accessToken)) {

        }

        filterChain.doFilter(request, response);
    }

    private boolean verifyToken(String accessToken) {
        verifyService.validateToken(TokenInfo.builder().token(accessToken).build());
    }

    private String getToken(HttpServletRequest request) {
        Optional<String> optional = Optional.ofNullable(request.getHeader(OauthParams.OAUTH_PARAM_HEADER_AUTHORIZATION));

        if (optional.isEmpty()) {
            return null;
        }

        String token = optional.get();

        if (token.startsWith(OauthParams.OAUTH_PARAM_HEADER_BEARER)) {
            token = token.substring(7);
        }

        return token;
    }
}
