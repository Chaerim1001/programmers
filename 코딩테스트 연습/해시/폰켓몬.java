import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        Set<Integer> set = new HashSet<Integer>();

        for(int num : nums) {
            set.add(num);
        }
        
        if(set.size() > answer) {
            return answer;
        } else {
            return set.size();
        } 
    }
}

// 댓글 중에서
// hashset: value를 자바에서 자동으로 임의 지정하며 key에 중복을 배제하고 값을 넣음. hashmap: key와 value를 개발자가 직접 기입하고 키의 중복을 배제함. 이때 hash는 키를 이용해서 값을 찾기 때문에 검색 알고리즘에 매우 효율적. arraylist: 사용자가 정의한 <제너릭>객체에 맞는 값을 넣어 저장하고 중복 삽입이 가능 단, 수정 변경시 배열을 새로 생성해서 배열채로 집어넣기에 수정이 상대적으로 느림. 또한 키로 값을 찾을 수 없기에 검색 알고리즘에 매우 느린 속도를 자랑함 단, foreach문에선 arraylist가 더 빠르다고 함...
