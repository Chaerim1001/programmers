import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean solution(String s) {
        List<Character> arr = new ArrayList<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                arr.add(c);
            }else {
               if(arr.size() < 1) {
                return false;
               }
               else {
                arr.remove(arr.size() - 1);
               }
            }
        }

        if(arr.size() == 0){
            return true;
        } else {
            return false;
        }
    }

    // 다른 사람의 풀이
    boolean solution2(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    } 
    // 변수가 두가지이므로 ArrayList 사용하지 않고 count 값으로 체크해도 된다는 것 기억하기!
}


