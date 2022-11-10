package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidIPAddressTest {
    private ValidIPAddress vi;

    @BeforeEach
    void setUp() {
        vi = new ValidIPAddress();
    }

    @Test
    void validIPAddress() {
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        Assertions.assertEquals("IPv6", vi.validIPAddress(ip));
    }

    @Test
    void isIPv4() {
        String ip = "172.16.254.1";
        System.out.println(vi.isIPv4(ip));
    }
}