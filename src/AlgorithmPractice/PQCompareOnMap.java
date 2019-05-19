package AlgorithmPractice;

import java.util.*;

public class PQCompareOnMap {

    private Map<String, Integer> map = new HashMap<>();
    private Set<String> top3names = new HashSet<>();
    private Queue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

    public void callAPI(String name) {
        map.put(name, map.getOrDefault(name, 0) + 1);
        if (!top3names.contains(name)) {
            pq.add(name);
            top3names.add(name);
            if (pq.size() > 3) {
                top3names.remove(pq.poll());
            }
        }
    }

    public void getTopThreeNames() {
        for (String name : top3names) {
            System.out.println(name + " has count of " + map.get(name));
        }
    }

    public static void main(String[] args) {
        PQCompareOnMap c = new PQCompareOnMap();
        c.callAPI("Tom");
        c.callAPI("Tom");
        c.callAPI("Tom");
        c.callAPI("John");
        c.callAPI("John");
        c.callAPI("John");
        c.callAPI("John");
        c.callAPI("Amy");
        c.callAPI("Amy");
        c.callAPI("Amy");
        c.callAPI("Amy");
        c.callAPI("Amy");
        c.callAPI("Andy");
        c.getTopThreeNames();
        c.callAPI("Andy");
        c.callAPI("Andy");
        c.callAPI("Andy");
        c.getTopThreeNames();
        c.callAPI("Tom");
        c.callAPI("Tom");
        c.getTopThreeNames();
    }
}
