package AlgorithmPractice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// DijkstraPQ's implementation
// LC882 is a very good example to apply this!
// But that question is MaxQ not MinQ.
public class DijkstraPQ {

    class Pair {
        int dist;
        int index;
        Pair(int dist, int index) {
            this.dist = dist;
            this.index = index;
        }
    }

    public void printSolution(int[] dist)
    {
        System.out.println("Vertex    Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + "         " + dist[i]);
    }

    public void dijkstra(int graph[][], int src) {
        int len = graph.length;
        boolean[] visited = new boolean[len];
        int[] dist = new int[len];

        for (int i = 0; i < len; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.dist - b.dist;
            }
        });

        dist[src] = 0;
        pq.add(new Pair(dist[src], src));

        while (!pq.isEmpty()) {
            Pair currP = pq.poll();
            visited[currP.index] = true;
            for (int i = 0; i < len; i++) {
                if (!visited[i] && graph[currP.index][i] != 0
                        && dist[currP.index] != Integer.MAX_VALUE && dist[currP.index] + graph[currP.index][i] < dist[i]) {
                    dist[i] = dist[currP.index] + graph[currP.index][i];
                    pq.add(new Pair(dist[i], i));
                }
            }
        }

        printSolution(dist);
    }

    public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        DijkstraPQ d = new DijkstraPQ();
        d.dijkstra(graph, 0);
    }
}
