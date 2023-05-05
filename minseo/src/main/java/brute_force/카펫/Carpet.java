package brute_force.카펫;

import java.util.Arrays;

//level 2
public class Carpet {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.solution(10, 2);
  }
}

class Solution {
  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
    int total = brown + yellow;

    for (int i = 3; i <= (int) Math.sqrt(total); i++) {
      if (total % i == 0) {
        int j = total / i;
        int yellowCount = (i - 2) * (j - 2);
        if (yellow == yellowCount) {
          answer[0] = j;
          answer[1] = i;
          break;
        }
      }
    }
    System.out.println(Arrays.toString(answer));
    return answer;
  }
}
