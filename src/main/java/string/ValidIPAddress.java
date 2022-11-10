package string;

import java.util.Arrays;

/**
 * LeetCode #468 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/10
 */
public class ValidIPAddress {
    private static final int IPV4_LEN = 4;
    private static final int IPV6_LEN = 8;

    /**
     * Time: O(1); Space: O(1)
     * @param queryIP a string ip
     * @return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address
     *         or "Neither" if IP is not a correct IP of any type.
     */
    public String validIPAddress(String queryIP) {
        return isIPv4(queryIP) ? "IPv4" : isIPv6(queryIP) ? "IPv6" : "Neither";
    }

    public boolean isIPv4(String ip) {
        String[] segments = ip.split("\\.", -1);
        if (segments.length != IPV4_LEN) {
            return false;
        }
        for (int i = 0; i < IPV4_LEN; i++) {
            String seg = segments[i];
            // 1 <= seg.length <= 3
            if (seg.length() < 1 || seg.length() > 3) {
                return false;
            }
            // no leading zeros
            if (seg.length() > 1 && seg.charAt(0) == '0') {
                return false;
            }
            int num = 0;
            for (char c : seg.toCharArray()) {
                // no non-digit char
                if (!Character.isDigit(c)) {
                    return false;
                }
                num = num * 10 + c - '0';
            }
            // 0 <= num <= 255
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String ip) {
        // `limit = -1` to spilt last regex
        String[] segments = ip.split(":", -1);
        if (segments.length != IPV6_LEN) {
            return false;
        }
        for (int i = 0; i < IPV6_LEN; i++) {
            String seg = segments[i];
            // 1 <= seg.length <= 4
            if (seg.length() < 1 || seg.length() > 4) {
                return false;
            }
            for (char c : seg.toCharArray()) {
                // c may contain digits, lowercase English letter ('a' to 'f')
                // and upper-case English letters ('A' to 'F').
                if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        var arr1 = ip.split(":", -1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(arr1.length);
    }
}
