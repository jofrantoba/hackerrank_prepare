/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.jofrantoba.algoritmos;

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
public class DnaHealthV1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int s = Integer.parseInt(bufferedReader.readLine().trim());
        Map<String, Long> minMax = new HashMap();        
        minMax.put("min", Long.MAX_VALUE);
        minMax.put("max", 0l);
        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];
                int indexOf = -1;
                long sum = 0;
                for (int i = first; i <= last; i++) {
                    do {
                        indexOf = d.indexOf(genes.get(i), indexOf + 1);
                        if (indexOf != -1) {
                            sum = sum + health.get(i);
                        }
                    } while (indexOf != -1);
                }
                
                if (minMax.get("min") > sum) {
                    minMax.put("min", sum);
                }
                if (minMax.get("max") < sum) {
                    minMax.put("max", sum);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        System.out.println(String.format("%d %d", minMax.get("min"), minMax.get("max")));
    }
}
