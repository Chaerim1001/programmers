// https://school.programmers.co.kr/learn/courses/30/lessons/12906
import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for(int num : arr){
            if(!stack.empty()) {
                if(stack.peek() != num) {
                    stack.push(num);
                }
            } else {
                stack.push(num);
            }
        }
        
        int[] result = stack.stream().mapToInt(i->i).toArray();
        return result;
    }
    // 정확성: 71.9
    // 효율성: 28.1


    // 다른 사람의 풀이
    public int[] solution2(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num; 
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }
    // 정확성 및 효율성은 동일하지만 실제 테스트 시간에서 차이가 많이 난다.
}