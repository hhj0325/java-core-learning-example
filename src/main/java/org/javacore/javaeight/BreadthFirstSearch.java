package org.javacore.javaeight;

import java.util.*;

/**
 * Created by huhaojian on 2019/2/15 0015.
 */
public class BreadthFirstSearch {

    private static boolean search(Map<String, List<String>> graph, String name) {
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name));
        // This list is how you keep track of which people you've searched before.
        List<String> searched = new ArrayList<>();
        boolean hasSeller = false;
        // 顶点数
        int v = 0;
        // 边数
        int e = 0;


        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            v++;
            // Only search this person if you haven't already searched them
            if (!searched.contains(person)) {
                if (person_is_seller(person)) {
                    System.out.println(person + " is a mango seller!");
                    hasSeller = true;
                    // return true;
                } else {
                    searchQueue.addAll(graph.get(person));
                    e += graph.get(person).size();
                    // Marks this person as searched
                    searched.add(person);
                }
            }
        }
        System.out.println("v:" + v + ", e:" + e);
        if(!hasSeller){
            System.out.println("Not a mango seller!" );
        }
        return hasSeller;
    }

    private static boolean person_is_seller(String name) {
        return name.endsWith("m");
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anum", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anum", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        search(graph, "you");
        search(graph, "claire");

    }

}
