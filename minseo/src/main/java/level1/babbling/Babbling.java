package level1.babbling;

public class Babbling {
    public static void main(String[] args) {
        Solution so = new Solution();
        so.solution(new String[]{"aya", "yee", "u", "maa"});
        so.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
    }
}

class Solution {
    public int solution(String[] babbling) {
        int count = 0;

        for(String s : babbling){
            s = s.replaceAll("ayaaya|yeye|woowoo|mama","*");
            s = s.replaceAll("aya|ye|woo|ma","/");

            System.out.println(s);
            if(s.equals("")){
                count++;
            }
        }
            return count;

    }

}
