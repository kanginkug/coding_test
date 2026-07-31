import java.util.Arrays;
class Solution {
    String answerStr = "";
    String[] answer;
    public String[] solution(String[][] tickets) {
         Arrays.sort(tickets,(a,b) -> {
            if(a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        }
        );
        for(int i = 0; i < tickets.length; i++) {
            boolean[] visited = new boolean[tickets.length];
            String[] strArr;
            if(tickets[i][0].equals("ICN")) {
                visited[i] = true;
                DFS(1, visited, tickets[i][1], tickets[i][0] + " " + tickets[i][1], tickets);
                strArr = answerStr.split(" ");
                if(strArr.length == tickets.length + 1) {
                    answer = strArr;
                    return answer;
                }
            }
        }

        return answer;
    }
    
    public void DFS(int depth, boolean[] visited, String backStr, String sumStr, String[][] tickets) {
        if(depth == tickets.length) {
            answerStr = sumStr;
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && backStr.equals(tickets[i][0])) {
                visited[i] = true;
                DFS(depth + 1, visited, tickets[i][1], sumStr + " " + tickets[i][1], tickets);
                visited[i] = false;
            } else if (!answerStr.isEmpty()) {
                return;
            }
        }

    }
}