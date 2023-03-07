/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalkulator;

import java.util.Stack;

/**
 *
 * @author Najwa
 */
public class inputan {
    call operator1 = new call();
    private Stack<Character> operatorStack;
    private Stack<Double>valueStack;
    private boolean error;   

    public inputan(){
    operatorStack = new Stack();
    valueStack = new Stack();  
    error = false;
    }
    
    private boolean adalahOperator(char ch){
       return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%';
    }
    
    private int urutanHitung (char ch){
        if (ch=='+' || ch=='-'){
            return 2;
        }
        if (ch=='*' || ch=='/' || ch=='%'){
            return 1;
        }
        return 0;
    }
    
    public void process(char t) {
        double bil1, bil2;
        if (valueStack.empty()) {
            System.out.println("ERROR");
            error = true;
            return;
        } else {
            operator1.bil2 = valueStack.peek();
            valueStack.pop();
        }
        if (valueStack.empty()) {
            System.out.println("error,empty!.");
            error = true;
            return;
        } else {
            operator1.bil1 = valueStack.peek();
            valueStack.pop();
        }
        
        double a=0;
        if (t == '+') {
            a = operator1.tambah();
        } else if (t == '-') {
            a = operator1.kurang();
        } else if (t == '*') {
            a = operator1.kali();
        } else if(t == '/') {
            a = operator1.bagi();
        } else if(t == '%') {
            a = operator1.modulus();
        } else {
            System.out.println("pilihan kosong.");
            error = true;
        }
        valueStack.push(a);
    }
    
    public void Input(String input) {
        String[] tokens = input.split(" ");
        for (String nextToken : tokens) {
            char ch = nextToken.charAt(0);
            if (ch >= '0') {
                double Isi = Double.parseDouble(nextToken);
                valueStack.push(Isi);
            } else if (adalahOperator(ch)) {
                if (operatorStack.empty() || urutanHitung(ch) > urutanHitung(operatorStack.peek())) {
                    operatorStack.push(ch);
                } else {
                    while (!operatorStack.empty() && urutanHitung(ch) <= urutanHitung(operatorStack.peek())) {
                        char toProcess = operatorStack.peek();
                        operatorStack.pop();
                        process(toProcess);
                    }
                    operatorStack.push(ch);
                }
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.empty() && adalahOperator(operatorStack.peek())) {
                    char toProcess = operatorStack.peek();
                    operatorStack.pop();
                    process(toProcess);
                }
                if (!operatorStack.empty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                } else {
                    System.out.println("Error: Penambahan kurung");
                    error = true;
                }
            }
        }
        
        while (!operatorStack.empty() && adalahOperator(operatorStack.peek())) {
            char toProcess = operatorStack.peek();
            operatorStack.pop();
            process(toProcess);
        }
        
        if (error == false) {
            double finalresult = valueStack.peek();
            valueStack.pop();
            if (!operatorStack.empty() || !valueStack.empty()) {
                System.out.println("Error : ada operan yang tidak tertulis atau operan yang salah.");
            } else {
                System.out.println("The result is " + finalresult);
            }
        }
    }}
