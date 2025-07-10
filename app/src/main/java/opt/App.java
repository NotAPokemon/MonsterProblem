package opt;

import java.util.*;

public class App {

    public static void main(String[] args) {

        List<Double> total = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            total.add(App.simulate(2000, 10000, 8, 100));

        }

        System.out.println(sum(total) / 10);

    }

    public static double simulate(int simCount, int runs, int playerCount, int max) {

        List<Double> chances = new ArrayList<>();

        for (int i = 0; i < simCount; i++) {

            int safe = 0;

            for (int j = 0; j < runs; j++) {
                int[] playerPicks = randomSample(playerCount, 1, max);
                int monster = 1 + (int) (Math.random() * max);

                int you = Solution.safest_pick(playerPicks, max);

                if (!closest(playerPicks, you, monster).contains(you)) {
                    safe++;
                }
            }

            double val = safe * 100 / runs;

            chances.add(val);

        }

        double total = sum(chances);

        return total / simCount;

    }

    public static int[] omg(List<Integer> bru) {
        int[] bruuu = new int[bru.size()];
        for (int i = 0; i < bru.size(); i++) {
            bruuu[i] = bru.get(i);
        }
        return bruuu;
    }

    public static int[] randomSample(int amount, int min, int max) {
        List<Integer> sample = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int ran = min + (int) (Math.random() * (max - min + 1));
            if (sample.contains(ran)) {
                i--;
            } else {
                sample.add(ran);
            }
        }
        return omg(sample);
    }

    public static List<Integer> closest(int[] picks, int you, int target) {
        List<Integer> closest = new ArrayList<>();
        int minDist = Math.abs(you - target);
        closest.add(you);

        for (int p : picks) {
            int dist = Math.abs(p - target);
            if (dist < minDist) {
                closest.clear();
                closest.add(p);
                minDist = dist;
            } else if (dist == minDist) {
                closest.add(p);
            }
        }

        return closest;
    }

    public static double sum(List<Double> array) {
        double total = 0;
        for (double d : array) {
            total += d;
        }
        return total;
    }
}
