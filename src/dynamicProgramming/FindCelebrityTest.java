package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindCelebrityTest {
    public FindCelebrity f;
    int a1[][] = { {0,0,0},
            {0,0,0},
            {0,0,0}};   //<-- No celebrity
    int a2[][] = { {1,1,1},
            {0,0,0},    //<--  1 is celebrity
            {0,1,0}};   
    int a3[][] = { {1,0,1},
            {0,0,1},
            {1,0,0}}; //<-- No celebrity
    int a4[][] = { {1,0,1,1,1},
            {0,1,1,0,1},
            {0,0,1,1,1},
            {0,0,0,0,1},
            {0,0,0,0,0}}; //<-- 4 is celebrity
    @Test
    public void testFindCelebrity() {
        f = new FindCelebrity(a1);
        assertEquals(-1, f.findCelebrity(3));
        f = new FindCelebrity(a2);
        assertEquals(1, f.findCelebrity(3));
        f = new FindCelebrity(a3);
        assertEquals(-1, f.findCelebrity(3));
        f = new FindCelebrity(a4);
        assertEquals(4, f.findCelebrity(5));
    }
    
    @Test
    public void testFindCelebrity2() {
        f = new FindCelebrity(a1);
        assertEquals(-1, f.findCelebrity2(3));
        f = new FindCelebrity(a2);
        assertEquals(1, f.findCelebrity2(3));
        f = new FindCelebrity(a3);
        assertEquals(-1, f.findCelebrity2(3));
        f = new FindCelebrity(a4);
        assertEquals(4, f.findCelebrity2(5));
    }

}
