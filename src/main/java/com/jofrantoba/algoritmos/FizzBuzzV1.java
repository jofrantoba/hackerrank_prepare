/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jofrantoba.algoritmos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Usuario
 */
public class FizzBuzzV1 {
    
    public static void main(String[] arg) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        FizzBuzzV1.fizzBuzz(n);
        bf.close();
    }
    
    public static void fizzBuzz(int n) {
        for(int i=1;i<=n;i++){
            String[] digitos=String.valueOf(i).split("");
            System.out.println(isDivisible(digitos,i));
        }
    }
    
    private static String isDivisible(String[] digitos,int numero){
        String divisible3="";
        String divisible5="";
        if(digitos[digitos.length-1].equals("0") || digitos[digitos.length-1].equals("5")){
            divisible5="Buzz";
        }
        int sum=0;
        for(int i=0;i<digitos.length;i++){
            sum=sum+Integer.parseInt(digitos[i]);
        }
        if(sum%3==0){
            divisible3="Fizz";
        }
        if(divisible3.equals(divisible5)){
            return String.format("%d", numero);
        }else{
            return String.format("%s%s", divisible3,divisible5);
        }
    }
    
}
