import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    HashMap<Integer, ArrayList> map = new HashMap<>();
    int numOfNodes = 0;
    private class Node {
        int value;
        Node(int value) {
            this.value = value;
        }
    }
    Graph() {

    }
    void addVertex(int value) { // Adding a node to graph
        Node newNode = new Node(value);
        ++numOfNodes;
        ArrayList<Integer> list = new ArrayList<>();
        map.put(newNode.value, list);
    }
    void addEdge(int node1Val, int node2Val) {
        Node n1 = new Node(node1Val);
        Node n2 = new Node(node2Val);
        if(map.containsKey(n1.value)) {
            map.get(n1.value).add(n2.value); // Returns the value (list) given the key then, appends the value to list
        }
        else {
            System.out.println("Node n1 doesn't exist!");
        }
    }

    void printGraph() {
        System.out.println(map);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addVertex(3);
        graph.addEdge(3, 9);
        graph.printGraph();
    }
}
