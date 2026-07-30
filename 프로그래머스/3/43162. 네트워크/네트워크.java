class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                DFS(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    public void DFS(int i, int[][] computers, boolean[] visited) {
        for(int x = 0; x < computers.length; x++) {
            if(!visited[x] && computers[i][x] == 1) {
                visited[x] = true;
                DFS(x, computers, visited);
            }
        }
    }
}