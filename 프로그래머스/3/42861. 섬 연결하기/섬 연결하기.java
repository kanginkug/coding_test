import java.util.Arrays;
class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs,(a,b) -> Integer.compare(a[2], b[2]));
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int cnt = 0;
        int answer = 0;
        for(int i = 0; i < costs.length; i++) {
            int x = costs[i][0];
            int y = costs[i][1];
            int cost = costs[i][2];
            if(find(x) != find(y)) {
                union(x,y);
                answer += cost;
                cnt++;
            }
            if(cnt >= ((n-1) * n) / 2) {
                break;
            }
        }
        return answer;
    }
    
    public int find(int x) {
        if(parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int rootX, int rootY) {
        int xParent = find(rootX);
        int yParent = find(rootY);
        if(xParent != yParent) {
            parent[yParent] = xParent; 
        }
    }
}