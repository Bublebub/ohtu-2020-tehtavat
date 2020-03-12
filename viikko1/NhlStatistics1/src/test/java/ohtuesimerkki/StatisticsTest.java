
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    
    Reader readerStub = new Reader() {
    
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
            
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            
            return players;
        }
    };
    
    Statistics stats;
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsNullIfPlayerNotFound() {
        assertEquals(null, stats.search("NoName"));
    }
    
    @Test
    public void searchReturnsCorrectPlayer() {
        Player test = stats.search("Kurri");
        assertEquals("Kurri", test.getName());
    }

    @Test
    public void teamReturnsAllPlayersOfTheTeam() {
        List<Player> test = stats.team("EDM");
        int counter = 0;
        
        for (Player player : test) {
            if (player.getTeam().equals("EDM")) counter++;
        }
        
        assertEquals(3, counter);
    }

    @Test
    public void topScorersReturnsCorrectAmountOfPlayers() {
       List<Player> test = stats.topScorers(3);
       int counter = 0;
       
       for (Player player : test) counter++;
       
       assertEquals(4, counter);
    }
    
}
