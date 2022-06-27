package io.ims.security.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

/**
 * packageName    : io.ims.security.service
 * fileName       : ReactiveUserDetailService
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public class ImsReactiveUserDetailService implements ReactiveUserDetailsService {

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return null;
    }
}
