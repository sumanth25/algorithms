package com.sumanth.algos;

import java.util.HashMap;
import java.util.Stack;
/*
Given a string containing just the characters ’(’, ’)’, ’’, ’’, ’[’ and ’]’, determine if the
input string is valid. The brackets must close in the correct order, "()" and "()[]" are all
valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public static void calculate() {
        String s="{[]([{}])}";
        System.out.println("Parenthesis: "+s+" is valid: "+isValid(s));
    }

    // Algorithm providing boolean answer
    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (Character c : charArray) {
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else if (map.values().contains(c)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
