/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw4/challenges/dfs-4/submissions/code/1323645369
 * Title: hw4_3.java
 * Abstract: Depth First Search algorithm.  User inputs number of vertices and edges, then edge info.  Program
 *          runs Depth First Search and output of Mark array.
 * Author: Adam Houser
 * ID: 1144
 * Date: 5/15/2020
 */

import java.util.*;

public class hw4_3 {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        Set<Integer> nodes = new TreeSet<Integer>();

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
            nodes.add(src);
            int dest = in.nextInt();
            nodes.add(dest);
            list.get(src).add(dest);
        }

        // sort edge mapping info
        for (int i = 0; i < v; i++) {
            Collections.sort(list.get(i));
        }

        in.close();

        // mark all visited as false to begin
        for (int i = 0; i < v; i++) {
            visited.add(false);
        }

        output = dfs(0, list, visited, output);

        // print output
        Iterator<Integer> iterator = nodes.iterator();

        while (iterator.hasNext()) {
            int num = iterator.next();
            System.out.print("Mark[" + num + "]:");

            System.out.println(output.indexOf(num)+1);

        }

    }

    public static ArrayList<Integer> dfs(int stackStart, ArrayList<ArrayList<Integer>> list, ArrayList<Boolean> visited, ArrayList<Integer> output) {

        Stack<Integer> stack = new Stack<Integer>();

        // push the first element onto the stack
        stack.push(stackStart);

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

            // iterate through each list and run dfs recursively
            Iterator<Integer> looper = list.get(topStack).iterator();

            while (looper.hasNext())
            {
                int next = looper.next();
                if(!visited.get(next)) {
                    dfs(next, list, visited, output);
                }
            }
        }

        return output;
    }
}
