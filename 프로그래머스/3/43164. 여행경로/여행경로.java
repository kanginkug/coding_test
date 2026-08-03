import java.util.Arrays;
class Solution {
    String answerStr = "";
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets,(a,b) -> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        boolean[] visited = new boolean[tickets.length];
        int depth = 0;
        DFS(depth, tickets, visited, "ICN", "ICN");
        System.out.println(answerStr);
        return answerStr.split(" ");
    }
    public void DFS(int depth, String[][] tickets, boolean[] visited, String startStr, String sumStr) {
        if(depth == tickets.length) {
            answerStr = sumStr;
            return;
        }
        if(answerStr.isEmpty()) {
            for(int i = 0; i < tickets.length; i++) {
                if(tickets[i][0].equals(startStr) && !visited[i]) {
                    visited[i] = true;
                    DFS(depth + 1, tickets, visited, tickets[i][1], sumStr + " " + tickets[i][1]);
                    visited[i] = false;
                }
            }
        }
    }
}