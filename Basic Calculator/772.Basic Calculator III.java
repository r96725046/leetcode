/*
 * @lc app=leetcode id=772 lang=java
 *
 * [772] Basic Calculator III
 */
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/stacks/basic-calculator-3-official/ojquestion
// @lc code=start
import java.io.*;
import java.util.*;

public class Solution {
	// ***
	//int end = findEnd(s.substring(i));
	//int tmp = calculate(s.substring(i + 1, i + end));
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		char sign = '+';
		while (i<s.length()) {
			char c = s.charAt(i);
			if (c - '0' >= 0 && c - '0'<= 9) {
				int tmp = 0;
				while (i<s.length()) {
					char ch = s.charAt(i);
					if (ch >= '0' && ch<= '9')
						tmp = tmp * 10 + (ch - '0');
					else 
						break;
					i++;
				}
				i--;
				calNumber(stack, sign, tmp);
			} else if (c == '(') {
				int end = findEnd(s.substring(i));
				int tmp = calculate(s.substring(i + 1, i + end));
				calNumber(stack, sign, tmp);
				i += end;
			} else if (c == ' ') {
				i++;
				continue;
			} else {
				sign = c;
			}

			i++;
		}

		int res = 0;
		while (!stack.isEmpty())
			res += stack.pop();

		return res;
	}
	private static void calNumber(Stack<Integer> stack, char sign, int value) {
		if (sign == '+') stack.push(value);
		else if (sign == '-') stack.push(-value);
		else if (sign == '*') stack.push(stack.pop() * value);
		else if (sign == '/') stack.push(stack.pop() / value);
	}
	private static int findEnd(String s) {
		int count = 0;
		int end = 0;
		for (int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') count++;
			else if (c == ')') {
				count--;
				if (count == 0) {
					end = i;
					break;
				}
			}
		}
		return end;
	}
}
// @lc code=end