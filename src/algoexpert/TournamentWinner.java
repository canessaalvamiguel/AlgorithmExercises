/*
Link to problem: https://www.algoexpert.io/questions/Tournament%20Winner
*  There's an algorithms tournament taking place in which teams of programmers
  compete against each other to solve algorithmic problems as fast as possible.
  Teams compete in a round robin, where each team faces off against all other
  teams. Only two teams compete against each other at a time, and for each
  competition, one team is designated the home team, while the other team is the
  away team. In each competition there's always one winner and one loser; there
  are no ties. A team receives 3 points if it wins and 0 points if it loses. The
  winner of the tournament is the team that receives the most amount of points.

  Given an array of pairs representing the teams that have competed against each
  other and an array containing the results of each competition, write a
  function that returns the winner of the tournament. The input arrays are named
  competitions and results, respectively. The competitions array has elements in the form of
  [homeTeam, awayTeam], where each team is a string of at most 30
  characters representing the name of the team. The results array
  contains information about the winner of each corresponding competition in the
  competitions array. Specifically, results[i] denotes
  the winner of competitions[i], where a 1 in the
  results array means that the home team in the corresponding
  competition won and a 0 means that the away team won.

  It's guaranteed that exactly one team will win the tournament and that each
  team will compete against all other teams exactly once. It's also guaranteed
  that the tournament will always have at least two teams.
* */

package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

     public static final Integer WINNER_HOME = 1;
     public static final Integer WINNER_AWAY = 0;

    public static void main(String[] args){
        ArrayList<String> c1 = new ArrayList<>();
        c1.add("HTML");
        c1.add("C#");

        ArrayList<String> c2 = new ArrayList<>();
        c2.add("C#");
        c2.add("Pyhton");

        ArrayList<String> c3 = new ArrayList<>();
        c3.add("Pyhton");
        c3.add("HTML");

        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.add(c1);
        competitions.add(c2);
        competitions.add(c3);

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);

        System.out.println("Method 1 winner: "+tournamentWinner_method1(competitions, results));
        System.out.println("Method 2 winner (AlgoExpert solution): "+tournamentWinner_method2(competitions, results));
    }

    public static String tournamentWinner_method2(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results){

        //O(n) time | O(k) space where n is the number of competitions and k is the number of teams

        Map<String, Integer> points = new HashMap<>();
        String currentBestTeam = "";
        points.put(currentBestTeam,0);

        for(int i = 0; i < competitions.size(); i++){
            Integer result = results.get(i);
            String home_team = competitions.get(i).get(0);
            String away_team = competitions.get(i).get(1);
            String winner_team = result == WINNER_AWAY ? away_team : home_team;

            if(!points.containsKey(winner_team)){
                points.put(winner_team,0);
            }
            points.put(winner_team, 3 + points.get(winner_team));

            if( points.get(winner_team) > points.get(currentBestTeam) ){
                currentBestTeam = winner_team;
            }
        }

        return currentBestTeam;
    }

    public static String tournamentWinner_method1(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results){

        Map<String, Integer> points = new HashMap<>();

        for(int i = 0; i < competitions.size(); i++){
            Integer result = results.get(i);
            String home_team = competitions.get(i).get(0);
            String away_team = competitions.get(i).get(1);
            String winner_team = "";
            if( result == WINNER_AWAY){
                winner_team = away_team;
            }else if( result == WINNER_HOME){
                winner_team = home_team;
            }

            if(points.containsKey(winner_team)){
                Integer team_match_points = points.get(winner_team);
                points.put(winner_team,team_match_points + 3);
            }else{
                points.put(winner_team,3);
            }
        }

        String team_winner_global = "";
        Integer max_poins = 0;
        for (String key : points.keySet()) {
            Integer value = points.get(key);
            if(value > max_poins){
                max_poins = value;
                team_winner_global = key;
            }
        }

        return team_winner_global;
    }
}
