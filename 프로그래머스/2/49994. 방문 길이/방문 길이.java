import java.util.HashSet;
class Solution {
    HashSet<String> hashSet = new HashSet<>();
    public int solution(String dirs) {
        int[] standard = {0,0};
        for(int i = 0; i < dirs.length(); i++) {

            int[] before = new int[2];
            int[] after = new int[2];
            if(dirs.charAt(i) == 'U' && standard[1] + 1 <= 5) {
                before = new int[]{standard[0], standard[1]};
                standard[1]+= 1;
                after = new int[]{standard[0], standard[1]};
                addHashSet(before, after);
            } else if(dirs.charAt(i) == 'D' && standard[1] -1  >= -5) {
                before = new int[]{standard[0], standard[1]};
                standard[1]-= 1;
                after = new int[]{standard[0], standard[1]};
                addHashSet(before, after);
            } else if(dirs.charAt(i) == 'R'&& standard[0] + 1 <= 5) {
                before = new int[]{standard[0], standard[1]};
                standard[0]+= 1;
                after = new int[]{standard[0], standard[1]};
                addHashSet(before, after);
            } else if(dirs.charAt(i) == 'L' && standard[0] -1  >= -5) {
                before = new int[]{standard[0], standard[1]};
                standard[0]-= 1;
                after = new int[]{standard[0], standard[1]};
                addHashSet(before, after);
            }
        }
        return hashSet.size()/2;
    }
    public void addHashSet(int[] before, int[] after) {
        String hashStr = "";
        String hashStr2 = "";
        hashStr2 = String.valueOf(before[0]) + "," + String.valueOf(before[1]) + "->" + String.valueOf(after[0]) + "," + String.valueOf(after[1]);
        hashStr = String.valueOf(after[0]) + "," + String.valueOf(after[1]) + "->" + String.valueOf(before[0]) + "," + String.valueOf(before[1]);
        hashSet.add(hashStr);
        hashSet.add(hashStr2);
    }
}