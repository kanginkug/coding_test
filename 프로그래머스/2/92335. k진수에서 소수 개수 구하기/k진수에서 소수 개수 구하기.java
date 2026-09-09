import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>=k) {
            sb.insert(0,n%k);
            n = n/k;
        }
        sb.insert(0,n);

        String[] strArr = sb.toString().split("0");

        for(int i = 0; i < strArr.length; i++) {
            if(strArr[i].isEmpty()) {
                continue;
            }
            long num = Long.parseLong(strArr[i]);
            if(num > 1) {
                boolean pass = false;
                for(long x = 2; (long)x * x <= num; x++) {
                    if(num % x == 0) {
                        pass = true;
                        break;
                    }
                }
                if(!pass) {
                    answer++;
                }
            }
        }

        return answer;
    }
}