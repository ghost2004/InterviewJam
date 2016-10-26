package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortWithAPITest {
    int a1[] = {40, 9,20, 100,1};
    int a2[] = {10,1,5,7};
    int a3[] = {10,41,25,7};
    SortWithAPI s = new SortWithAPI();
    @Test
    public void testSort() {
        s.sort(a1);
        assertEquals(true,s.valid(a1));
        s.sort(a2);
        assertEquals(true,s.valid(a2));
        s.sort(a3);
        assertEquals(true,s.valid(a3));
    }

}
