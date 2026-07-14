import java.util.Arrays;
import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        // 1. 모든 전화번호를 HashSet에 담습니다. (검색 속도를 O(1)로 만들기 위함)
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        // 2. 각 전화번호의 접두어가 HashSet에 있는지 확인합니다.
        for (String phone : phone_book) {
            // 본인 자신을 제외한 모든 접두어를 만듭니다.
            // 예: "1195"라면 "1", "11", "119" 순서로 잘라봅니다.
            for (int j = 1; j < phone.length(); j++) {
                String prefix = phone.substring(0, j);
                
                // 자른 접두어가 HashSet에 들어있다면? 누군가의 접두어라는 뜻!
                if (set.contains(prefix)) {
                    System.out.println(false);
                    return false;
                }
            }
        }
        System.out.println(true);
        return true;
    }
}