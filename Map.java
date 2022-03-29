public class Map {
    // This method should create a new 2 dimensional array of chars that should act as the map. This will be called during certain quests.
    public char[][] generateMap(int Length, int Width) {
        char[][] map = new char[Length][Width];
        for (int row = 0; row < map.length; row++) { 
            for (int col = 0; col < map[row].length; col++) { 
                map[row][col] = '-';
            }
        }
        return map;
    }
    
    // This method should print the newly created map and fill it with chars.
    public void printEncounterMap (char[][] map) {
        for (int row = 0; row < map.length; row++) { 
            for (int col = 0; col < map[row].length; col++) {
                System.out.print(map[row][col]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }  
}
