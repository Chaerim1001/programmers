// https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=java
class Solution {
    public int[] solution(String s) {
        int[] result = {0, 0};
            
       while(!s.equals("1")) {
            String number = "";
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    result[1]++;
                } else {
                    number = number + s.charAt(i);
                }
            }

            s = Integer.toBinaryString(number.length());
            result[0]++;
        }
        
        return result;
    }
}

// 다른 사람 풀이
class Solution2 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp); 
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;  
    }
}