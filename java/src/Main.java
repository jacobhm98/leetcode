public class Main {

    public static void main(String[] args) {
        testMedianOfTwoSortedArrays();
    }

    private static void testMedianOfTwoSortedArrays(){
        int[] num1 = {1, 2};
        int[] num2 = {1, 2, 3};
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        System.out.println(sol.findMedianSortedArrays(num1, num2));
    }
    private static void testLongestSubstringWithoutRepeatingCharacters(){
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
    private static void testKokoEatingBananas(){
        //int[] piles = {30, 11, 23, 4, 20};
        int[] piles = {122890061,438301112,257983174,614414075,602060597,391389864,140358431,117439906,992360201,246252220};
        int h = 33212669;

        // int[] piles = {3, 6, 7, 11};
        // int h = 8;
        KokoEatingBananas sol = new KokoEatingBananas();
        System.out.println(sol.minEatingSpeed(piles, h));
    }
}
