package io.ims.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
public class ImsUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
