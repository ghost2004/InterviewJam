package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneEditDistanceTest {
    OneEditDistance d = new OneEditDistance();
    @Test
    public void test() {
        assertEquals(true, d.isOneEditDistance("aa", "a"));
        assertEquals(true, d.isOneEditDistance("aa", "ab"));
        assertEquals(false, d.isOneEditDistance("aa", "abb"));
        assertEquals(false, d.isOneEditDistance("aac", "abb"));
        assertEquals(true, d.isOneEditDistance("aac", "aa"));
        assertEquals(true, d.isOneEditDistance("aca", "ata"));
        
        assertEquals(true, d.isOneEditDistance("aa", "ata"));
        assertEquals(false, d.isOneEditDistance("aac", "ata"));
        assertEquals(false, d.isOneEditDistance("aabc", "aacb"));
    }

}
