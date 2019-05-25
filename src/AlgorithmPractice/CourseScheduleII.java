package AlgorithmPractice;

import java.util.*;

public class CourseScheduleII {

    // To take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> nextCourses = new HashMap<>();

        for (int[] pair : prerequisites) {
            nextCourses.putIfAbsent(pair[1], new ArrayList<>());
            nextCourses.get(pair[1]).add(pair[0]);
            inDegree.put(pair[0], inDegree.getOrDefault(pair[0], 0) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!inDegree.containsKey(i)) {
                q.add(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            res[index++] = curr;
            if (index == numCourses) return res;
            for (int next : nextCourses.get(curr)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) q.add(next);
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        int[][] courses = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] res = c.findOrder(4, courses);
        System.out.println(Arrays.toString(res));
    }
}
