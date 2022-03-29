public class test {
    static String[] playerRaces = {"human", "elf", "orc", "gnome", "dwarf"};
    static String[] playerClasses = {"mage", "warrior", "ranger"};
    public static void main(String[] args) throws InterruptedException {
        // Start a new game by instantiating the story class. Story class will instantiate Actor class which will serve as the player object.
        Story newStory = new Story();
        // This method will guide the player through the process of creating their character.
        newStory.characterCreation();
    }
}
