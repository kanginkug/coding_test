class Solution {
    public int solution(int m, int n, String[] board) {
        String[][] partArr = shareArray(m,n,board);

        boolean exist = true;
        int answer = 0;
        while(exist) {
            boolean[][] boomList = new boolean[m][n];
            int boomCnt = 0;

            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    if(x+1 < m && y+1 < n) {
                        if(!partArr[x][y].isEmpty() && !partArr[x][y+1].isEmpty() && !partArr[x+1][y].isEmpty() && !partArr[x+1][y+1].isEmpty()){
                            if(partArr[x][y].equals(partArr[x][y+1]) && partArr[x][y].equals(partArr[x+1][y]) && partArr[x][y].equals(partArr[x+1][y+1])) {
                                boomList[x][y] = true;
                                boomList[x][y+1] = true;
                                boomList[x+1][y] = true;
                                boomList[x+1][y+1] = true;
                                boomCnt++;
                            }
                        }

                    }
                }
            }

            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    if(boomList[x][y]) {
                        answer++;
                        int start = x;
                        while(start-1 >= 0) {
                            if(!boomList[start-1][y]) {
                                boomList[start][y] = false;
                                partArr[start][y] = partArr[start-1][y];
                            }
                            if(start-1 == 0) {
                                partArr[start-1][y] = "";
                            }else if(start-2 >= 0 && partArr[start-2][y].isEmpty()) {
                                partArr[start-1][y] = "";
                            }
                            start--;
                        }
                    }
                }
            }

            if(boomCnt == 0) {
                exist = false;
            }
        }

        return answer;
    }
    public String[][] shareArray(int m, int n, String[] board) {
        String[][] partArr = new String[m][n];
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                partArr[x][y] = String.valueOf(board[x].charAt(y));
            }
        }
        return partArr;
    }
}