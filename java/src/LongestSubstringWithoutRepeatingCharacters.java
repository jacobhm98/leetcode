import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; ++i){
            Set<Character> seenChars = new HashSet<>();
            for(int j = i; j < sArray.length && !seenChars.contains(sArray[j]); j++){
                seenChars.add(sArray[j]);
            }
            if (seenChars.size() > max){
                max = seenChars.size();
            }
        }
        return max;
    }
}