package com.example.random;

import java.util.List;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

    public class CnfSatInstance
    {
        private int numClauses;
        private int numVars;

        protected List<List<Integer>> clauses;


        public CnfSatInstance(){
            setNumClauses(0);
            setNumVars(0);
            clauses = new ArrayList<List<Integer>>();
        }

        public boolean parseRandom(){
            ArrayList<Boolean> booleanClause = new ArrayList<Boolean>();
            ArrayList<Boolean> booleanVariable = new ArrayList<Boolean>();
            List<Integer> randomClause = new ArrayList<Integer>();
            ArrayList<List<Integer>> failedClauses = new ArrayList<List<Integer>>();

            for(int i = 0;i<getNumClauses();i++){
                booleanClause.add(true);
            }


            for(int i = 0;i<getNumVars();i++){
                booleanVariable.add(true);
            }

            int outerCount = 1;
            boolean solved = false;


            while(outerCount <= Math.sqrt(Math.log(Math.log(getNumClauses())))) { //loop for log n with base 2 Math.log(getNumClauses())/Math.log(2)
                int innerCount = 1;
                while(innerCount <= Math.sqrt(Math.log(Math.log(getNumClauses())))) {
                    failedClauses.clear();
                    for (List<Integer> c : getClauses()) {
                        int c0 = c.get(0);
                        int c1 = c.get(1);
                        boolean a1 = booleanClause.get(Math.abs(c0));
                        boolean b1 = booleanClause.get(Math.abs(c1));
                        if(!evaluator(c0,c1,a1, b1)) {
                            failedClauses.add(c);
                        }

                    }
                    if(!failedClauses.isEmpty()) {
                        Collections.shuffle(failedClauses);
                        randomClause.clear();

                        randomClause.add(failedClauses.get(0).get(0));
                        randomClause.add(failedClauses.get(0).get(1));
                    }

                    else {
                        solved = true;
                        break;
                    }
                    int randomVariable = new Random().nextInt(2);
                    int random0 = randomClause.get(0);
                    int random1 = randomClause.get(1);
                    if(randomVariable == 1) {

                        Boolean b = booleanClause.get(Math.abs(random0));
                        booleanClause.set(Math.abs(random0), !b);
                        Boolean a = booleanVariable.get(Math.abs(random0)-1);
                        booleanVariable.set(Math.abs(random0)-1, !a);
                    }
                    else {
                        Boolean b = booleanClause.get(Math.abs(random1));
                        booleanClause.set(Math.abs(random1), !b);
                        Boolean a = booleanVariable.get(Math.abs(random1) - 1);
                        booleanVariable.set(Math.abs(random1) - 1, !a);
                    }
                    innerCount++;
                }

                if(solved){
                    break;
                }
                outerCount++;
            }


            return solved;
        }


        public boolean evaluator(int a, int b, boolean a1, boolean b1) {
            if (a < 0){
                a1 = !a1;
            }
            if (b < 0){
                b1 = !b1;
            }
            return a1 || b1;
        }


        public int getNumClauses()
        {
            return numClauses;
        }

        public List<List<Integer>> getClauses()
        {
            return clauses;
        }

        public void setNumVars(int numVars)
        {
            this.numVars = numVars;
        }

        public int getNumVars()
        {
            return numVars;
        }

        public void setNumClauses(int numClauses)
        {
            this.numClauses = numClauses;
        }
    }

