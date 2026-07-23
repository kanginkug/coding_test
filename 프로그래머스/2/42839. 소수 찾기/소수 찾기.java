import java.util.HashSet;
class Solution {
    HashSet<Integer> hashSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        Recursive("", numbers);
        answer = Prime(hashSet);
        return answer;
    }
    public void Recursive(String comp, String other) {
        if(!comp.isEmpty()) {
            hashSet.add(Integer.parseInt(comp));
        }
        for(int i = 0; i < other.length(); i++) {
            Recursive(comp + other.charAt(i), other.substring(0,i) + other.substring(i+1));
        }
    }

    public int Prime(HashSet<Integer> hashSet) {
        int answer = 0;
        for(int num : hashSet) {
            if(num != 1 && num != 0) {
                boolean isPrime = true;
                for(int i = 2; i < (num/2+1); i++) {
                    if(num%i==0) {
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
}