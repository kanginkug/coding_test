import java.util.HashSet;
class Solution {
    HashSet<String> strSet = new HashSet<>();
    //80	{{80,20},{50,40},{30,10}}	3
    public int solution(int k, int[][] dungeons) {
        String strNum = "";
        int length = dungeons.length;
        for(int i = 0; i < dungeons.length; i++) {
            strNum += String.valueOf(i);
        }
        Recursion("", strNum, length);
        int max = 0;
        for(String idx : strSet) {
            int cnt = 0;
            int heart = k;
            for(int i = 0; i < idx.length(); i++) {
                int index = Integer.parseInt(String.valueOf(idx.charAt(i)));
                if(dungeons[index][0] <= heart) {
                    heart = heart - dungeons[index][1];
                    cnt++;
                } else {
                    break;
                }
            }
            if(max < cnt) {
                max = cnt;
            }
        }

        return max;
    }

    public void Recursion(String comp, String other, int length) {
        if(comp.length() == length) {
            strSet.add(comp);
        }
        for(int i = 0; i < other.length(); i++) {
            Recursion(comp + other.charAt(i), other.substring(0,i) + other.substring(i + 1), length);
        }

    }
}