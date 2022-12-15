package dp;

import org.junit.jupiter.api.Test;

class JumpGameTest {

    @Test
    void canJump() {
        JumpGame jg = new JumpGame();
        int[] nums = new int[] {3,2,1,0,4};
        jg.canJump(nums);
    }
}