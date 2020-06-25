package com.sumanth.algos;

import java.util.LinkedList;
import java.util.Stack;

/*
Your job is to create a calculator which evaluates expressions in Reverse Polish notation.
For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2) * 4) - 3 in normal notation)
should evaluate to 14.

Note that for simplicity you may assume that there are always spaces between numbers and operations,
 e.g. 1 3 + expression is valid, but 1 3+ isn't.

Empty expression should evaluate to 0.
Valid operations are +, -, *, /.
You may assume that there won't be exceptional situations (like stack underflow or division by zero).
Calculates an expression in Reverse Polish notation
Parameters
    expression: String - The expression to be evaluated
Return Value
    Float - The calculated value from the given expression
Examples
expression 	Return Value
"1 2 3.5" 	3.5
"10000 123 +" 	10123
"5 1 2 + 4 * + 3 -" 	14
 */
public class ReversePolishCalculator {
    public static void evaluateMethod() {
        // test input
        String expr="5 1 2 + 4 * + 3 -";
        System.out.println(evaluate(expr));
    }

    private static double evaluate(String expr) {
        if(expr.length()>0){
            String[] exprArr = expr.split(" ");
            double returnValue = 0.0;

            String operators = "+-*/";

            Stack<String> stack = new Stack<String>();

            for(String t : exprArr){
                if(!operators.contains(t)){
                    stack.push(t);
                }else{
                    double a = Double.valueOf(stack.pop());
                    double b = Double.valueOf(stack.pop());
                    int index = operators.indexOf(t);
                    switch(index){
                        case 0:
                            stack.push(String.valueOf(a+b));
                            break;
                        case 1:
                            stack.push(String.valueOf(b-a));
                            break;
                        case 2:
                            stack.push(String.valueOf(a*b));
                            break;
                        case 3:
                            stack.push(String.valueOf(b/a));
                            break;
                    }
                }
            }
            returnValue = Double.valueOf(stack.pop());

            return returnValue;
        }
        return 0;
    }

}
