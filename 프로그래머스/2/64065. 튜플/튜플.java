import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int temp = 0;
        List<Node> counts = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            counts.add(new Node(i, 0));
        }
        
        for (char c : s.toCharArray()) {
            if (0 <= c - '0' && c - '0' <= 9) {
                temp = temp * 10 + (c - '0');
            } else if (temp != 0) {
                counts.get(temp).count++;
                temp = 0;
            }
        }
        
        Collections.sort(counts);
        List<Integer> answer = new ArrayList<>();
        for (Node node : counts) {
            if (node.count == 0) break;
            answer.add(node.number);
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}

class Node implements Comparable<Node> {
    
    int number;
    int count;
    
    Node(int number, int count) {
        this.number = number;
        this.count = count;
    }
    
    public int compareTo(Node other) {
        return other.count - this.count;
    }
}
/*
입력된 것에서 온전히 숫자만 추출하고 숫자별 등장 횟수를 카운팅하면
가장 많이 등장한 수부터 튜플의 앞쪽에 위치한다.

숫자가 0부터 시작하는 경우는 없으므로

문자열을 순회하며

temp = 0
char - '0' 값이 1 ~ 9 사이인 경우를 찾으면

temp = 10 * temp + (char - '0');

그러다가 아닌 경우를 만나면 지금까지 계산된 temp
가 등장한 숫자라는 의미
*/