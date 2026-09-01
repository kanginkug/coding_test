import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String dartResult) {
        List<Character> strList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < dartResult.length(); i++) {
            strList.add(dartResult.charAt(i));
        }
        for(int i = 0; i < strList.size(); i++) {
            if(strList.get(i) >= 'A' && strList.get(i) <= 'Z') {
                int num = Integer.parseInt(String.valueOf(strList.get(i-1)));
                if(i>=2) {
                    try {
                        if(Integer.parseInt(String.valueOf(strList.get(i-2))) > 0) {
                            num = Integer.parseInt(String.valueOf(strList.get(i-2) + String.valueOf(strList.get(i-1))));
                        }
                    } catch (Exception ignored) {
                    }
                }
                if(strList.get(i) == 'S') {
                    list.add(String.valueOf(num));
                } else if(strList.get(i) == 'D') {
                    list.add(String.valueOf(num * num));
                } else if(strList.get(i) == 'T') {
                    list.add(String.valueOf(num * num * num));
                }
            } else if(strList.get(i) == '*' || strList.get(i) == '#') {
                list.add(String.valueOf(strList.get(i)));
            }
        }
        Integer[] arr = new Integer[list.size()];
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("*") || list.get(i).equals("#")) {
                arr[i] = null;
            } else {
                arr[i] = Integer.parseInt(list.get(i));
            }
        }
        int answer = 0;
        System.out.println(list);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("*")) {
                arr[i-1] = Integer.parseInt(list.get(i-1))*2;
                if(i >= 2) {
                    if(arr[i-2] != null) {
                        arr[i-2] = Integer.parseInt(list.get(i-2))*2;
                    } else {
                        if(i-3 >= 0 && arr[i-3] != null) {
                            arr[i-3] = arr[i-3]*2;
                        }
                    }
                }
            } else if(list.get(i).equals("#")) {
                arr[i-1] = Integer.parseInt(list.get(i-1))*-1;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                answer += arr[i];
            }
        }
        return answer;
    }
}