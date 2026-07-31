import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : reserve) {
            hashSet.add(num);
        }
        List<Integer> realLost = new ArrayList<>();
        for(int i = 0; i < lost.length; i++) {
            if(hashSet.contains(lost[i])) {
                hashSet.remove(lost[i]);
            } else {
                realLost.add(lost[i]);
            }
        }
        int renderCount = 0;
        for(int i = 0; i < realLost.size(); i++) {

               if(hashSet.contains(realLost.get(i) -1)) {
                   renderCount++;
                   hashSet.remove(realLost.get(i)-1);
               }
               else if(hashSet.contains(realLost.get(i) + 1)) {
                   renderCount++;
                   hashSet.remove(realLost.get(i)+1);
               }
        }

        return n - (realLost.size() - renderCount);
    }
}