package kakao.blind_recruitment_2018.비밀지도;

import java.util.Arrays;

public class EncryptedMap {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
  }

}

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i = 0; i < n; i++) {
      int map = arr1[i] | arr2[i];
      answer[i] = Integer.toBinaryString(map);
      answer[i] = String.format("%" + n + "s", answer[i]);
      answer[i] = answer[i].replace("0", " ");
      answer[i] = answer[i].replace("1", "#");
    }
    System.out.println(Arrays.toString(answer));
    return answer;
  }
}