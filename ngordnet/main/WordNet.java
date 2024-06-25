package ngordnet.main;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class WordNet<T> {

    private Graph<Integer> graph;
    private Map<String, Set<Integer>> map;

    private Map<Integer, Set<String>> m;
    public WordNet(String wordIDS, String hypIDS) {
        In in = new In(wordIDS);
        In readHyp = new In(hypIDS);
        map = new HashMap<>();
        m = new HashMap<>();
        graph = new Graph<>();
        while (in.hasNextLine()) {
            String s = in.readLine();
            String[] arr = s.split(",");
                m.put(Integer.parseInt(arr[0]), Set.of(arr[1].split(" ")));
                for (String i : m.get(Integer.parseInt(arr[0]))) {
                    if (map.containsKey(i)) {
                        map.get(i).add(Integer.parseInt(arr[0]));
                    }
                    else {
                        Set<Integer> k = new HashSet<Integer>();
                        k.add(Integer.parseInt(arr[0]));
                        map.put(i, k);
                    }
                }
        }
        while (readHyp.hasNextLine()) {
            String s1 = readHyp.readLine();
            String[] array = s1.split(",");
            for (int i = 1; i < array.length; i++) {
                graph.addEdge(Integer.parseInt(array[0]), Integer.parseInt(array[i]));
            }
        }
    }

    public LinkedList<Integer> DFS (Integer s) {
        LinkedList<Integer> lst = new LinkedList<>();
        LinkedList<Integer> l = new LinkedList<>();
        lst.add(s);
        l = graph.returnChildren(s);
        for (Integer i : l) {
            lst.addAll(DFS(i));
        }
        return lst;
    }

    public Set<String> hyp (List<String> l) {
        LinkedList<Integer> result1 = new LinkedList<>();
        Set<String> result2 = new TreeSet<String>();
        if (l.size() == 1 && (map.get(l.get(0)) != null)) {
            for (Integer j : map.get(l.get(0))) {
                result1.addAll(DFS(j));
            }
            for (Integer i1 : result1) {
                result2.addAll(m.get(i1));
            }
            return result2;
        } else if (l.size() > 1 && (map.get(l.get(0)) != null)) {
            return hypHelper(l);
        } else {
            return result2;
        }
    }

    private Set<String> hypHelper (List<String> s) {
        Set<String> f = hyp(List.of(s.get(0)));
        for (String i : s) {
            f.retainAll(hyp(List.of(i)));
        }
        return f;
    }
}
