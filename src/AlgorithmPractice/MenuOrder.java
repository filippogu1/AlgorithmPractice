package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuOrder {

    public List<List<String>> getCombinations(String[] dishNames, int[] dishPrices, int target) {
        List<List<String>> res = new ArrayList<>();
        dfs(dishNames, dishPrices, 0, target, new ArrayList<>(), res);
        return res;
    }

    public void dfs(String[] dishNames, int[] dishPrices, int startIndex, int target, List<String> path, List<List<String>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) return;

        for (int i = startIndex; i < dishPrices.length; i++) {
            path.add(dishNames[i]);
            dfs(dishNames, dishPrices, i, target - dishPrices[i], path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        MenuOrder m = new MenuOrder();
        String[] dishNames = new String[]{"Darnish", "Crossaint", "Brownie", "French Toast", "Egg Muffin"};
        int[] dishPrices = new int[]{2, 3, 4, 8, 5};
        List<List<String>> combinations = m.getCombinations(dishNames, dishPrices, 20);
        for (List<String> path : combinations) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
