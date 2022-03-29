import java.util.*;
// This is the story class, which will drive the game as the primary interface for the player.
public class Story {
    // Create an instance of Actor class in order to construct a player object.
    Actor newActor = new Actor();
    // Creates an instance of Encounter class in order to call on methods for encounters in quests.
    // Encounter encounters = new Encounter();
    // Reads input from the console so that players can control what is happening in the game.
    Scanner DM = new Scanner(System.in);

    static String[] playerRaces = {"human", "elf", "orc", "gnome", "dwarf"};
    static String[] playerClasses = {"mage", "warrior", "ranger"};

    // this method should return a boolean indicating that the chosen race is a valid race built into the program.
    public boolean isValidRace (String A) {
        for (int i=0; i <= playerRaces.length-1; i++) {
            if (A.equals(playerRaces[i])) {
                return true;
            }
        }
        return false;
    }
    // this method should print out text to the console 1 letter at a time.
    public void scrollingPrint (String A) throws InterruptedException {
        for (int i = 0; i <= A.length()-1; i++) {
            System.out.print(A.charAt(i));
            Thread.sleep(20); // in milliseconds
        }
        System.out.println(); // start a new line
    }
    // this method should return a boolean indicating that the chosen role is a valid role built into the program.
    public boolean isValidRole(String A) {
        for(int i=0; i <= Actor.playerClasses.length-1; i++) {
            if (A.equals(playerClasses[i])) {
                return true;
            } 
        }
        return false;
    }
    // this method should register if the player is submitting a response that will allow the game to continue, or if it will break the game.
    public boolean isValidResponse(String A) {
        if (DM.nextLine() == "yes" ) {
            return true;
        } else {
            return false;
        }
    }
    // this is the primary method that will be called upon the start of a new game. The method should allow players to customize their character.
    public void characterCreation() throws InterruptedException {
        System.out.println("");
        System.out.println("");
        String open = "Hello adventurer! My name is Margo, What is your name? ";
        
        scrollingPrint(open);
        newActor.setName(DM.nextLine());

        System.out.println("");
        String openOne = "Margo: A fitting name! Forgive my old eyes, they arent what they used to be " +newActor.getName()+ ". What are you? Are you a " + Arrays.toString(playerRaces) +"  ";
        scrollingPrint(openOne);
        System.out.println("");

        // hold the next console input temporarily to be used in the isValidRace method to test if the players chosen race is in fact playable.
        String tempOne = DM.nextLine();

        // as long as they are not entering races that are built into the program, continue to prompt them for a race that is built in.
        while (!isValidRace(tempOne)) {
            String invalidResponseOne = "Margo: Impossible " +newActor.getName()+ ". What are you? Are you a " + Arrays.toString(playerRaces)+ " ";
            scrollingPrint(invalidResponseOne);
            tempOne = DM.nextLine();
        }
        // If the test returns true, the player race is playable and setRace() sets their object to be the chosen race held in tempOne.
        newActor.setRace(tempOne);
        
        System.out.println("");
        String openTwo = "Margo: A " +newActor.getRace()+ " Great, its been awhile since ive been able to converse with a " +newActor.getRace()+ ". ";
        scrollingPrint(openTwo);
        System.out.println("");
        
        System.out.println("");
        String openThree = "Margo: " +newActor.getName()+ " How do you identify yourself? (gender) ";
        scrollingPrint(openThree);
        System.out.println("");

        // set the player objects gender variable to the next input line on the console.
        newActor.setGender(DM.nextLine());

        // this is to get around having to create an extremely complicated array of genders, while still being inclusive.
        String openFour = "Margo: Its great to have you here. We accept all " +newActor.getGender()+ "s here. ";
        scrollingPrint(openFour);

        // Thread.sleep(2000) will cause the console to wait for seconds before calling the next command.
        // This is to make the game a little bit more cinematic.

        String [] creationStrings = {"Margo: Welcome " +newActor.getName()+ ". Here you will decide the fate of Embryville with your actions. ", 
                                        "Margo: Will you save the town and its fair people? Or will you abandon them in their time of need?", "Margo: Only time will tell... ", 
                                            "Margo: Tell me about yourself " +newActor.getName()+ " Are you a Warrior? a Mage? or a Ranger? "  };
        for (int i=0; i<=creationStrings.length-1;i++) {
            System.out.println("");
            Thread.sleep(1000);
            scrollingPrint(creationStrings[i]);
        }

        // hold the next line in a temp variable in order to input into following methods.
        String tempThree = DM.nextLine();

        // as long as they are inputting roles that are not built into the program, continue to prompt them for a role that has been built in.
       while(!isValidRole(tempThree)) {
           String invalidTwo = "Margo: Come now, that can't be true " +newActor.getName()+ ". What are you really? Are you a Warrior, a Mage, or a Ranger? " ;
           scrollingPrint(invalidTwo);
           tempThree = DM.nextLine();
       }
       newActor.setRole(tempThree);

        String[] creationStringsTwo = {"Margo: Well " +newActor.getRole()+ ", You will make a mighty ally in the days to come! ", "There are several problems that need solving around the village and people could really use your help. ",
                                            "Margo: Will you help us out? "  };
        for (int i=0;i<=creationStringsTwo.length-1;i++) {
            System.out.println("");
            scrollingPrint(creationStringsTwo[i]);
        }
        // hold the next line as it will determin which of the two paths the player can take at this point.
        String tempFour = DM.nextLine();

        // this if else statement should call the villageStory(); method or the makeMyOwnDestiny(); method which should result in the players having 2 options as far as game paths go.
        if (tempFour.equals("yes")||tempFour.equals("Yes")) {
            String answerOne = "Wonderful! Im so glad I found you, " +newActor.getName()+ ". ";
            scrollingPrint(answerOne);
            villageStory();

        } else {
            if (tempFour.equals("no")||tempFour.equals("No")) {
                makeMyOwnDestiny();
            }
        }
    }
    // This method should begin the village quest line should the player decice to help out the village.
    public void villageStory() throws InterruptedException {
        String[] villageStoryStrings = {"Margo: Great " +newActor.getName()+ ". There are a couple of people in need of help around the village. Miss Pomfrey's chickens got loose and she needs help rounding them up. ",
                                            "Margo: The tavern owner Mr. Beel has a problem that he said he needed help with and would pay. ",
                                                "Margo: Finally " +newActor.getName()+ ". There are rumors of goblins hidden in a cave out west that need to be taken care of. ",
                                                    "Margo: So " +newActor.getName()+ ". Which endeavor would you like to pursue first? (respond with 1 for Pomfreys chickens, 2 for Mr. Beels problem, or 3 for goblin mayhem. "  };
        for (int i=0;i<=villageStoryStrings.length-1;i++) {
            System.out.println("");
            Thread.sleep(2000);
            scrollingPrint(villageStoryStrings[i]);
        }

        int questLine = DM.nextInt();

        // I am attempting to utilize switch case here to implement the players choice in quest. The players choice should result in each Case being played out when they choose which quest to do.
            String [] questStringsOne = {"Margo: Miss Pomfrey will be very grateful for the assistance. You know, she used to be one of the finest alchemists in the village. Though she is old and retired now. ",
                                            "Margo: Her farm can be found up there around the corner. ",
                                                "After walking for about 5 minutes in the direction Margo pointed for you, you see a small farm on the edge of town. You approach it and see an elderly woman attempting futiley to gather the escaped chickens. ",
                                                    "Miss Pomfrey: Hello! Someone told me you might be coming along " +newActor.getName()+ " Thank you so much for helping me to catch my chickens!",
                                                        "Miss Pomfrey: They are right over there in that field, round them up quick and I will give you some health potions for your trouble. ",
                                                            };
            for(int i=0;i<=questStringsOne.length-1;i++) {
                System.out.println("");
                Thread.sleep(2000);
                scrollingPrint(questStringsOne[i]);
            }
        }   
    // This method should begin the non village quest line should the player decide to go off on their own.
    public void makeMyOwnDestiny() throws InterruptedException {
        String[] questStrings = {"Well... Thats to bad " +newActor.getName()+ "I wish you well on your journey. ", 
                                    "What would you like to do before you leave town " +newActor.getName()+ "? You can go to the store for potions. Or you can leave. (Respond with 1 for store, or 2 for leave town). "};
        for(int i=0; i <=questStrings.length-1;i++) {
            System.out.println("");
            Thread.sleep(2000);
            scrollingPrint(questStrings[i]);

            int questLine = DM.nextInt();
        }
    }
    public void generalStore() {
        String[] store = {"You walk for several minutes before finding the general store. You walk inside and see an elderly looking gnome. ", 
                            "Upon seeing you she perks up and yells out \"Greetings! Welcome to Ancient Gnomish Concoctions imporium! How can I assist you?\". ",
                                "(Respond with \"buy items\" to buy items. Respond with \"leave\" to leave"};
        String[] inventory = {"Health Potion = 5 silver. ", "Rations = 5 silver. ", "Waterskins = 5 silver"};
        String tempResponse = "buy items";

        if (tempResponse.equals("buy items")) {

        }
    }
            
    public void saltyBob() {
        String[] questLineTwoStrings = {"You make your way towards the dge of town. As you are walking along the buildings start to get thinner. ",
                                            "The neighborhoods begin to give way to rolling hills covered in sparse forest. As you are walking you come across a broken down wagon. ",
                                                "The man, noticing your appearance pipes up. ", "Merchant: Hello there Stranger! Would you mind helping me out? It appears that some goblins have stolen the wheel from my wagon. ",
                                                    "Merchant: Oh! Of course introductions are in order " +newActor.getName()+ ". I am known as Salty Bob. ",
                                                        "Salty Bob: Would you be willing to look for it? I can pay quite handsomely as I am a traveling merchant."};
        for (int a=0;a<=questLineTwoStrings.length-1;a++) {
            System.out.println("");
            Thread.sleep(1000);
            scrollingPrint(questLineTwoStrings[a]);
        }
        
        String tempFive = DM.nextLine();

            if (tempFive.equals("yes")) {
                String[] yesStrings = {"Salty Bob: Great! Upon bringing me back the wheel and helping me to fix my wagon, I will reward you with some healing potions!", "Salty Bob points you in the direction of some hills over on the horizon. ",
                                            "You begin making your way through the hills and the forest starts to get denser and denser. The light begins to become dim as the canopy thickens. The sounds of the forest fill your ears as you keep on walking towards your destination. " };
                for(int b=0;b<=yesStrings.length-1;b++){
                    System.out.println("");
                    Thread.sleep(1000);
                    scrollingPrint(yesStrings[b]);
                }
            }
        }
    }
}
