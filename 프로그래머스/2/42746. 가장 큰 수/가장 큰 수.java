import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));
        if(arr[0].equals("0")){
            return "0";
        }
        for(String str : arr){
            answer.append(str);
        }
        return answer.toString();
    }
}