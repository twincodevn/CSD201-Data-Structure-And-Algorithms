
package ass_csd_graph;

import java.util.*;
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
class Student {
    String studentID;
    String name;
    int avgMark;

    public Student(String studentID, String name, int avgMark) {
        this.studentID = studentID;
        this.name = name;
        this.avgMark = avgMark;
    }
}

class Graph {
    Map<String, List<Pair<String, Integer>>> adjacencyList;
    Map<String, Student> students;

    public Graph() {
        adjacencyList = new HashMap<>();
        students = new HashMap<>();
    }

    public void addStudent(String vertex, String studentID, String name, int avgMark) {
        students.put(vertex, new Student(studentID, name, avgMark));
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.get(source).add(new Pair<>(destination, weight));
    }

    public List<String> BFS(String start) {
        List<String> traversal = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            traversal.add(vertex);

            for (Pair<String, Integer> neighbor : adjacencyList.get(vertex)) {
                String neighborVertex = neighbor.getKey();
                if (!visited.contains(neighborVertex)) {
                    queue.add(neighborVertex);
                    visited.add(neighborVertex);
                }
            }
        }

        return traversal;
    }

    public List<String> DFS(String start) {
        List<String> traversal = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        DFSUtil(start, visited, traversal);

        return traversal;
    }

    private void DFSUtil(String vertex, Set<String> visited, List<String> traversal) {
        visited.add(vertex);
        traversal.add(vertex);

        for (Pair<String, Integer> neighbor : adjacencyList.get(vertex)) {
            String neighborVertex = neighbor.getKey();
            if (!visited.contains(neighborVertex)) {
                DFSUtil(neighborVertex, visited, traversal);
            }
        }
    }

    public boolean hasConnectionTo(String source, String destination) {
        Set<String> visited = new HashSet<>();
        return hasConnectionUtil(source, destination, visited);
    }

    private boolean hasConnectionUtil(String source, String destination, Set<String> visited) {
        visited.add(source);

        if (source.equals(destination)) {
            return true;
        }

        for (Pair<String, Integer> neighbor : adjacencyList.get(source)) {
            String neighborVertex = neighbor.getKey();
            if (!visited.contains(neighborVertex)) {
                if (hasConnectionUtil(neighborVertex, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public List<String> fastestPathTo(String source, String destination) {
        List<String> path = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        parentMap.put(source, null);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();

            if (vertex.equals(destination)) {
                break;
            }

            for (Pair<String, Integer> neighbor : adjacencyList.get(vertex)) {
                String neighborVertex = neighbor.getKey();
                if (!visited.contains(neighborVertex)) {
                    queue.add(neighborVertex);
                    visited.add(neighborVertex);
                    parentMap.put(neighborVertex, vertex);
                }
            }
        }

        String current = destination;
        while (current != null) {
            path.add(0, current);
            current = parentMap.get(current);
        }

        return path;
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add students
        graph.addStudent("A", "A12345", "Alice", 85);
        graph.addStudent("B", "B54321", "Bob", 90);
        graph.addStudent("C", "C98765", "Charlie", 75);
        graph.addStudent("D", "D24680", "David", 80);
        graph.addStudent("E", "E13579", "Eve", 95);
        graph.addStudent("F", "F86420", "Frank", 70);
        graph.addStudent("G", "G97531", "Grace", 88);

        // Add edges
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "A", 6);
        graph.addEdge("B", "D", 3);
        graph.addEdge("B", "E", 2);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "G", 2);
        graph.addEdge("C", "E", 6);
        graph.addEdge("G", "D", 1);
        graph.addEdge("D", "B", 3);
        graph.addEdge("D", "A", 2);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "F", 4);
        graph.addEdge("E", "D", 2);

        // Perform BFS traversal
        System.out.println("BFS traversal starting from A: " + graph.BFS("A"));

        // Perform DFS traversal in descending order of average mark
        System.out.println("DFS traversal in descending order of average mark: " + graph.DFS("A"));

        // Check if F has any connection to A
        boolean hasConnection = graph.hasConnectionTo("A", "F");
        System.out.println("Is there a connection between A and F? " + hasConnection);

        // Find the fastest path from A to F
        List<String> fastestPath = graph.fastestPathTo("A", "F");
        System.out.println("Fastest path from A to F: " + fastestPath);
    }
}