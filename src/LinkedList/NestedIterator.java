package LinkedList;

/*
 * 
 * Leetcode 341. Flatten Nested List Iterator
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].  
 */
import java.util.*;
public class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<NestedInteger>();
        Iterator<NestedInteger> iter = nestedList.iterator();
        while (iter.hasNext()) {
            stack.addLast(iter.next());
        }
    }

    @Override
    public Integer next() {
        return stack.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty()) {
            if (stack.peekFirst().isInteger())
                return true;
            NestedInteger n = stack.removeFirst();
            
            for (int i = n.getList().size()-1; i >= 0; i--) {
                stack.addFirst(n.getList().get(i));
            }
            
        }
        
        return false;
    }
}