package ngordnet.main;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import ngordnet.ngrams.NGramMap;
import ngordnet.ngrams.TimeSeries;

import java.util.*;

public class HyponymsHandler extends NgordnetQueryHandler {
    private WordNet w;
    private NGramMap nmap;
    public HyponymsHandler(WordNet wn, NGramMap nm) {
        w = wn;
        nmap = nm;
    }

    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        int k = q.k();
        Set<String> response = new TreeSet<>();
        if (k == 0) {
            response = w.hyp(words);
            return response.toString();
        } else {
            Set<String> l = w.hyp(words);
            List<String> lst = new ArrayList<>();
            PriorityQueue<Double> pq = new PriorityQueue<Double>();
            HashMap<Double, String> m = new HashMap<>();
            for (String word : l) {
                double count = handleHelper(word, startYear, endYear);
                if (count != 0) {
                    m.put(count, word);
                    pq.add(count);
                }
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            for (Double c : pq) {
                lst.add(m.get(c));
            }
            Collections.sort(lst);
            return lst.toString();
        }
    }

    public double handleHelper(String s, int start, int end) {
        double sum = 0;
        TimeSeries ts = nmap.countHistory(s, start, end);
        while (start <= end) {
            if (ts.get(start) != null) {
                sum += ts.get(start);
            }
            start += 1;
        }
        return sum;
    }
}
