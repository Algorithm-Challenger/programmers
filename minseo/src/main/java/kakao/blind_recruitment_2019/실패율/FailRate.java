package kakao.blind_recruitment_2019.실패율;

import java.util.*;

public class FailRate {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
  }
}


class Stage implements Comparable<Stage> {
  int stageNum;
  double failureRate;

  public Stage(int stageNum, double failureRate) {
    this.stageNum = stageNum;
    this.failureRate = failureRate;
  }

  public int compareTo(Stage s) {
    if (this.failureRate == s.failureRate) {
      return this.stageNum - s.stageNum;
    } else {
      return Double.compare(s.failureRate, this.failureRate);
    }
  }
}

class Solution {
  public int[] solution(int N, int[] stages) {
    int[] stageUsers = new int[N + 2];
    for (int i = 0; i < stages.length; i++) {
      stageUsers[stages[i]]++;
    }
    int totalUsers = stages.length;
    List<Stage> failureRates = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      double failureRate = 0.0;
      if (stageUsers[i] != 0) {
        failureRate = (double) stageUsers[i] / totalUsers;
      }
      failureRates.add(new Stage(i, failureRate));
      totalUsers -= stageUsers[i];
    }
    Collections.sort(failureRates);
    int[] answer = new int[N];
    for (int i = 0; i < N; i++) {
      answer[i] = failureRates.get(i).stageNum;
    }
    return answer;
  }
}

