/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wampie
 */
public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    public StatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        stats = new Statistics(readerStub);
        System.out.println("search");
        String name = "MinäItte";
        Player expResult = null;
        Player result = stats.search(name);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSearchFound() {
        System.out.println("search");
        String name = "Semenko";
        Player expResult = new Player("Semenko", "EDM", 4, 12);
        Player result = stats.search(name);
        assertEquals("Semenko", result.getName());
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeamReturnsRightAmount() {
        System.out.println("team");
        String teamName = "EDM";
        List result = stats.team(teamName);
        assertEquals(3, result.size());
    }
    
    @Test
    public void testTeamReturnsRightGuy() {
        System.out.println("team");
        String teamName = "PIT";
        List<Player> result = stats.team(teamName);
        assertEquals(result.get(0).getName(), "Lemieux");
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        int howMany = 2;
        List<Player> result = stats.topScorers(howMany);
        assertEquals(result.get(0).getName(), "Gretzky");
    }
}
