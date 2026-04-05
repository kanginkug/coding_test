import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int person1Cnt = 0;
        int person2Cnt = 0;
        int person3Cnt = 0;

        for(int i = 0; i < arr.length; i++){
            if(person1[i % person1.length] == arr[i]) person1Cnt++;
            if(person2[i % person2.length] == arr[i]) person2Cnt++;
            if(person3[i % person3.length] == arr[i]) person3Cnt++;
        }

        int maxVal = Math.max(person1Cnt, Math.max(person2Cnt, person3Cnt));

        ArrayList<Integer> list = new ArrayList<>();
        if(person1Cnt == maxVal) list.add(1);
        if(person2Cnt == maxVal) list.add(2);
        if(person3Cnt == maxVal) list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}