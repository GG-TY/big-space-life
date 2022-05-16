# big-space-life
Implement Conway's Game of Life in 64-bit integer-space using the language of your choice.

Imagine a 2D grid - each cell (coordinate) can be either "alive" or "dead". Every generation of the simulation, the system ticks forward. Each cell's value changes according to the following:
If an "alive" cell had less than 2 or more than 3 alive neighbors (in any of the 8 surrounding cells), it becomes dead.
If a "dead" cell had *exactly* 3 alive neighbors, it becomes alive.
Your input is a list of alive (x, y) integer coordinates. They could be anywhere in the signed 64-bit range. This means the board could be very large!

Sample input:
(0, 1)
(1, 2)
(2, 0)
(2, 1)
(2, 2)
(-2000000000000, -2000000000000)
(-2000000000001, -2000000000001)
-----------------------------------------

Your program should read the state of the simulation from standard input, run 10 iterations of the Game of Life, and print the result to standard output in Life 1.06 format. 

--------------------------------------

This solution was written in Java version "1.8.0_66" with Eclipse Mars 4.5.1
main() is in src/main/Main.java

Input initial live cell list in (x, y) format followed by enter.
End input with '*' to iterate 10 generations, print end state and quit.
End input with '-' to enter interactive mode where you can continually advance by a variable number of generations.  enter 'q' to quit the program in this mode.
Output is not guaranteed to be sorted in any way