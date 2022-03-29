public class Encounter{
    // Allows methods from the story class to be called, such as scrolling print for the random encounter method.
    Story newStory = new Story();
    // This method should call on the Monster class to create monsters for random encounters. This should be used in the story class for generating random encounters.
    public void randomEncounter(int A) throws InterruptedException {
        int[] monster = {1, 2, 3, 4, 5};

        for (int i=0;i<=monster.length-1;i++) {
            if (A == monster[i]) {
                Monster goblin = new Monster(11, Dice.diceRoll(4), 4, 4);
                String goblinText = "What appears before you is a small humanoid with deep wrinkled green skin. Out of its lips come gutteral noises as it yells at you brandishing its dagger threateningly. ";
                newStory.scrollingPrint(goblinText);
            } else {
                if (A == monster[i]) {
                    Monster imp = new Monster(15, Dice.diceRoll(4), 4, 4);
                    String impText = "What appears before you is a small humanoid, about 2 feet tall. Its filthy skin is a brackish grey color. It begins to speak to you but the language it uses sounds like an angry nest of hornets mixed with obscenities. A fireball begins to form in its hands as it gets ready to lob a spell at you. ";
                    newStory.scrollingPrint(impText);
                } else {
                    if (A == monster[i]) {
                        Monster skeleton = new Monster(15, Dice.diceRoll(5), 5, 5);
                        String skeletonText = "What appears before you is clearly some sort of skeleton of a humanoid creature. It moves about the area as if by magic since all of its bones are stripped completely clean of any muscle. It holds a bow and is readying an arrow to fire in your direction. ";
                        newStory.scrollingPrint(skeletonText);
                    } else {
                        if (A == monster[i]) {
                            Monster grimlock = new Monster(11, Dice.diceRoll(4), 5, 5); 
                            String grimlockText = "What appears before you is a short human. But something is wrong... Its deformed and wanders about  as if blind. Your boot makes a sound as you take a step forward and the creature with unnatural speed turns to face you. It holds a club at the ready and smiles at you a fetid smile full of missing teeth. It begins to advance in your direction. ";
                            newStory.scrollingPrint(grimlockText);                                                                                                            
                        } else {
                            if (A == monster[i]) {
                                Monster Hobgoblins = new Monster(11, Dice.diceRoll(8), 5, 5);
                                String hobgoblinText = "What appears before you is a creature that looks like a large goblin. Its skin is a ruddy rbown orange and it cackles with glee as it notices you. It begins to advance pulling out a vicious pair of daggers, readying them to attack. ";
                                newStory.scrollingPrint(hobgoblinText);
                            }
                        }
                    }
                }
            }
        }
    }
}