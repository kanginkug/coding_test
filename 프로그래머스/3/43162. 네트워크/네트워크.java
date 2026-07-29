class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                DFS(visited, computers, i);
                answer++;
            }
        }
        return answer;
    }
    public void DFS(boolean[] visited, int[][] computers, int inx) {
        for (int i = 0; i < computers.length; i++) {
            if(!visited[i] && computers[inx][i] == 1) {
                visited[i] = true;
                DFS(visited, computers, i);
            }
        }
    }
}