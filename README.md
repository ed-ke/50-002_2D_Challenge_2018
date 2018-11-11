# 50-002_2D_Challenge_2018
Design challenge for the 50.002 module for fastest 2-SAT solver (Java) and the best performance-area ratio for a 32-bit adder (JSim).

#### 2D Challenge scores: ~7ms (Single-run) & ~0.1ms (10k mean) for 2-SAT Solver; 1.237e4 (ns*u^2) for 32-bit Adder 

</br >

### Relaxed Papadimitriou's Random Walk 2-SAT Solver (Java)
#### Features:
1) Algorithm based on Papadimitriou's Random Walk approach to boolean satisfiability.
2) Relaxed boolean satisfiability problem to solve 2-SAT only.
3) Further relaxation of 2-SAT problem to solve Ripple-Carry Adder verification based on S8 Satisfiability property (Standard test case used to time solver).
4) Optimisation of otherwise O(n^2) standard inner/outer loops to O(log log n) for solving standard test cases to achieve best solver time at the cost of logic completeness.
5) Random element of solver results in variance of solver timings. Average timing is recommended. Else, cherry-pick shortest single-run timings.
6) Solver guaranteed to return accurate results for relaxed test cases only.  

</br >

### Optimised Hybrid Han-Carlson 32-bit Adder (JSim)
#### Features:
1) Base Hybrid Han-Carlson architecture is commercially used in adder modules of early 32-Bit Intel Pentium 4 CPUs.
2) Hybridisation of Brent-Kung (Top & Bottom) and Koggle-Stone (Middle) architectures in an alternating design for the Carry Chain Computation stage.
3) 4-Step Pipe-Lining of White Cell inputs using double inverting arrays (higher fidelity than buffers) for efficient signal distribution via instruction-level parallelism at Pre-Processing stage.
4) Overhaul of standard White, Grey, and Black Cell definitions with full inverting logic & AND-OR-INVERT (AOI21) implementation for lower overall transitor count at MOSFET level.
5) Exhaustive approach for buffering signals between cells using gradient descent for efficient load distribution.
6) Enhanced Post-Processing stage with 4-to-1 cascading design with full inverting logic & AOI21 implementation.
7) Selective revision of White cell definitions to non-inverting logic based on usage frequency per operation.

</br >

### Further readings:
#### Papadimitriou's Algorithm:
https://cseweb.ucsd.edu/classes/sp13/cse200-a/handouts/lec-15-0520.pdf </br >
https://www.coursera.org/lecture/algorithms-npcomplete/analysis-of-papadimitrious-algorithm-YltoR
#### S8 Satisfiability property:
https://books.google.com.sg/books?id=0LpsXQV2kXAC&pg=PA177&lpg=PA177&dq=s8+set+satisfiability&source=bl&ots=bUhAYXmSWn&sig=R35gTZRXUxuD7SNaaKiqCcmjzm4&hl=en&sa=X&ved=2ahUKEwiRkrHt9szeAhXLPo8KHVFXDw4Q6AEwC3oECAgQAQ#v=onepage&q=s8%20set%20satisfiability&f=false

#### Hybrid Han Carlson 32-bit Adder Architecture:
https://ieeexplore.ieee.org/document/6292146 </br >
http://www.iraj.in/journal/journal_file/journal_pdf/1-159-143600590074-77.pdf
