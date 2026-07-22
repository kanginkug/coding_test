import java.util.HashSet;
class Solution {
    HashSet<Integer> numSet = new HashSet<>();
    int answer = 0;
    // 19시 51분
    public int solution(String numbers) {


        recursive("", numbers);
        int answer = Prime(numSet);
        System.out.println(numSet.toString());
        return answer;
    }

    public int Prime(HashSet<Integer> numSet) {
        for(int num : numSet) {
            if(num != 1 && num != 0) {
                boolean isPrime = true;
                int a = num/2+1;
                for(int i = 2; i < a; i++) {
                    if(num%i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public void recursive(String a, String b) {
        if(!a.isEmpty()) {
            numSet.add(Integer.parseInt(a));
        }
        for(int i = 0; i < b.length(); i++) {
            recursive(a + b.charAt(i), b.substring(0,i) + b.substring(i+1));
        }
    }
}