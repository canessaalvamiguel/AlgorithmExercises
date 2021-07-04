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
