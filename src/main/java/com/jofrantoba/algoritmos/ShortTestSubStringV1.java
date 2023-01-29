/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jofrantoba.algoritmos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class ShortTestSubStringV1 {
    public static void main(String arg[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String cadena = bf.readLine().trim();                
        String id=ShortTestSubStringV1.shortTestString(cadena);
        System.out.println("SubString 1:"+id);
        StringBuilder stringBuilder = new StringBuilder(cadena);
        String invertida = stringBuilder.reverse().toString();
        String rdi=ShortTestSubStringV1.shortTestString(invertida);
        StringBuilder sb = new StringBuilder(rdi);
        String di=sb.reverse().toString();
        System.out.println("SubString 2:"+di);
        System.out.println("Rpta:");
        if(id.length()>di.length()){
            System.out.println("substring:"+di);
            System.out.println("Tamaño de substring:"+di.length());
        }else if(id.length()<di.length()){
            System.out.println("substring:"+id);
            System.out.println("Tamaño de substring:"+id.length());
        }else{
            System.out.println("substring:"+id);
            System.out.println("substring:"+di);
            System.out.println("Tamaño de substring:"+di);
        }
        bf.close();
    }
    
    public static String shortTestString(String cadena){        
        String[] caracter=cadena.split("");
        Map<String,List<Integer>> letraIndice=new HashMap();        
        for(int i=0;i<caracter.length;i++){
            if(letraIndice.get(caracter[i])==null){
                List<Integer> indices=new ArrayList();
                indices.add(i);
                letraIndice.put(caracter[i], indices);                
            }else{                
                letraIndice.get(caracter[i]).add(i);                
            }
        }         
        String[] ind=indexInit(cadena,caracter,letraIndice).split(":");
        String str1=cadena.substring(Integer.parseInt(ind[0]), Integer.parseInt(ind[1])+1);
        return str1;                
    }
    
    private static String indexInit(String cadena,String[] caracter,Map<String,List<Integer>> letraIndice){
         Iterator<String> iterador=letraIndice.keySet().iterator();
        int menor=Integer.MAX_VALUE;
        int mayor=Integer.MIN_VALUE;
        List<Integer> repetidosIndices=new ArrayList();
        while(iterador.hasNext()){
            String key=iterador.next();
            if(letraIndice.get(key).size()>1){                
                repetidosIndices.addAll(letraIndice.get(key));
                if(menor>letraIndice.get(key).get(1)){
                    menor=letraIndice.get(key).get(1);
                }                
            }
        }
        repetidosIndices.sort(Comparator.naturalOrder());
        mayor=repetidosIndices.get(repetidosIndices.size()-1);          
        if(!cadena.substring(0, menor).contains(caracter[mayor])){
            mayor=mayor-1;
        }
        return menor+":"+mayor;
    }
}
