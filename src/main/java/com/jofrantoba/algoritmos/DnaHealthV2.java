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
public class DnaHealthV2 {

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
        Map<Integer, Map<String, LinkedHashMap<Integer, Integer>>> numLetra = mapGens(genes, health);
        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];

                Set<Integer> cantLetra = numLetra.keySet();
                Long sum = calcHealth(first, last, cantLetra, d, numLetra);
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

    private static Long calcHealth(int first, int last, Set<Integer> cantLetra, String d, Map<Integer, Map<String, LinkedHashMap<Integer, Integer>>> numLetra) {
        Long sum = 0l;
        Iterator<Integer> iterador = cantLetra.iterator();
        while (iterador.hasNext()) {            
            Integer cant = iterador.next();
            if(cant>d.length()){
                break;
            }
            sum = sum + searchGenCalc(first, last, cant, d, numLetra);
        }
        return sum;
    }

    private static Long searchGenCalc(int first, int last, int cant, String d, Map<Integer, Map<String, LinkedHashMap<Integer, Integer>>> numLetra) {
        Long sum = 0l;
        int indexNext = cant;
            for (int i = 0; i < d.length(); i++) {
                String strGenSearch = d.substring(i, indexNext);
                if (numLetra.get(cant).get(strGenSearch) != null) {
                    sum = sum + sumHealtGen(first, last, numLetra.get(cant).get(strGenSearch));
                }
                if (indexNext > d.length() - 1) {
                    break;
                }
                indexNext = indexNext + 1;
            }       
        return sum;
    }

    private static int sumHealtGen(int first, int last, LinkedHashMap<Integer, Integer> healths) {
        Iterator<Integer> iterador = healths.keySet().iterator();
        int sum = 0;
        while (iterador.hasNext()) {
            int indice = iterador.next();
            if (first <= indice && indice <= last) {
                sum = sum + healths.get(indice);
            }
        }
        return sum;
    }

    private static Map<Integer, Map<String, LinkedHashMap<Integer, Integer>>> mapGens(List<String> genes, List<Integer> health) {
        Map<Integer, Map<String, LinkedHashMap<Integer, Integer>>> numLetra = new HashMap();
        for (int i = 0; i < genes.size(); i++) {
            if (numLetra.get(genes.get(i).length()) != null) {
                if (numLetra.get(genes.get(i).length()).get(genes.get(i)) != null) {
                    numLetra.get(genes.get(i).length()).get(genes.get(i)).put(i, health.get(i));
                } else {
                    LinkedHashMap<Integer, Integer> str = new LinkedHashMap();
                    str.put(i, health.get(i));
                    numLetra.get(genes.get(i).length()).put(genes.get(i), str);
                }
            } else {
                LinkedHashMap<Integer, Integer> str = new LinkedHashMap();
                str.put(i, health.get(i));
                Map<String, LinkedHashMap<Integer, Integer>> letra = new HashMap();
                letra.put(genes.get(i), str);
                numLetra.put(genes.get(i).length(), letra);
            }
        }
        return numLetra;
    }

}
