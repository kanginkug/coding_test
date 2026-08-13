class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            if(n%3 == 1) {
                n=n/3;
                sb.append(1);
            } else if(n%3 == 2) {
                n=n/3;
                sb.append(2);
            } else {
                n=n/3-1;
                sb.append(4);
            }


        }

        return sb.reverse().toString();
    }
}