import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(!list.isEmpty() && !list.get(list.size()-1).equals(arr[i])){
                list.add(arr[i]);
            } else if(list.isEmpty()) {
                list.add(arr[0]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}