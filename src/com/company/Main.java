package com.company;

import java.util.*;

public class Main {

    public static void main (String[] args) {
        List<Integer> numberList = new ArrayList<Integer>();

        boolean isRunning = true;

        Scanner in = new Scanner(System.in);

        // While the Console is open add to array, if end, break
        System.out.println("Please input the array of numbers separated by comma:");

        String numbers = in.next();

        String[] arrayOfNumbers = numbers.split(",");

        for(int i=0; i<arrayOfNumbers.length; i++){
            numberList.add(Integer.parseInt(arrayOfNumbers[i]));
        }

        if (numberList.isEmpty()) {
            System.out.println("No number has been entered: exiting");
            System.exit(-1);
        }



        Map<Integer,Integer> duplicatesFound = findDuplicates(numberList);
        printDuplicates(duplicatesFound);

        printSumDuplicates(sumDuplicates(duplicatesFound));


    }

    private static Map<Integer, Integer> findDuplicates (List<Integer> numbersLst) {
        int duplicateCount = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer i: numbersLst) {
            if(map.containsKey(i)){
                duplicateCount = map.get(i);
                map.put(i, duplicateCount + 1);
            }
            else{
                map.put(i, 1);
            }
        }
        return map;
    }

    private static void printDuplicates (Map<Integer, Integer> duplicates) {
        System.out.print("Duplicates values are:");

        for(Map.Entry<Integer,Integer> entry : duplicates.entrySet())
        {
            if(entry.getValue() > 1){
                System.out.print(entry.getKey()+ " ");
            }
        }
        System.out.println("\n");
    }

    private static int sumDuplicates(Map<Integer, Integer> duplicates) {
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry: duplicates.entrySet() ) {
            if(entry.getValue() > 1){
                sum = sum + entry.getKey();
            }

        }
        return sum;
    }

    private static void printSumDuplicates (int sum) {
        System.out.println("Sum of the duplicates is:" + sum);

    }
}
