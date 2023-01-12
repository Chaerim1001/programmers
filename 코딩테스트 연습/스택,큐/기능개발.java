// https://school.programmers.co.kr/learn/courses/30/lessons/42586
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100F - progresses[i]) / speeds[i]);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        int count = 1;
        int target = days[0];
        
        for (int i = 1; i < days.length; i++) {
            if (target < days[i]) {
                target = days[i];
                answer.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}