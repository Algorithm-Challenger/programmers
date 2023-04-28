package level1.numberpartner;

public class NumberPartner {
    public static void main(String[] args) {
        Solution so = new Solution();

        so.solution("100","2030145");
    }
}
class Solution {
    public String solution(String x, String y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : x.toCharArray()) {
            countX[c - '0']++;
        }

        for (char c : y.toCharArray()) {
            countY[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();



        for (int i = 0; i < 10; i++) {
            int count = Math.min(countX[i], countY[i]);


            // X와 Y에서 모두 등장한 숫자만 고려
            sb.append(String.valueOf(i).repeat(Math.max(0, count)));

        }

        if (sb.length() == 0) {
            return "-1";
        }

        if(sb.reverse().toString().charAt(0)==0){
            return "0";
        }




        return sb.reverse().toString();
    }
}

