package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
        
        
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        //Get sorted list of players
        ArrayList<Player> finns = getFINPlayersByPoints(players);
        
        System.out.println("Players from FIN");
        System.out.println("");
        
        for (Player player : finns) {
            
            if (player.getName().length() <= 15) {
                System.out.println(player + "\t\t" + player.getGoals() + " + " + player.getAssists() + " = " + (player.getGoals() + player.getAssists()) );
            } else {
                System.out.println(player + "\t" + player.getGoals() + " + " + player.getAssists() + " = " + (player.getGoals() + player.getAssists()) );
            }
        }
        
    }
    
    public static ArrayList<Player> getFINPlayersByPoints(Player[] players) {
        
        ArrayList<Player> finns = new ArrayList<>();
        
        //Add all finnish players to a list
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                finns.add(player);
            }
        }
        
        //Sort the list by points
        Comparator<Player> compareByPoints = createComparatorForPlayerPoints();
        Collections.sort(finns, compareByPoints.reversed());
        
        //Return sorted list
        return finns;
    }
    
    public static Comparator<Player> createComparatorForPlayerPoints() {
        
        Comparator<Player> comp = (Player first, Player second) -> {
            int first_points = first.getGoals() + first.getAssists();
            int second_points = second.getGoals() + second.getAssists();
            
            return first_points - second_points;
        };
        
        return comp;
    }

}