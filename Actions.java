// This class contains methods that should drive player actions within the game.
public class Actions {
    
    // This method should be called when battle is initiated and deals damage to a player or a monster object.
    public void attack(int A) {
        
    }
    // This method should allow players or monsters to defend against an attack and not take damage from it.
    public void defend() {

    }
    // Fireball spell should do 1d10 damage
    public int fireball() {
        return Dice.diceRoll(10);
    }
    // Bowshot should do 1d7 damage
    public int bowShot() {
        return Dice.diceRoll(7);
    }
    // sword should do 1d5 damage
    public int sword() {
        return Dice.diceRoll(5);
    }
    // staff should deal 1d4 damage
    public int staff() {
        return Dice.diceRoll(4);
    }
}
