/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jofrantoba.algoritmos.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Usuario
 */
public class PlusMinus {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        PlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
    
    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        double totalValue=arr.size();
        double contarEnteros=0;
        double contarNegativos=0;
        double contarZero=0;
        Iterator<Integer> iterador=arr.iterator();
        while(iterador.hasNext()){
            int value=iterador.next();
            if(value>0){
                contarEnteros=contarEnteros+1;
            }else if(value<0){
                contarNegativos=contarNegativos+1;
            }else{
                contarZero=contarZero+1;
            }
        }
        double ratioEntero=contarEnteros/totalValue;
        double ratioNegativo=contarNegativos/totalValue;
        double ratioZero=contarZero/totalValue;
        System.out.println(ratioEntero);
        System.out.println(ratioNegativo);
        System.out.println(ratioZero);
    }
}
