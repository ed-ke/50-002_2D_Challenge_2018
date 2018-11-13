package com.example.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class parser
    {
        public static CnfSatInstance parseFile(String fileName)
        {
            CnfSatInstance sat = new CnfSatInstance();
            try
            {
                Scanner in = new Scanner(new File(fileName));
                String problemLine = in.nextLine();
                //ignore comment header
                while (problemLine.matches("c.*"))
                {
                    problemLine = in.nextLine();
                }
                //process the problem line
                String[] params = problemLine.split("\\s");

                if (!params[0].equals("p"))
                {
                    System.err.println("ERROR: CNF file appears to miss the problem line!");
                    System.err.println("       Returning empty SAT instance!");
                    in.close();
                    return sat;
                }
                if (!params[1].equals("cnf"))
                {
                    System.err.println("ERROR: Non-CNF file!");
                    System.err.println("       Returning empty SAT instance!");
                }
                sat.setNumVars(Integer.parseInt(params[2]));
                sat.setNumClauses(Integer.parseInt(params[3]));

                String currentLine;
                String[] tokens;
                List<Integer> currentClause = new LinkedList<Integer>();
                //read in clauses and comment lines which encode symbol definitions
                while (in.hasNext())
                {
                    currentLine = in.nextLine();
                    tokens = currentLine.split("\\s");
                    if (!tokens[0].equals("c")&&!tokens[0].equals(""))
                    {
                        for (int i = 0; i < tokens.length; i++)
                        {
                            Integer literal = Integer.parseInt(tokens[i]);
                            if (literal == 0)
                            {
                                sat.getClauses().add(currentClause);
                                currentClause = new LinkedList<Integer>();
                            }
                            else
                            {
                                currentClause.add(literal);
                            }
                        }

                    }
                }
                if (!currentClause.isEmpty())
                    sat.getClauses().add(currentClause);
                in.close();
            }
            catch (FileNotFoundException e)
            {
                System.err.println("ERROR: CNF file not found: " + fileName);
                System.err.println("       Returning empty SAT instance!");
            }
            return sat;
        }
    }

