//  https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    // 첫 번째 풀이 : ArrayList 사용
    // 효율성 테스트 시간 초과
    public String solution1(String[] participant, String[] completion) {
        List<String> participant_list = new ArrayList<>(Arrays.asList(participant));
       
        for(String c : completion) {
            participant_list.remove(participant_list.indexOf(c));
           }
       
        return participant_list.get(0);
    }

    // 두 번째 풀이 : HashMap 사용
    // 성공
    public String solution2(String[] participant, String[] completion) {
        Map<String, Integer> completion_map = new HashMap<>();

        for (String c : completion) {
            if(completion_map.containsKey(c)) {
                completion_map.put(c, completion_map.get(c) + 1);
            } else{
            completion_map.put(c, 1);
            }
        }

        String result = "";

        for(int i = 0; i < participant.length; i++) {
            if(!completion_map.containsKey(participant[i])) {
                result = participant[i];
                break;
            } else if(completion_map.get(participant[i]) == 0) {
                result = participant[i];
                break;
            } else {
                completion_map.replace(participant[i], completion_map.get(participant[i]) - 1);
            }

            if(i == participant.length -1) {
                result = participant[i];
            }
        }
        return result;
    }

    // 다른 사람 풀이 1
    public String solution_other1(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        // 참가자의 이름별 명단을 맵에 담음
        for (String p:participant)  {
            if(map.get(p) != null){
                map.put(p, map.get(p) + 1);
            }else{
                map.put(p,1);
            }
        }
        // 완주자의 리스트 만큼 명단에서 cnt 를 낮춤
        for (String c:completion){
            if(map.get(c) != 0) {
                map.put(c, map.get(c) - 1);
            }
        }
        // map 중 값이 0이 아닌 key 만 answer 에 담음
        List<String> list = new ArrayList<>();
        Iterator<String> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            if(map.get(key) != 0) {
                for(int i = 0; i < map.get(key); i++) {
                    list.add(key);
                }
            } 
        }
        String answer = list.get(0);
        return answer;
    }

    // 다른 사람 풀이 2
    public String solution_other2(String[] participant, String[] completion) {

        Map<String, Long> participantMap = Arrays.asList(participant).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String name : completion) {

            Long value = participantMap.get(name) - 1L;

            if(value == 0L) {
                participantMap.remove(name);
            } else {
                participantMap.put(name, value);
            }
        }

        return participantMap.keySet().iterator().next();
    }
}