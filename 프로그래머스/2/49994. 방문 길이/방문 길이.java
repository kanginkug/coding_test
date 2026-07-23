import java.util.HashSet;
class Solution {
    public int solution(String dirs) {
        HashSet<String> hashSet = new HashSet<>();
        int[] standard = {0,0};
        for(int i = 0; i < dirs.length(); i++) {
            String beforeStand = "";
            String afterStand = "";
            if(dirs.charAt(i) == 'U' && standard[1]+1 <= 5) {
                beforeStand = String.valueOf(standard[0]) + standard[1];
                standard[1] += 1;
                afterStand = String.valueOf(standard[0]) + standard[1];
                hashSet.add(beforeStand + "," + afterStand);
                hashSet.add(afterStand + "," + beforeStand);
            } else if(dirs.charAt(i) == 'D' && standard[1]-1 >= -5) {
                beforeStand = String.valueOf(standard[0]) + standard[1];
                standard[1] -= 1;
                afterStand = String.valueOf(standard[0]) + standard[1];
                hashSet.add(beforeStand + "," + afterStand);
                hashSet.add(afterStand + "," + beforeStand);
            } else if(dirs.charAt(i) == 'R' && standard[0]+1 <= 5) {
                beforeStand = String.valueOf(standard[0]) + standard[1];
                standard[0] += 1;
                afterStand = String.valueOf(standard[0]) + standard[1];
                hashSet.add(beforeStand + "," + afterStand);
                hashSet.add(afterStand + "," + beforeStand);
            }else if(dirs.charAt(i) == 'L' && standard[0]-1 >= -5) {
                beforeStand = String.valueOf(standard[0]) + standard[1];
                standard[0] -= 1;
                afterStand = String.valueOf(standard[0]) + standard[1];
                hashSet.add(beforeStand + "," + afterStand);
                hashSet.add(afterStand + "," + beforeStand);
            }
        }
        return hashSet.size()/2;
    }
}