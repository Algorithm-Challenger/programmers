package kakao.blind_recruitment_2018.다트게임;

import static java.lang.Math.*;

public class DartGame {
    public static void main(String[] args) {
        Solution so = new Solution();
        so.solution("1S2D*3T");
    }
}



class Solution {

    public int solution(String dartResult) {
        String[] numbers = dartResult.split("\\D+"); //1, 2, 3
        String[] options = dartResult.split("\\d+"); // ,S, D*, T
//        System.out.println(Arrays.toString(numbers));
        int[] scores = new int[numbers.length];
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            scores[i] = Integer.parseInt(numbers[i]);
            scores[i] = options[i + 1].startsWith("S") ?
                    scores[i] : (int) (options[i + 1].startsWith("D") ?
                    pow(scores[i], 2) : pow(scores[i], 3)
            );
            if (options[i + 1].length() > 1) {
                if (options[i + 1].endsWith("*")) {
                    if (i == 0) {
                        scores[i] *= 2;
                    } else {
                        scores[i] *= 2;
                        scores[i - 1] *= 2;
                    }
                } else {
                    scores[i] *= -1;
                }
            }
        }
        for (int score : scores) {
            answer += score;
        }
        return answer;
    }

}