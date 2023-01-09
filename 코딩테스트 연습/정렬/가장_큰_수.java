import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberString = new String[numbers.length];

        for(int i=0; i< numbers.length; i++) {
            numberString[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numberString, (n1, n2) -> -(n1+n2).compareTo(n2+n1));

        for(String num : numberString) {
            answer += num;
        }

        answer = answer.replaceAll("^0+", "");
        if(answer.length() == 0) {
            answer = "0";
        }

        return answer;
    }


// 문자열을 합칠 때에는 StringBuilder()를 쓰면 성능이 더 좋아진다는 글을 보고 수정한 답안
    public String solution2(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] numberString = new String[numbers.length];

        for(int i=0; i< numbers.length; i++) {
            numberString[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numberString, (n1, n2) -> -(n1+n2).compareTo(n2+n1));

        for(String num : numberString) {
            answer.append(num);
        }

        if(answer.toString().replaceAll("^0+", "").length() == 0) {
            return "0";
        }

        return answer.toString();
    }

    // 다른 사람의 풀이
    public String solution_other1(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i=0; i<nums.length; i++) 
            nums[i] = numbers[i] + "";

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        String ans = "";
        for (int i=0; i<numbers.length; i++)
            ans += nums[i];

        return ans.charAt(0) == '0' ? "0" : ans;
    }
}
