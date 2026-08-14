import java.util.ArrayList;
class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 1. str1 다중집합 생성 (순수 영문자 쌍만 추가)
        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if (isAlpha(a) && isAlpha(b)) {
                list1.add("" + a + b);
            }
        }

        // 2. str2 다중집합 생성 (순수 영문자 쌍만 추가)
        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            if (isAlpha(a) && isAlpha(b)) {
                list2.add("" + a + b);
            }
        }

        // 3. 두 집합 모두 공집합인 경우 예외 처리
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        // 4. 교집합 및 합집합 계산
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        for (String s : list1) {
            // list2에 s가 포함되어 있다면 교집합에 추가 후 list2에서 1개 제거
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        // list2에 남아있는 원소들을 합집합에 마저 추가
        union.addAll(list2);

        // 5. 자카드 유사도 계산 후 65536 곱하기
        double similarity = (double) intersection.size() / union.size();
        return (int) (similarity * 65536);
    }

    // 영문 대문자인지 확인하는 헬퍼 메서드
    private boolean isAlpha(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}