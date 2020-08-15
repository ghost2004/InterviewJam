package arrays;
/*
 * Leetcode 722. Remove Comments
 * 
 * Given a C++ program, remove comments from it. The program source is an array where source[i] is the i-th line of the source code. 
 * This represents the result of splitting the original source code string by the newline character \n.

In C++, there are two types of comments, line comments, and block comments.
 */ 
import java.util.*;
public class RemoveComments {
    private String getNextTwo(String str, int start) {
        int end = start < str.length() - 1 ? start + 2 : start + 1;
        return  str.substring(start, end);
    }
    
    public List<String> removeComments(String[] source) {
        List<String> out = new ArrayList<>();
        StringBuffer buf = new StringBuffer();
        boolean commentMode = false;
        for (String str : source) {

            for (int idx = 0; idx < str.length(); idx++) {
                if (commentMode) {
                    if (getNextTwo(str, idx).equals("*/")) {
                        // end comments mode here
                        commentMode = false;
                        idx++;
                    }
                } else {
                    // ignore rest of line if found "//"
                    if (getNextTwo(str, idx).equals("//")) 
                        break;
                    if (getNextTwo(str, idx).equals("/*")) {
                        // start comment mode here
                        commentMode = true;
                        idx++;
                    } else
                        // it is not comment, add it into buffer
                        buf.append(str.charAt(idx));
                }
                
                
            }
            
            if (!commentMode && buf.length() > 0) {
                // add buffer into result if there is something not in comment
                out.add(buf.toString());
                buf = new StringBuffer();
            }
            
        }

        return out;
    }
    
    public static void printStr(List<String> list) {
        for (String s:list) {
            System.out.println(s);
        }
    }
    
    public static void main(String args[]) {
        RemoveComments r = new RemoveComments();

        String t5[] = {"a/*/b//*c","blank","d//*e/*/f"};
        String t4[] = {"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
        String t3[] = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
        String t2[] = {"a/*comment", "line", "more_comment*/b"};
        String t1[] = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        printStr(r.removeComments(t5));
    }

}
