package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMissingNumTest {
    FindMissingNum f = new FindMissingNum();
    int a1[] = {0, 1, 3};
    int a2[] = {0, 1, 2, 3};
    int a3[] = {0, 2, 3};
    @Test
    public void testFindMissing() {
        assertEquals(2, f.findMissing(a1));
        assertEquals(4, f.findMissing(a2));
        assertEquals(1, f.findMissing(a3));
    }
}
