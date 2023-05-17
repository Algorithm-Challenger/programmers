package kakao.blind_recruitment_2021.신규아이디추천;

public class RecommendNewId {
    public static void main(String[] args) {
        Solution2 so = new Solution2();
//        so.solution("...!@BaT#*..y.abcdefghijklm...");
//        so.solution("");
        so.solution2("\"z-+.^.\"");
    }
}

class Solution {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();

        new_id = new_id.toLowerCase();

        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);

            if (Character.isAlphabetic(ch) ||
                    Character.isDigit(ch) ||
                    ch == '.' ||
                    ch == '-' ||
                    ch == '_') {
                answer.append(ch);
            }
        }

        while (answer.toString().contains("..")) {
            answer = new StringBuilder(answer.toString().replace("..", "."));
        }

        if ((answer.length() > 0) && answer.charAt(0) == '.') {
            answer = new StringBuilder(answer.substring(1));
        }

        if ((answer.length() > 0) && answer.charAt(answer.length() - 1) == '.') {
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        }

        if (answer.length() == 0) {
            answer = new StringBuilder("a");
        }

        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
            }
        }

        //while 보다 속도가 느리다
//        if (answer.length() < 3) {
//            do {
//                answer += answer.charAt(answer.length() - 1);
//                System.out.println(answer.length());
//            } while (answer.length() < 3);
//        }

        if (answer.length() < 3) {
            while (!(answer.length() == 3)) {
                answer.append(answer.charAt(answer.length() - 1));
                System.out.println(answer.length());
            }
        }


        System.out.println(answer);
        return answer.toString();
    }
}

//정규식 사용
class Solution2 {
    public String solution2(String new_id) {
        String answer = "";

        return answer;
    }
}