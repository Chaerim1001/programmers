import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> c_map = new HashMap<>();
        
        for(String[] c: clothes) {
            if(c_map.containsKey(c[1])) {
                c_map.replace(c[1], c_map.get(c[1]) + 1);
            } else {
                c_map.put(c[1], 1);
            }
        }

        int answer = 1;
        for(int num : c_map.values()) {
            answer *= (num + 1);
        }

        return answer - 1;
        
    }
}