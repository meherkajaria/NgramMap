package ngordnet.main;

import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void testGraph(){
        Graph<Integer> g = new Graph<Integer>();
        g.addVertex(5);
        g.addVertex(20);
        g.addEdge(5, 10);

        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(10);
        assertEquals(g.returnChildren(5), lst);
    }
    @Test
    public void anotherTest() {
        Graph<String> g = new Graph<>();
        g.addEdge("M" ,"N");
        g.addEdge("A" , "M");
        g.addEdge("A", "C");
        LinkedList<String> l = new LinkedList<>();
        l.add("M");
        l.add("C");
        assertEquals(g.returnChildren("A"), l);

    }

    @Test
    public void DFSTest(){
        Graph<String> g = new Graph<>();
        g.addEdge("sam", "sample");
        g.addEdge("sam", "sammy");
        g.addEdge("sample", "idiot");
        LinkedList<String> l = new LinkedList<>();
        l.add("sam");
        l.add("sample");
        l.add("idiot");
        l.add("sammy");
        //assertEquals(DFS("sam"), l);
    }
}
