package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubstringTest {
    LongestCommonSubstring l = new LongestCommonSubstring();
    @Test
    public void testLCSubStr() {
        assertEquals(1, l.LCSubStr("aa", "a"));
        assertEquals(0, l.LCSubStr("aa", "bbbbb"));
        assertEquals(0, l.LCSubStr("", "bbbbb"));
        assertEquals(5, l.LCSubStr("GeeksforGeeks", "GeeksQuiz"));
    }

}
