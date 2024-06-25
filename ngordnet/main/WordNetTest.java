//package ngordnet.main;
//
//import org.junit.Test;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class WordNetTest {
//
//    @Test
//    public void testHyp(){
//        WordNet wn = new WordNet("./data/wordnet/synsets11.txt", "./data/wordnet/hyponyms11.txt");
//        LinkedList<String> l = new LinkedList<>();
//        l.add("actifed");
//        l.add("antihistamine");
//        assertEquals(l , wn.hyp(List.of("antihistamine")));
//    }
//
//    @Test
//    public void testAgain(){
//        WordNet wn = new WordNet("./data/wordnet/synsets16.txt", "./data/wordnet/hyponyms16.txt");
//        LinkedList<String> l = new LinkedList<>();
//        l.add("alteration");
//        l.add("change");
//        l.add("demotion");
//        l.add("increase");
//        l.add("jump");
//        l.add("leap");
//        l.add("modification");
//        l.add("saltation");
//        l.add("transition");
//        l.add("variation");
//        assertEquals(l, wn.hyp(List.of("change")));
//    }
//
//    @Test
//    public void test(){
//        WordNet wn = new WordNet("./data/wordnet/synsets16.txt", "./data/wordnet/hyponyms16.txt");
//        Set<String> l;
//        l = wn.hyp(List.of("occurrence"));
//        System.out.println(l);
//        Set<String> l1 = wn.hyp(List.of("change"));
//        System.out.println(l1);
//        l1.retainAll(l);
//        System.out.println(l1);
//    }
//
//    @Test
//    public void multiple(){
//        WordNet wn = new WordNet("./data/wordnet/synsets16.txt", "./data/wordnet/hyponyms16.txt");
//        LinkedList<String> l = new LinkedList<>();
//        l.add("alteration");
//        l.add("change");
//        l.add("increase");
//        l.add("jump");
//        l.add("leap");
//        l.add("modification");
//        l.add("saltation");
//        l.add("transition");
//        assertEquals(l, wn.hyp(List.of("change",  "occurrence")));
//    }
//
//    @Test
//    public void testOnce() {
//        WordNet wn = new WordNet("./data/wordnet/synsets.txt", "./data/wordnet/hyponyms.txt");
//        LinkedList<String> l = new LinkedList<>();
//        l.add("bolt");
//        l.add("break");
//        l.add("dah");
//        l.add("dash");
//        l.add("elan");
//        l.add("fast_break");
//        l.add("flair");
//        l.add("hyphen");
//        l.add("panache");
//        l.add("sprint");
//        l.add("style");
//        assertEquals(l, wn.hyp(List.of("dash")));
//    }
//}
