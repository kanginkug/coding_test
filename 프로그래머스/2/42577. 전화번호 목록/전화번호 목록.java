import java.util.Arrays;
import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(phone_book));
        for(int i = 0; i < phone_book.length; i++) {
            String str = phone_book[i];
            for(int x = 1; x < str.length(); x++) {
                String subStr = str.substring(0,x);
                if(hashSet.contains(subStr)) {
                    return false;
                }
            }
        }
        return true;
    }
}