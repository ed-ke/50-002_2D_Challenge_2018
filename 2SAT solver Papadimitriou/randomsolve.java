package com.example.random;


import java.util.ArrayList;


public class randomsolve {
    public static void main(String[] args){
        String dir = "/home/yourdir/CNFtestcases/";
        String filename = "5000 Clause SAT.cnf";

        CnfSatInstance CNF = parser.parseFile(dir+filename);
		System.out.println("Currently testing: " + filename);
        ArrayList<Integer> acc = new ArrayList<>();

        int attempts = 10000; // To edit
        int i =0;
        long start_time = System.nanoTime();
        while (i<attempts){

            if (CNF.parseRandom()) {
                acc.add(1);
            } else {
                acc.add(0);
            } i++;
       }
            long end_time = System.nanoTime();
            double difference = (end_time - start_time) / (1e6 * attempts);
        double sum = 0;
        for(int d : acc) {
            sum += d;
        }
        if(sum/attempts > 0.5){
            System.out.println(sum/attempts * 100 + "% FORMULA SATISFIABLE");
        } else {
            System.out.println(100 - (sum/attempts)*100 + "% FORMULA UNSATISFIABLE");
        }
            System.out.println("Average run time for " + acc.size() + " run(s) is " + difference + "ms");

    }
}

