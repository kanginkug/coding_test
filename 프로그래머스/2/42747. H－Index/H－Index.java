import java.util.ArrayList;
class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : citations) {
            list.add(num);
        }
        list.sort(Integer::compare);
        if(list.get(list.size()-1) ==0) {
            return 0;
        }
        int h_index = 0;
        int beforeH = 0;
        int index = 0;
        boolean boo = true;
        while (boo && index < citations.length) {
            h_index++;
            int plusCnt = 0;
            int minusCnt = 0;
            for(int i = 0; i < list.size(); i++){
                if(h_index <= list.get(i)){
                    plusCnt++;
                } else if(h_index >= list.get(i)){
                    minusCnt++;
                }
            }
            if(plusCnt >= h_index && minusCnt <= h_index){
                beforeH = h_index;
                index++;
            } else {
                boo = false;
            }
        }
        return beforeH;
    }
}