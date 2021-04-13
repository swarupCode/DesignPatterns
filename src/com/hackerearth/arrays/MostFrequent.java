package com.hackerearth.arrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MostFrequent {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<args.length; i++) {
            list.add(Integer.parseInt(args[i]));
        }
        list.stream().forEach(System.out::println);
//        Scanner s = new Scanner(System.in);
//        int counter = s.nextInt();
        int counter = args.length;
        int arr[] = new int[counter];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<counter; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        int res = findMaxFrequentNo(counter, arr, map);
        System.out.println("MAX Frequent val = "+res);
    }

    private static int findMaxFrequentNo(int counter, int[] arr, Map<Integer, Integer> map) {
        for(int i = 0; i< counter; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int max_count = 0;
        int res = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> val : map.entrySet()) {
            System.out.println("Numbers are - "+val.getKey()+" : "+val.getValue());
            if(max_count <= val.getValue()) {
                max_count = val.getValue();
                res = val.getKey();
            }
        }
        return res;
    }
}
