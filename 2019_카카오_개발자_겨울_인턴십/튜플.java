// https://school.programmers.co.kr/learn/courses/30/lessons/64065
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public ArrayList<Integer> solution(String s) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		String str[] = s.substring(2, s.length() - 2).replace("},{", "-").split("-");
		
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String o1, String o2) {

				return Integer.compare(o1.length(), o2.length());
			}
		});
		for (String x : str) {
			String[] tmp = x.split(",");
			for (int i = 0; i < tmp.length; i++) {
				int n = Integer.parseInt(tmp[i]);
				if (!answer.contains(n))
					answer.add(n);
			}
		}
		return answer;
    }

    // 다른 사람의 풀이
    public int[] solution_other1(String s) {

        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String n = matcher.group();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }

    public int[] solution_other2(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}