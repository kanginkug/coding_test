class Solution {
    public int solution(String name) {
        int answer = 0;
        int minMove = name.length()-1;
        int totalLeng = name.length();
        for(int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            answer += Math.min(ch-'A', 'Z'-ch+1);
            int nextIndex = i+1;
            int leng = 0;
            while(nextIndex < name.length() && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            minMove = Math.min(minMove, i*2+(totalLeng-nextIndex));
            minMove = Math.min(minMove, i+(totalLeng-nextIndex)*2);
        }
        return answer + minMove;
    }
}