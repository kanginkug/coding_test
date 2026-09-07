class Solution {
    public int solution(int[] arr) {
        int min = 0;
        long max = 1L;
        for (int num : arr) {
            min = Math.max(min, num);
            max = max * num;
        }
        int answer = 0;
        for(long i = min; i < max; i++) {
            boolean brk = false;
            for(int num : arr) {
                answer = Integer.parseInt(String.valueOf(i));
                if(i%num != 0) {
                    brk = true;
                    break;
                }
            }
            if(!brk) {
                break;
            }
        }

        return answer;
    }
}