package level2.N개의최소공배수;

public class NLeastCommonMultiple {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.solution(new int[]{2,6,8,14});
  }
}
class Solution {
  public int solution(int[] arr) {
    int answer = arr[0];
    for (int i = 1; i < arr.length; i++) {
      answer = getLCM(answer, arr[i]);
    }
//    System.out.println(answer);
    return answer;
  }

  public int getGCD(int a, int b) { // 최대공약수 구하는 메소드
    while (b > 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  public int getLCM(int a, int b) { // 최소공배수 구하는 메소드
    return a * b / getGCD(a, b);
  }
}

