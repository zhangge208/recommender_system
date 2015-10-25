package recommender.similarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EuclideanDistance implements IScore {
    @Override
    public double getScore(ArrayList<HashMap<Integer, Integer>> preferences,
                           int firstId, int secondId) {
        boolean hasCommon = false;
        double sumOfSquares = 0;

        for (Map.Entry<Integer, Integer> thing :
                preferences.get(firstId).entrySet()) {
            if (preferences.get(secondId).containsKey(thing.getKey())) {
                hasCommon = true;
                break;
            }
        }

        if (!hasCommon) return 0;

        for (Map.Entry<Integer, Integer> thing :
                preferences.get(firstId).entrySet()) {
            if (preferences.get(secondId).containsKey(thing.getKey())) {
                sumOfSquares += Math.pow(
                        preferences.get(firstId).get(thing.getKey()) -
                        preferences.get(secondId).get(thing.getKey()), 2);
            }
        }

        return 1 / (1 + Math.sqrt(sumOfSquares));
    }
}
