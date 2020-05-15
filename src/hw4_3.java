/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw4/challenges/dfs-4/submissions/code/1323610108
 * Title: hw4_3.java
 * Abstract: Depth First Search algorithm.  User inputs number of vertices and edges, then edge info.  Program
 *          runs Depth First Search and output of Mark array.
 * Author: Adam Houser
 * ID: 1144
 * Date: 5/15/2020
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class hw4_3 {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        // get vertices
        int v = in.nextInt();

        // get edges
        int e = in.nextInt();

        // create a list for each vertex
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> edges = new ArrayList<Integer>();
            list.add(edges);
        }

        // add edge mapping for each
        for (int i = 0; i < e; i++) {
            int src = in.nextInt();
            int dest = in.nextInt();
            list.get(src).add(dest);
        }

        in.close();

        // mark all visited as false to begin
        for (int i = 0; i < v; i++) {
            visited.add(false);
        }

        // push the first element onto the stack
        stack.push(0);

        // while the stack is not empty, pop a node and add
        while (!stack.empty()) {
            // look at the top element
            int topStack = stack.peek();
            stack.pop();

            // mark that element as visited
            if(!visited.get(topStack))
            {
                output.add(topStack);
                visited.set(topStack, true);
            }

            // get next level nodes adding to stack in reverse order so that they output in the right order
            for (int i = list.get(topStack).size()-1; i >= 0; i--) {
                int nextLevel = list.get(topStack).get(i);

                // if the next level node has not been visited, add it
                if(!visited.get(nextLevel)) {
                    stack.push(nextLevel);
                }
            }
        }

        // print output
        for (int i = 0; i < v; i++) {
            System.out.println("Mark[" + i + "]:" + (output.indexOf(i)+1));
        }
    }
}
