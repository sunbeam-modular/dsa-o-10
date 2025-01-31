package com.sunbeam;

import java.util.Stack;

public class ExpressionEvaluationMain {
	
	public static int calculate(int op1, char opr, int op2) {
		switch(opr) {
		case '+': return op1 + op2;
		case '-': return op1 - op2;
		case '*': return op1 * op2;
		case '/': return op1 / op2;
		case '%': return op1 % op2;
		case '$': return (int)Math.pow(op1, op2);
		}
		return 0;
	}
	
	public static int postfixEvaluate(String expression) {
		//0. create stack to push operands
		Stack<Integer> st = new Stack<Integer>();
		//1. traverse expression from left to right
		for(int i = 0 ; i < expression.length() ; i++) {
			//2. extract element from string
			char ele = expression.charAt(i);
			//3. if element is operand
			if(Character.isDigit(ele))
				// push element on stack
				st.push(ele - '0');
			//4. if element is operator
			else {
				// pop two elements from stack
				int op2 = st.pop();		// op2 = first popped
				int op1 = st.pop();		// op1 = second popped
				// perform operation of op1 and op2
				int res = calculate(op1, ele, op2);
				// push result on stack again
				st.push(res);
			}
		}
		//5. pop result from stack and return
		if(!st.isEmpty())
			return st.pop();
		return 0;
	}
	
	public static int prefixEvaluate(String expression) {
		//0. create stack to push operands
		Stack<Integer> st = new Stack<Integer>();
		//1. traverse expression from right to left
		for(int i = expression.length() - 1 ; i >= 0 ; i--) {
			//2. extract element from string
			char ele = expression.charAt(i);
			//3. if element is operand
			if(Character.isDigit(ele))
				// push element on stack
				st.push(ele - '0');
			//4. if element is operator
			else {
				// pop two elements from stack
				int op1 = st.pop();		// op1 = first popped
				int op2 = st.pop();		// op2 = second popped
				// perform operation of op1 and op2
				int res = calculate(op1, ele, op2);
				// push result on stack again
				st.push(res);
			}
		}
		//5. pop result from stack and return
		if(!st.isEmpty())
			return st.pop();
		return 0;
	}

	public static void main(String[] args) {
		String postfix = "456*3/+9+7-";
		
		System.out.println("Postfix : " + postfix);
		
		int result = postfixEvaluate(postfix);
		System.out.println("Result : " + result);
		
		String prefix = "-++4/*56397";
		
		System.out.println("Prefix : " + prefix);
		
		result = prefixEvaluate(prefix);
		System.out.println("Result : " + result);
		
	}

}






