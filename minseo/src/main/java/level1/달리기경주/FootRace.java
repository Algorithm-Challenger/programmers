package level1.달리기경주;

import java.util.*;

public class FootRace {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.solution(
        new String[]{"mumu", "soe", "poe", "kai", "mine"},
        new String[]{"kai", "kai", "mine", "mine"});
  }
}

class Solution {
  public String[] solution(String[] players, String[] callings) {

    Map<String, Integer> playersMap = new HashMap<>();
    for(int i=0; i<players.length; i++) playersMap.put(players[i], (i+1));

    for(int i=0; i<callings.length; i++) {
      String temp = "";
      temp = players[playersMap.get(callings[i])-2];
      players[playersMap.get(callings[i])-2] = players[playersMap.get(callings[i])-1];
      players[playersMap.get(callings[i])-1] = temp;

      playersMap.put(callings[i], playersMap.get(callings[i])-1);
      playersMap.put(temp, playersMap.get(temp)+1);

    }
    return players;
  }
}