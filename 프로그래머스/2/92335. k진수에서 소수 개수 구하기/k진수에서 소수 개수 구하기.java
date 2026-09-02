class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder other = new StringBuilder();
        while(n >= k) {
            other.insert(0, String.valueOf(n % k));
            n = n/k;
        }
        if(n>0) {
            other.insert(0, String.valueOf(n));
        }

        StringBuilder num = new StringBuilder();
        for(int i = 0; i < other.length(); i++) {
            if(other.charAt(i) != '0') {
                num.append(String.valueOf(other.charAt(i)));
            }
            if((!num.isEmpty()) && (other.charAt(i) == '0' || i == other.length()-1)){
                long iNum = Long.parseLong(num.toString());
                if(iNum > 1) {
                    boolean privateNum = false;
                    for(long x = 2; x * x <= iNum; x++) {
                        if(iNum%x == 0) {
                            privateNum = true;
                            break;
                        }
                    }
                    if(!privateNum) {
                        answer++;
                    }
                }
                num = new StringBuilder();
            }
        }

        return answer;
    }
}