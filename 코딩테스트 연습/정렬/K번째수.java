// https://school.programmers.co.kr/learn/courses/30/lessons/42748
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        List<Integer> list = new ArrayList<>();

        for(int num : array) {
            list.add(num);
        }

        for(int i = 0; i < commands.length; i++) {
            List<Integer> sub_arr = new ArrayList<>(list.subList(commands[i][0] - 1, commands[i][1]));
            sub_arr.sort(Comparator.naturalOrder());
            answer[i] = sub_arr.get(commands[i][2] - 1);
            
        }
        
        return answer;
       
    }


    // 다른 사람 풀이 : Arrays 사용
    public int[] solution_other(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}