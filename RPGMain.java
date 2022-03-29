import java.util.*;
public class RPGMain {
    Scanner DM = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Story newStory = new Story();
        newStory.characterCreation();
    }
}
