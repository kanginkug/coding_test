class Solution {
    int maxCnt = 0;
    boolean[] booArr;
    public int solution(int k, int[][] dungeons) {
        booArr = new boolean[dungeons.length];
        DFS(k, 0, dungeons, booArr);
        return maxCnt;
    }
    public void DFS(int k, int cnt, int[][] dungenos, boolean[] booArr) {
        if(maxCnt < cnt) {
            maxCnt = cnt;
        }

        for(int i = 0; i < dungenos.length; i++) {
            if(!booArr[i] && k >= dungenos[i][0] && k - dungenos[i][1] >= 0) {
                booArr[i] = true;
                DFS(k - dungenos[i][1], cnt+1, dungenos, booArr);
                booArr[i] = false;
            }
        }
    }
}