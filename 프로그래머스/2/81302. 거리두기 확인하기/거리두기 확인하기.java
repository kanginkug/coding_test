import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
            int width = places[i].length;
            int height = places[i][0].length();
            String[][] place = new String[width][height];
            for(int x = 0; x < places[i].length; x++) {
                for(int y = 0; y < places[i][x].length(); y++) {
                    place[x][y] = String.valueOf(places[i][x].charAt(y));
                }
            }
            answer[i] = check(place);
        }
        return answer;
    }
    
    public int check(String[][] place) {
        for(int x = 0; x < place.length; x++) {
            for(int y = 0; y < place[x].length; y++) {
                if(place[x][y].equals("P")) {
                   if(BFS(place, x, y) == 0) {
                       return 0;
                   }
                }
            }
        }
        return 1;
    }
    
    public int BFS(String[][] place, int nowX, int nowY) {
        boolean[][] visited = new boolean[place.length][place[0].length];
        int width = place.length;
        int height = place[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{nowX, nowY, 0});
        visited[nowX][nowY] = true;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int dist = poll[2];
            if (dist >= 2) continue;
            for(int i = 0; i < 4; i++) {
                int sumX = x + dx[i];
                int sumY = y + dy[i];
                if(sumX >= 0 && sumX < width && sumY >= 0 && sumY < height) {
                    if(!visited[sumX][sumY]) {
                        visited[sumX][sumY] = true;
                        if(place[sumX][sumY].equals("O")) {
                            queue.offer(new int[]{sumX, sumY, dist+1});
                        } else if(place[sumX][sumY].equals("P")) {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }
}