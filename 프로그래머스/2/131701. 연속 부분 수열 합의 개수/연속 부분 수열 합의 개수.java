import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int num : elements) {
            set.add(num);
            max += num;
        }
        set.add(max);

        int cnt = 1;
        while(cnt <= elements.length-1) {
            for(int x = 0; x < elements.length; x++) {
                int sum = elements[x];
                for(int i = 1; i <= cnt; i++) {
                    if(x-i < 0) {
                        sum += elements[elements.length - (i-x)];
                    } else {
                        sum += elements[x-i];
                    }
                }
                set.add(sum);
            }
            cnt++;
        }
        return set.size();
    }
}