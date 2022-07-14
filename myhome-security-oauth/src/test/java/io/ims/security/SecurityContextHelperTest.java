package io.myhome.security;

import io.myhome.security.dto.ImsUserDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * packageName    : io.myhome.security
 * fileName       : SecurityContextHelperTest
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public class SecurityContextHelperTest {

    @Test
    void helperTest() {
        Object obj = null;

        Optional<ImsUserDetail> optional = Optional.ofNullable((ImsUserDetail) obj);

        Assertions.assertEquals(true, true);
    }
}
