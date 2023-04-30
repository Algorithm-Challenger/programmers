package kakao.winter_internship_2019.크레인인형뽑기;

import java.util.Stack;

public class ClawCraneGame {
  public static void main(String[] args) {
    Solution so = new Solution();
    Solution2 so2 = new Solution2();
    long startTime = System.nanoTime();


    so.solution(new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}}
        , new int[]{1, 5, 3, 5, 1, 2, 1, 4});
    long endTime = System.nanoTime();
    long durationTimeSec = endTime - startTime;

    long startTime2 = System.nanoTime();
    so2.solution(new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}}
        , new int[]{1, 5, 3, 5, 1, 2, 1, 4});
    long endTime2 = System.nanoTime();
    long durationTimeSec2 = endTime2 - startTime2;

    System.out.println(durationTimeSec + "n/s");
    System.out.println(durationTimeSec2 + "n/s");
  }
}

class Solution {
  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    Stack[] game = new Stack[board[0].length];
    Stack<Integer> bag = new Stack<>();
    for (int i = 0; i < board[0].length; i++)
      game[i] = new Stack<Integer>();


    for (int i = board.length - 1; i >= 0; i--) {
      for (int j = 0; j < board[0].length; j++)
        if (board[i][j] != 0)
          game[j].push(board[i][j]);
    }

    for (int i = 0; i < moves.length; i++) {
      if (game[moves[i] - 1].empty())
        continue;
      int number = (int) game[moves[i] - 1].pop();
//      if (bag.empty())
//        System.out.printf("%d empty\n", number);
//      else
//        System.out.printf("%d %d\n", number, bag.peek());
      if (bag.size() == 0)
        bag.push(number);
      else {
        if (number == bag.peek()) {
          answer += 2;
          bag.pop();
        } else
          bag.push(number);
      }
    }
//    System.out.println(answer);
    return answer;
  }
}

class Solution2 {
  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    for (int move : moves) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][move - 1] != 0) {
          if (stack.isEmpty()) {
            stack.push(board[j][move - 1]);
            board[j][move - 1] = 0;
            break;
          }
          if (board[j][move - 1] == stack.peek()) {
            stack.pop();
            answer += 2;
          } else
            stack.push(board[j][move - 1]);
          board[j][move - 1] = 0;
          break;
        }
      }
    }
    return answer;
  }
}