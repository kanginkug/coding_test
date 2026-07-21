import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        String[] numStr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numStr,(a,b) -> (b+a).compareTo(a+b));
        if(numStr[0].equals("0")) {
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        for(String str : numStr) {
            answer.append(str);
        }
        return String.valueOf(answer);
    }
}