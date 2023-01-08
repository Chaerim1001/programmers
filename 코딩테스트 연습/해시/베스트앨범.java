import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;



class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> total_plays = new HashMap<>();
        Map<String, Map<Integer, Integer>> play_map = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if(total_plays.containsKey(genres[i])) {
                total_plays.put(genres[i], total_plays.get(genres[i]) + plays[i]);
                play_map.get(genres[i]).put(i, plays[i]);
            } else {
                total_plays.put(genres[i], plays[i]);
                Map<Integer, Integer> tmp = new HashMap<>();
                tmp.put(i, plays[i]);
                play_map.put(genres[i], tmp);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(total_plays.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<String, Integer> entry : entryList){
            List<Map.Entry<Integer, Integer>> entryList2 = new ArrayList<>(play_map.get(entry.getKey()).entrySet());
            entryList2.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            
            if(entryList2.size() > 1){
                result.add(entryList2.get(0).getKey());
                result.add(entryList2.get(1).getKey());
            } else {
                result.add(entryList2.get(0).getKey());
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] solution2(String[] genres, int[] plays) {
        HashMap<String, Object> genresMap = new HashMap<String, Object>();      //<장르, 곡 정보> 
        HashMap<String, Integer> playMap = new HashMap<String, Integer>(); //<장르, 총 장르 재생수>
        ArrayList<Integer> resultAL = new ArrayList<Integer>();

        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            HashMap<Integer, Integer> infoMap;       // 곡 정보 : <곡 고유번호, 재생횟수>

            if(genresMap.containsKey(key)){
                 infoMap = (HashMap<Integer, Integer>)genresMap.get(key);
            }
            else {
                infoMap = new HashMap<Integer, Integer>();
            }

            infoMap.put(i, plays[i]);
            genresMap.put(key, infoMap);

            //재생수
            if(playMap.containsKey(key)){
                playMap.put(key, playMap.get(key) + plays[i]);
            }
            else {
                playMap.put(key, plays[i]);
            }
        }

        int mCnt = 0;
        Iterator it = sortByValue(playMap).iterator();

        while(it.hasNext()){
            String key = (String)it.next();
            Iterator indexIt = sortByValue((HashMap<Integer, Integer>)genresMap.get(key)).iterator();
            int playsCnt = 0;

            while(indexIt.hasNext()){
                resultAL.add((int)indexIt.next());
                mCnt++;
                playsCnt++;
                if(playsCnt > 1) break;
            }
        }

        int[] answer = new int[resultAL.size()];

        for(int i = 0; i < resultAL.size(); i++){
            answer[i] = resultAL.get(i).intValue();
        }

        return answer;
    }

    private ArrayList sortByValue(final Map map){
        ArrayList<Object> keyList = new ArrayList();
        keyList.addAll(map.keySet());

        Collections.sort(keyList, new Comparator(){
            public int compare(Object o1, Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });

        return keyList;
    }
}