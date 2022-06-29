package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * LeetCode #535 (Medium)
 * @author binqibang
 * @date 2022/6/29
 */
public class EncodeDecodeTinyURL {

    private Map<String, String> map = new HashMap<>();

    /**
     * Encodes a URL to a shortened URL.
     */
    public String encode(String longUrl) {
        String secret = getRandomString();
        while (map.containsKey(secret)) {
            secret = getRandomString();
        }
        map.put(secret, longUrl);
        return "http://tinyurl.com/" + secret;
    }

    /**
     * Decodes a shortened URL to its original URL.
     */
    public String decode(String shortUrl) {
        int n = shortUrl.length();
        String secret = shortUrl.substring(n-6, n);
        return map.get(secret);
    }

    private String getRandomString() {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int n = base.length();
        Random random = new Random();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            res.append(base.charAt(random.nextInt(n)));
        }
        return res.toString();
    }
}
