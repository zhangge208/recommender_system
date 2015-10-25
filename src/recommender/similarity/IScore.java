package recommender.similarity;

import java.util.ArrayList;
import java.util.HashMap;

public interface IScore {
	public double getScore(ArrayList<HashMap<Integer, Integer>> preferences,
            int firstId, int secondId);
}
