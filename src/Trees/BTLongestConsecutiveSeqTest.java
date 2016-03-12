package Trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class BTLongestConsecutiveSeqTest {

    @Test
    public void testLongestConsecutive() {
        BTLongestConsecutiveSeq seq = new BTLongestConsecutiveSeq();
        /* Tree 1 return 3
                      
               1
                \
                 3
                / \
               2   4
                    \
                     5
         */
        TreeNode t1 = TreeNode.deserialize("1,#,3,2,#,#,4,#,5,#,#");
        assertEquals(seq.longestConsecutive(t1),3);
        
        /* Tree 2  return 2
               2
                \
                 3
                / 
               2    
              / 
             1
         */
        TreeNode t2 = TreeNode.deserialize("2,#,3,2,1,#,#,#,#");
        assertEquals(seq.longestConsecutive(t2),2);
        
        /* Tree 3  return 4
                2
                 \
                  3
                 / 
                4    
               / 
              5
         */
        TreeNode t3 = TreeNode.deserialize("2,#,3,4,5,#,#,#,#");
        assertEquals(seq.longestConsecutive(t3),4);
        /* Tree 4  return 1
                2
                 \
                  5
                 / \
                4   9 
               / 
              6
         */
        TreeNode t4 = TreeNode.deserialize("2,#,5,4,6,#,#,9,#,#");
        assertEquals(seq.longestConsecutive(t4),1);
        

    }

}
