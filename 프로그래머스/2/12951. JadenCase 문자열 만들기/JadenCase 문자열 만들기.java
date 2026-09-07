class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if(i == 0 || s.charAt(i - 1) == ' ') {
                    String changeStr = String.valueOf(s.charAt(i)).toUpperCase();
                    sb.append(changeStr);
                } else {
                    String changeStr = String.valueOf(s.charAt(i)).toLowerCase();
                    sb.append(changeStr);
                }
            }

        return sb.toString();
    }
}