package backtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestoreIpAddressesTest {
    private RestoreIpAddresses ip;

    @BeforeEach
    void setUp() {
        ip = new RestoreIpAddresses();
    }

    @Test
    void restoreIpAddresses() {
        String s = "25525511135";
        var ans = ip.restoreIpAddresses(s);
        System.out.println(ans);
    }
}