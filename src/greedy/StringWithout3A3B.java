package greedy;
/*
 * Leetcode 984. String Without AAA or BBB
 * Given two integers A and B, return any string S such that:

S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.
 

Example 1:

Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:

Input: A = 4, B = 1
Output: "aabaa"
 

Note:

0 <= A <= 100
0 <= B <= 100
It is guaranteed such an S exists for the given A and B.
 */
public class StringWithout3A3B {
    public class Item {
        public int num;
        public String str;
        
        public Item(int n, String s) {
            num = n;
            str = s;
        }
        public String takeOne() {
            this.num --;
            return str;
        }
        public Item getLargerOne(Item b) {
            if (this.num > b.num)
                return this;
            int t = b.num;
            String s = b.str;
            b.num = this.num;
            b.str = this.str;
            return new Item(t,s);
        }
    }
    
    public String strWithout3a3b(int A, int B) {
       
        Item first = new Item(A, "a");
        Item second = new Item(B, "b");
        String out = "";
        int len = A+B;
        while (len > 0) {
            first = first.getLargerOne(second);

            if (first.num > 0) {
                out += first.takeOne();
            }
            if (first.num > second.num) {
                out += first.takeOne();
            }
            if (second.num > 0) {
                out += second.takeOne();
            }

            len--;

        }
        
        return out;
    }
    
    public static void main(String args[]) {
        StringWithout3A3B s = new StringWithout3A3B();
        System.out.println(s.strWithout3a3b(1, 2));
    }
}
