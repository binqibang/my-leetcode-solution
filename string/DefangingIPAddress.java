package string;

/**
 * LeetCode #1108 (Easy)
 * @author binqibang
 * @date 2022/6/21
 */
public class DefangingIPAddress {
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String test = "192.1.0.1";
        System.out.println(defangIPaddr(test));
    }
}