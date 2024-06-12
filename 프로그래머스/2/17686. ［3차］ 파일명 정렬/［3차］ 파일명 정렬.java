import java.util.*;

class Solution {    
    
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        int order = 0;
        for (String file : files) {
            File f = new File(file, order++);
            fileList.add(f);
        }
        
        Collections.sort(fileList);
        
        String[] answer = new String[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            answer[i] = file.toString();
        }
    
        return answer;
    }
    
    class File implements Comparable<File> {
        String head = "";
        String number = "";
        String tail = "";
        int order;
        
        public File(String fileName, int order) {
            char[] chars = fileName.toCharArray();
            
            int idx = 0;
            while (idx < chars.length && !('0' <= chars[idx] && chars[idx] <= '9')) {
                head += chars[idx];
                idx++;
            }
            
            while (idx < chars.length && ('0' <= chars[idx] && chars[idx] <= '9')) {
                number += chars[idx];
                idx++;
            }
            
            while (idx < chars.length) {
                tail += chars[idx];
                idx++;
            }
            
            this.order = order;
        }
        
        public int compareTo(File other) {
            // head
            if (!this.head.equalsIgnoreCase(other.head)) {
                return this.head.compareToIgnoreCase(other.head);
            }
            
            int thisNumber = Integer.parseInt(this.number);
            int otherNumber = Integer.parseInt(other.number);
            if (thisNumber != otherNumber) {
                return thisNumber - otherNumber;
            }
            
            return this.order - other.order;
        }
        
        public String toString() {
            return this.head + this.number + this.tail;
        }
    }
}

/*
HEAD -> 숫자가 등장하는 최초 위치 이전까지
NUMBER -> 숫자가 등장한 최초 위치부터 숫자가 아닌 문자가 등장하는 위치 이전까지
TAIL -> 나머지
*/