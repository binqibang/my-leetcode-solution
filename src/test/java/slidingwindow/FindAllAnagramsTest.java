package slidingwindow;

import org.junit.jupiter.api.Test;

class FindAllAnagramsTest {

    @Test
    void findAnagrams() {
        FindAllAnagrams faa = new FindAllAnagrams();
        String s = "cbaebabacd", p = "abc";
        System.out.println(faa.findAnagrams(s, p));
    }
}