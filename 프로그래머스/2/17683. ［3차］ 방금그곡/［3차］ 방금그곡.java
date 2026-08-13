class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;
        m = replace(m);
        for(int i = 0; i < musicinfos.length; i++) {
            String musicinfo = musicinfos[i];
            String[] musicinfoArr = musicinfo.split(",");
            String startStr = musicinfoArr[0];
            String endStr = musicinfoArr[1];
            String title = musicinfoArr[2];
            String alphabet = musicinfoArr[3];
            String replAlphabet = replace(alphabet);

            String[] startArr = startStr.split(":");
            String[] endArr = endStr.split(":");
            int startTime = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
            int endTime = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);
            int diffTime = endTime - startTime;
            int inx = 0;
            StringBuilder sb = new StringBuilder();
            for(int x = 0; x < diffTime; x++) {
                if(inx == replAlphabet.length()) {
                    inx = 0;
                }
                sb.append(replAlphabet.charAt(inx));
                inx++;
            }
            if(sb.toString().contains(m)){
                if(time == 0) {
                    time = diffTime;
                    answer = title;
                } else {
                    if(time < diffTime) {
                        time = diffTime;
                        answer = title;
                    }
                }
            }
        }
        return answer;
    }
    
    public String replace(String str) {
        str = str.replace("C#","c");
        str = str.replace("D#","d");
        str = str.replace("F#","f");
        str = str.replace("G#","g");
        str = str.replace("A#","a");
        return str;

    }
}