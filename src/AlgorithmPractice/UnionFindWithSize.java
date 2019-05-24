package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Demo of counting island numbers and their sizes.
public class UnionFindWithSize {

    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};

    public List<int[]> getIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int[] rootArr = new int[m * n];
        int[] sizeArr = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rootArr[i * n + j] = i * n + j;
                    sizeArr[i * n + j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            union(i * n + j, ni * n + nj, rootArr, sizeArr);
                        }
                    }
                }
            }
        }

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m * n; i++) {
            if (rootArr[i] == i) {
                res.add(new int[]{i, sizeArr[i]});
            }
        }

        return res;
    }

    public void union(int node_a, int node_b, int[] rootArr, int[] sizeArr) {
        int root_a = findRoot(node_a, rootArr);
        int root_b = findRoot(node_b, rootArr);
        if (root_a != root_b) {
            rootArr[root_a] = root_b;
            sizeArr[root_b] += sizeArr[root_a];
        }
    }

    public int findRoot(int node, int[] rootArr) {
        if (rootArr[node] == node) return node;
        int root = findRoot(rootArr[node], rootArr);
        rootArr[node] = root;
        return root;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{ {1,0,0,1,1},
                                    {1,0,0,0,1},
                                    {1,1,1,0,0},
                                    {1,0,0,0,1},
                                    {1,1,0,1,0}};

        UnionFindWithSize u = new UnionFindWithSize();
        List<int[]> res = u.getIslands(grid);
        for (int[] count : res) {
            System.out.println(Arrays.toString(count));
        }
    }
}
