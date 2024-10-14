import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] temp = operation.split(" ");
            
            String op = temp[0];
            int number = Integer.parseInt(temp[1]);
            
            if (op.equals("I")) {
                if (min.isEmpty()) {
                    min.add(number);
                } else if (min.peek() > number) {
                    while (!min.isEmpty()) {
                        max.add(min.poll());
                    }
                    min.add(number);
                } else {
                    max.add(number);
                }
            } else {
                if (number == -1) {
                    if (!min.isEmpty()) min.poll();
                    else {
                        while (!max.isEmpty()) {
                            min.add(max.poll());
                        }
                        min.poll();
                        while (!min.isEmpty()) {
                            max.add(min.poll());
                        }
                    }
                } else {
                    if (!max.isEmpty()) max.poll();
                    else {
                        while (!min.isEmpty()) {
                            max.add(min.poll());
                        }
                        max.poll();
                        while (!max.isEmpty()) {
                            min.add(max.poll());
                        }
                    }
                }
            }
        }
        
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        while (!min.isEmpty()) {
            int number = min.poll();
            minNum = Math.min(minNum, number);
            maxNum = Math.max(maxNum, number);
        }
        
        while (!max.isEmpty()) {
            int number = max.poll();
            minNum = Math.min(minNum, number);
            maxNum = Math.max(maxNum, number);
        }
        
        if (maxNum == Integer.MIN_VALUE || minNum == Integer.MAX_VALUE) {
            maxNum = 0; 
            minNum = 0;
        }
        
        int[] answer = {maxNum, minNum};
        return answer;
    }

}
/*
min

max

*/