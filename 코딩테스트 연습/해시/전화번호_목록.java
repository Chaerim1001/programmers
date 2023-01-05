import java.util.Arrays;

class Solution {
    // 첫 번째 풀이: 길이 순으로 정렬 후 반복문 돌면서 비교
    // 효율성 테스트 3,4 시간 초과
        public boolean solution1(String[] phone_book) {
            Arrays.sort(phone_book, (String s1, String s2) -> s1.length() - s2.length());
            
            for(int i = 0; i < phone_book.length; i++) {
                for(int j = i + 1; j < phone_book.length; j++) {
                    if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])){
                        return false;
                    }
                }
            }

            return true;
        }

        // 두 번째 풀이: 같은 전화번호 중복이 없으니 길이 체크 추가
        // 첫 번째 풀이보다는 정확성 테스트의 전체적인 시간이 줄었지만 여전히 효율성 테스트 3,4 시간 초과
        public boolean solution2(String[] phone_book) {
            Arrays.sort(phone_book, (String s1, String s2) -> s1.length() - s2.length());
            
            for(int i = 0; i < phone_book.length; i++) {
                for(int j = i + 1; j < phone_book.length; j++) {
                    if(phone_book[j].length() > phone_book[i].length()) { // 같은 전화번호 중복이 없으니까
                        if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])){
                            return false;
                        }
                    }
                }
            }

            return true;
        }

        // 세 번째 풀이: substring이 아닌 startsWith 메소드 사용 
        // 두 번째 풀이보다는 정확성 테스트의 전체적인 시간이 줄었지만 여전히 효율성 테스트 3,4 시간 초과
        public boolean solution3(String[] phone_book) {
            Arrays.sort(phone_book, (String s1, String s2) -> s1.length() - s2.length());
            
            for(int i = 0; i < phone_book.length; i++) {
                for(int j = i + 1; j < phone_book.length; j++) {
                    if(phone_book[j].length() > phone_book[i].length()) {
                        if(phone_book[j].startsWith(phone_book[i])) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }

        // 네 번째 풀이: 길이 순으로 정렬하는 것이 아니라 숫자로 정렬
        // 성공!
        public boolean solution4(String[] phone_book) {
            Arrays.sort(phone_book);
            
            for(int i = 0; i+1 < phone_book.length; i++) {
                if(phone_book[i+1].startsWith(phone_book[i])) {
                    return false;
                }
            }

            return true;
        }

    }

