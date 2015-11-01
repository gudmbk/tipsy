package Tests;

import static org.junit.Assert.assertEquals;
import com.company.Domain.Player;
import org.junit.Test;

/**
 * Created by Gudmundur Bjarni Kristinsson on 31-Oct-15.
 * gudmundurk14@ru.is
 * kt: 110384-3279
 */
public class PlayerTests {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("Tests.PlayerTests");
    }

    @Test
    public void testCreation() {
        Player player = new Player();
        assertEquals("Anonymous", player.getName());
        assertEquals(true, player.getIsHuman());
    }

    @Test
    public void testSetType() {
        Player player = new Player();
        player.setIsHuman(false);
        assertEquals(false, player.getIsHuman());
    }

    @Test
    public void testChangeName() {
        Player player = new Player();
        player.setName("Sigmund Freud");
        assertEquals("Sigmund Freud", player.getName());
    }
}
