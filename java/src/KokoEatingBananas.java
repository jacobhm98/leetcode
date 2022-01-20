import java.util.Arrays;

class KokoEatingBananas {

    public int minEatingSpeed(int[] primPiles, int h) {
        Integer[] piles = Arrays.stream(primPiles).boxed().toArray(Integer[]::new);
        long sum = 0;
        for (int i = 0; i < primPiles.length; ++i){
            sum += primPiles[i];
        }
        int lowerbound = (int) (sum / h);
        if (lowerbound == 0) {
            lowerbound = 1;
        }
        //only way lowerbound will ever be an admissible k
        if (eatOptimally(lowerbound, piles.clone(), h)){
            return lowerbound;
        }
        Arrays.sort(piles);
        int upperbound = piles[piles.length - 1];
        while (upperbound - lowerbound > 1) {
            int k = (upperbound + lowerbound) / 2;
            if (eatOptimally(k, piles.clone(), h)){
                upperbound = k;
            }
            else{
                lowerbound = k;
            }
        }
        return upperbound;
    }

    private boolean eatOptimally(int k, Integer[] piles, int h) {
        int hours = 0;
        for (int i = 0; i < piles.length; ++i) {
            if (k > piles[i]) {
                piles[i] = 0;
                hours++;
            } else {
                int factor = piles[i] / k;
                int remainder = piles[i] % k;
                hours += remainder == 0 ? factor : factor + 1;
                piles[i] = 0;
            }
            if (hours > h) {
                return false;
            }
        }

        return true;
    }

}
