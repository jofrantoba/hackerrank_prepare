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
public class Staircase {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        Staircase.staircase(n);
        bufferedReader.close();
    }

    public static void staircase(int n) {
        // Write your code here    
        for (int i = 1; i <= n; i++) {
            String almohadilla = String.join("", Collections.nCopies(i, "#"));
            String espacios = n - i > 0 ? String.format("%" + (n - i) + "s", "") : "";
            System.out.println(String.format("%s%s", espacios, almohadilla));
        }

    }

}
