import java.util.Arrays;
import java.util.TreeMap;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        String[][] recordsArr = new String[records.length][3];
        TreeMap<String,Integer> feeMap = new TreeMap<>();

        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            recordsArr[i][0] = record[0];
            recordsArr[i][1] = record[1];
            recordsArr[i][2] = record[2];
            feeMap.put(record[1],0);
        }

        boolean[] visited = new boolean[recordsArr.length];
        Arrays.sort(recordsArr,(a,b) -> Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])));
        System.out.println(Arrays.deepToString(recordsArr));
        for(int i = 0; i < recordsArr.length; i++) {
            if(!visited[i] && i+1 < recordsArr.length) {
                if(recordsArr[i][1].equals(recordsArr[i+1][1])) {
                    String[] before = recordsArr[i][0].split(":");
                    String[] after = recordsArr[i+1][0].split(":");
                    int beforeTime = Integer.parseInt(before[0])*60 + Integer.parseInt(before[1]);
                    int afterTime = Integer.parseInt(after[0])*60 + Integer.parseInt(after[1]);
                    int time = afterTime - beforeTime;
                    feeMap.put(recordsArr[i][1], feeMap.get(recordsArr[i][1]) + time);
                    visited[i] = true;
                    visited[i+1] = true;
                } else {
                    String[] before = recordsArr[i][0].split(":");
                    String[] after = new String[]{"23","59"};
                    int beforeTime = Integer.parseInt(before[0])*60 + Integer.parseInt(before[1]);
                    int afterTime = Integer.parseInt(after[0])*60 + Integer.parseInt(after[1]);
                    int time = afterTime - beforeTime;
                    feeMap.put(recordsArr[i][1], feeMap.get(recordsArr[i][1]) + time);
                    visited[i] = true;
                }
            } else if(!visited[i]) {
                String[] before = recordsArr[i][0].split(":");
                String[] after = new String[]{"23","59"};
                int beforeTime = Integer.parseInt(before[0])*60 + Integer.parseInt(before[1]);
                int afterTime = Integer.parseInt(after[0])*60 + Integer.parseInt(after[1]);
                int time = afterTime - beforeTime;
                feeMap.put(recordsArr[i][1], feeMap.get(recordsArr[i][1]) + time);
                visited[i] = true;
            }
        }
        int idx = 0;
        int[] answerArr = new int[feeMap.size()];
        for(String key : feeMap.keySet()) {
            if(feeMap.get(key) <= fees[0]) {
                answerArr[idx] = fees[1];
            } else {
                answerArr[idx] = (int) (fees[1] +  Math.ceil(((double) (feeMap.get(key) - fees[0]) /fees[2]))  * fees[3]);
            }
            idx++;
        }
        return answerArr;
    }
}