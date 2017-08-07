package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * Prototype of Nested Integer
 */
public class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;
    
    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }
    
    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList<NestedInteger>();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList<NestedInteger>();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }
    
    private void printNi(NestedInteger thisNi, StringBuilder sb){
        if(thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");

        }
        sb.append("[");
        int size = thisNi.list.size();
        int cnt = 0;
        for(NestedInteger ni : thisNi.list){
            if(ni.isInteger()) {
                sb.append(ni.integer);
                if (cnt < size-1)
                    sb.append(",");
            }
            else {
                printNi(ni, sb);
                if (cnt < size-1)
                    sb.append(",");
            }
            cnt++;
        }
        sb.append("]");
        return;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.printNi(this, sb);
        String out = sb.toString();
        return out;
    }

    public static NestedInteger getFromString(String input) {
        NestedInteger out = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        
        int idx = 0;

        NestedInteger cur = out;
        
        while (idx < input.length()) {
            char c = input.charAt(idx);
            
            if (c == '[') {
                NestedInteger next = new NestedInteger();
                cur.list.add(next);
                stack.push(cur);
                cur = next;
                idx++;
            } else if (c == ']') {
                cur = stack.pop();
                idx++;
            } else if (Character.isDigit(c)){
                int rIdx = idx+1;
                while (rIdx < input.length() && Character.isDigit(input.charAt(rIdx)))
                    rIdx++;
                NestedInteger val = new NestedInteger(Integer.parseInt(input.substring(idx, rIdx)));
                cur.list.add(val);
                idx = rIdx;
            } else
                idx++;
            
            
        }

        return out.getList().get(0);
    }
    
}
