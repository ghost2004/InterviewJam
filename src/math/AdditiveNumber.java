package math;
/*
 * Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except 
for the first two numbers, each subsequent number in the sequence must be 
the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive 
sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 */
public class AdditiveNumber {
	private boolean isValid(int start, String num, String left, String right) {
		if (start == num.length())
			return true;
		long first = Long.parseLong(left);
		long second = Long.parseLong(right);
		
		if (!Long.toString(first).equals(left) || !Long.toString(second).equals(right))
			return false;
		long sum = first + second;
		String sums = Long.toString(sum);
		if (sums.length() > num.length() - start)
			return false;
		long result = Long.parseLong(num.substring(start, start+sums.length()+1));
		if (result != sum)
			return false;
			
		
		return isValid(start+sums.length()+1, num, right, sums);
	}
	public boolean isAdditiveNumber(String num) {
		int length = num.length();
		for (int i = 0; i < length; i++) {
			for (int j = i+1; j < length-i-1; j++) {
				String left = num.substring(0, i+1);
				String right = num.substring(i+1, j+1);
				if (isValid(i+1, num, left, right))
					return true;
			}
		}
        return false;
    }
}
