package com.sunbeam;

import java.util.Stack;

public class ExpressionConversionMain {
	
	public static int priority(char opr) {
		switch(opr) {
		case '$': return 10;
		case '*': return 9;
		case '/': return 9;
		case '%': return 9;
		case '+': return 8;
		case '-': return 8;
		}
		return 0;
	}
	
	public static String infixToPostfix(String infix) {
		//0. create string to store postfix expression
		StringBuilder expr = new StringBuilder();
		//0. create stack of characters
		Stack<Character> st = new Stack<Character>();
		//1. traverse expression from left to right
		for(int i = 0 ; i < infix.length() ; i++) {
			//2. extract character from expression
			char ele = infix.charAt(i);
			//3. if element is operand
			if(Character.isDigit(ele))
				expr.append(ele);
			//4. if element is '('
			else if(ele == '(')
				st.push(ele);
			//5. if element is ')'
			else if(ele == ')') {
				while(st.peek() != '(') {
					expr.append(st.pop());
				}
				st.pop();
			}
			//6. if element is operator
			else {
				while(!st.isEmpty() && priority(st.peek()) >= priority(ele)) {
					expr.append(st.pop());
				}
				st.push(ele);
			}
		}
		//7. pop remaining elements of stack and append into expression one by one
		while(!st.isEmpty())
			expr.append(st.pop());
		//8. return final postfix expression
		return expr.toString();
	}
	
	public static String infixToPrefix(String infix) {
		//0. create string to store prefix expression
		StringBuilder expr = new StringBuilder();
		//0. create stack of characters
		Stack<Character> st = new Stack<Character>();
		//1. traverse expression from right to left
		for(int i =infix.length()-1 ; i >= 0 ; i--) {
			//2. extract character from expression
			char ele = infix.charAt(i);
			//3. if element is operand
			if(Character.isDigit(ele))
				expr.append(ele);
			//4. if element is ')'
			else if(ele == ')')
				st.push(ele);
			//5. if element is '('
			else if(ele == '(') {
				while(st.peek() != ')') {
					expr.append(st.pop());
				}
				st.pop();
			}
			//6. if element is operator
			else {
				while(!st.isEmpty() && priority(st.peek()) > priority(ele)) {
					expr.append(st.pop());
				}
				st.push(ele);
			}
		}
		//7. pop remaining elements of stack and append into expression one by one
		while(!st.isEmpty())
			expr.append(st.pop());
		//8. reverse the exxpression
		expr.reverse();
		//9. return final postfix expression
		return expr.toString();
	}

	public static void main(String[] args) {
		String infix = "1$9+3*4-(6+8/2)+7";
		
		System.out.println("Infix : " + infix);
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix : " + postfix);
		
		String prefix = infixToPrefix(infix);
		System.out.println("Prefix : " + prefix);

	}

}
