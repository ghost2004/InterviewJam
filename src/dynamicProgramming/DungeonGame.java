package dynamicProgramming;
/*
 * Leetcode 174. Dungeon Game
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially 
 * positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health
point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering 
these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health
 (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or
 downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the 
princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he 
follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)  -3      3
-5      -10     1   
10      30      -5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right
 room where the princess is imprisoned.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int hp[] = new int[n];
        // let's start from grid of princess
        hp[n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        // last row
        for(int i = n-2;i >= 0; i--) {
            hp[i] = Math.max(1, hp[i+1] - dungeon[m-1][i]);
        }
        for (int i = m-2 ; i >= 0; i--) {
            // last column
            hp[n-1] = Math.max(1, hp[n-1] - dungeon[i][n-1]);
            for (int j = n-2; j >=0; j--) {
                int right = Math.max(1, hp[j+1] - dungeon[i][j]);
                int down = Math.max(1, hp[j] - dungeon[i][j]);
                hp[j] = Math.min(right, down);
            }
        }
        
        return hp[0];
        
    }
    
    public static void main(String args[]) {
        DungeonGame d = new DungeonGame();
        int t[][] = {{-3},{-7}};
        System.out.println(d.calculateMinimumHP(t));
    }
}
