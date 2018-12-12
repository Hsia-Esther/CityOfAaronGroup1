package control;

import model.Map;
import model.Point;
import model.Location;
import exceptions.MapControlException;
import cityofaaron.CityOfAaron;

/**
 *
 * @author Brenda
 */
public class MapControl {

    public MapControl() {
        //empty constructor
    }

    public static Map createMap() {
        //create map object and assign values to it
        Map map = new Map();
        int noOfRows = 5;
        int noOfColumns = 5;

        //create a two-dimensional array of locations and assign array to the map
        Location[][] locations = new Location[noOfRows][noOfColumns];

        locations[0][0] = new Location("W", "Watchtower", "You are standing on top of a watchtower overlooking the border of your lands.", new String[]{});
        locations[0][1] = new Location("F", "Wheat field", "Waves of grain roll before you, it is a beautiful sight.", new String[]{});
        locations[0][2] = new Location("R", "River", "The river Hiddekel flows before you in a mighty stream.", new String[]{});
        locations[0][3] = new Location("U", "Undeveloped", "This land awaits development. Make plans for the future.", new String[]{});
        locations[0][4] = new Location("W", "Watchtower", "You are standing on top of a watchtower overlooking the border of your lands.", new String[]{});

        locations[1][0] = new Location("B", "Border", "You are standing at the fortified border facing the Lamanite lands.", new String[]{});
        locations[1][1] = new Location("V", "Village", "A thriving village moves busily around you. Life is good here.", new String[]{});
        locations[1][2] = new Location("R", "River", "The river Hiddekel flows before you in a mighty stream.", new String[]{});
        locations[1][3] = new Location("F", "Wheat field", "Waves of grain roll before you, it is a beautiful sight.", new String[]{});
        locations[1][4] = new Location("F", "Wheat field", "Waves of grain roll before you, it is a beautiful sight.", new String[]{});

        locations[2][0] = new Location("B", "Border", "You are standing at the fortified border facing the Lamanite lands.", new String[]{});
        locations[2][1] = new Location("R", "River", "The river Hiddekel flows before you in a mighty stream.", new String[]{});
        locations[2][2] = new Location("T", "Temple", "A majestic temple stands in front of you. It is a scene of peaceful beauty.", new String[]{});
        locations[2][3] = new Location("V", "Village", "A thriving village moves busily around you. Life is good here.", new String[]{});
        locations[2][4] = new Location("U", "Undeveloped", "This land awaits development. Make plans for the future.", new String[]{});

        locations[3][0] = new Location("B", "Border", "You are standing at the fortified border facing the Lamanite lands.", new String[]{});
        locations[3][1] = new Location("F", "Wheat field", "Waves of grain roll before you, it is a beautiful sight.", new String[]{});
        locations[3][2] = new Location("S", "Storehouse", "The city's granary and storehouse stands strong and secure before you", new String[]{});
        locations[3][3] = new Location("C", "Ruler's Court", "You have arrived at the ruler's court, where you work for the people.", new String[]{});
        locations[3][4] = new Location("F", "Wheat field", "Waves of grain roll before you, it is a beautiful sight.", new String[]{});

        locations[4][0] = new Location("W", "Watchtower", "You are standing on top of a watchtower overlooking the border of your lands.", new String[]{});
        locations[4][1] = new Location("R", "River", "The river Gihon trickles slowly with a babbling sound.", new String[]{});
        locations[4][2] = new Location("V", "Village", "A thriving village moves busily around you. Life is good here.", new String[]{});
        locations[4][3] = new Location("U", "Undeveloped", "This land awaits development. Make plans for the future.", new String[]{});
        locations[4][4] = new Location("W", "Watchtower", "You are standing on top of a watchtower overlooking the border of your lands.", new String[]{});

        map.setLocations(locations);

        Point point = new Point(2, 3);
        map.setCurrentLocation(point);
        return map;
    }

    public static void checkNewLocation(int column, int row) throws MapControlException {

        Map map = CityOfAaron.getCurrentGame().getTheMap();
        Location[][] locations = map.getLocations();

        if (column < 0 || row < 0) {
            throw new MapControlException("\nPlease enter only positive numbers.\n");
        } else if (row >= locations.length || column >= locations[0].length) {
            throw new MapControlException("\nPlease enter numbers that are not greater than 5.\n");
        }
    }
}
