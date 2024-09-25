class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int intLength = timeToInteger(video_len);
        int intPos = timeToInteger(pos);
        int intOpStart = timeToInteger(op_start);
        int intOpEnd = timeToInteger(op_end);
        

        
        for (String command : commands) {
            if (intOpStart <= intPos && intPos <= intOpEnd) {
                intPos = intOpEnd;
            }
            switch (command) {
                case "prev":
                    intPos = Math.max(intPos - 10, 0);
                    break;
                default:
                    intPos = Math.min(intPos + 10, intLength);
                    break;
            }
        }
        if (intOpStart <= intPos && intPos <= intOpEnd) {
            intPos = intOpEnd;
        }
        answer = timeToString(intPos);
        return answer;
    }
    
    String timeToString(int time) {
        int hour = time / 60;
        int minute = time % 60;
        
        String result = "";
        if (hour < 10) {
            result += "0";
        }
        result = result + hour + ":";
        
        if (minute < 10) {
            result += "0";
        }
        result = result + minute;
        return result;
    }
    
    int timeToInteger(String time) {
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]);
        int minute = Integer.parseInt(temp[1]);
        return hour * 60 + minute;
    }
}