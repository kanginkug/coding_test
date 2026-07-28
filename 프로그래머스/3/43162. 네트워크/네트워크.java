class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                DFS(i, n, computers, visited);
                cnt++;
            }
        }
        return cnt;
    }
    
    public void DFS(int index, int n, int[][] computers, boolean[] visited) {
        for(int i = 0; i < n; i++) {
            if(computers[index][i] == 1 && !visited[i]) {
                visited[i] = true;
                DFS(i, n, computers, visited);
            }
        }
    }
}