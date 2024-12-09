import java.util.List;
import java.util.Map;

public class Gas {
    private final Map<Integer, List<Integer>> brandPrices;

    public Gas(Map<Integer, List<Integer>> brandPrices) {
        this.brandPrices = brandPrices;
    }

    public int[] analyze() {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            int brand = 92 + i * 3;
            List<Integer> prices = brandPrices.get(brand);
            if (prices == null || prices.isEmpty()) {
                result[i] = 0;
                continue;
            }
            int minPrice = prices.get(0);
            int count = 1;
            for (int j = 1; j < prices.size(); j++) {
                if (prices.get(j) < minPrice) {
                    minPrice = prices.get(j);
                    count = 1;
                } else if (prices.get(j) == minPrice) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}

