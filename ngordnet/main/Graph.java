package ngordnet.main;

import java.util.*;

public class Graph<T>  {
    private HashMap<T, LinkedList<T>> adjList;
    private int size;

    public Graph() {
        size = 0;
        adjList = new HashMap<>();
    }

    public void addVertex (T s) {
        adjList.put(s, new LinkedList<T>());
        size+=1;
    }

    public void addEdge(T s, T s1) {
        if (!adjList.containsKey(s)) {
            addVertex(s);
        }
        if (!adjList.containsKey(s1)) {
            addVertex(s1);
        }
        adjList.get(s).add(s1);
    }

    public LinkedList<T> returnAllVertices() {
        LinkedList<T> l = new LinkedList<>();
        for (T i : adjList.keySet()) {
            l.add(i);
        }
        return l;
    }

    public LinkedList<T> returnChildren (T s) {
        return adjList.get(s);
    }

}
