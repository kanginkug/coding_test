import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < lost.length; i++) {
            for(int x = 0; x < reserve.length; x++) {
                if(lost[i] != 0 && reserve[x] != 0) {
                    if(lost[i] == reserve[x]) {
                        lost[i] = 0;
                        reserve[x] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < lost.length; i++) {
            for(int x = 0; x < reserve.length; x++) {
                if(lost[i] != 0 && reserve[x] != 0) {
                    if(lost[i] == reserve[x]-1) {
                        lost[i] = 0;
                        reserve[x] = 0;
                    } else if(lost[i] == reserve[x]+1) {
                        lost[i] = 0;
                        reserve[x] = 0;
                    }
                }
            }
        }
        int cnt = 0;
        for(int num : lost) {
            if(num != 0) {
                cnt++;
            }
        }
        return n-cnt;
    }
}