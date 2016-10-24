package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubsequenceTest {
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    @Test
    public void testLcs() {
        assertEquals(0,lcs.lcs("ABCDGH", "t"));
        assertEquals(3,lcs.lcs("ABCDGH", "AEDFHR"));
        assertEquals(4,lcs.lcs("AGGTAB", "GXTXAYB"));
        assertEquals(2,lcs.lcs("AGGTAB", "XXAYB"));
    }

}
