import java.util.*;

// This class will contain global stats for all players, including getter and setter methods to set and retrieve stats from the player object.
public class Actor {
    // these 2 arrays hold the playable races and roles that players will be able to choose from.
    static String[] playerRaces = {"human", "elf", "orc", "gnome", "dwarf"};
    static String[] playerClasses = {"mage", "warrior", "ranger"};

    // global stats for all new players.
    public String Name = "";
    public String Race = "";
    public String Gender = "";
    public String Role = "";
    public int level = 1;
    public int xp = 0;
    public int atk = 10;
    public int def = 10;
    public int health = 15;
    public int maxHealth = 15;
    public int mana = 15;
    public int maxMana = 15;
    public ArrayList<String> inventory = new ArrayList<>();
    public int currency = 50;
    
    public void setCurrency(int A) {
        this.currency = A;
    }
    public void setMaxHealth(int A) {
        this.maxHealth =  A;
    }
    public void setMaxMana(int A) {
        this.maxMana = A;
    }
    public void setMana(int A) {
        this.mana = A;
    }
    public void setHealth(int A) {
        this.health = A;
    }
    public void setAtk (int A) {
        this.atk = A;
    }
    public void setDef(int A) {
        this.def = A;
    }
    public void setName(String A) {
        this.Name = A;
    }
    // Sets the players race and calls the appropriate method to set the stats of the players chosen race.
    public void setRace(String A) {
        if (A.equals("dwarf")) {
            dwarf();
        } else {
            if (A.equals("elf")) {
                elf();
            } else {
                if (A.equals("human")) {
                    human();
                } else {
                    if (A.equals("gnome")) {
                        gnome();
                    } else {
                        if (A.equals("orc")) {
                            orc();
                        }
                    }
                }
            }
        }
    }
    public void setGender(String A) {
        this.Gender = A;
    }
    // Sets the players role and calls the appropriate method to set the stats for the players chosen role.
    public void setRole(String A) {
        if (A.equals("mage")) {
            this.Role = A;
            mage();
        } else {
            if (A.equals("ranger")) {
                this.Role = A;
                ranger();
            } else {
                if (A.equals("warrior")) {
                    this.Role = A;
                    warrior();
                }
            }
        }
    }
    public void setLevel(int A) {
        this.level = A;
    }
    public void setXP(int A) {
        this.xp = this.xp + A;
    }
    public String getName() {
        return this.Name;
    }
    public String getRace() {
        return this.Race;
    }
    public String getGender() {
        return this.Gender;
    }
    public String getRole() {
        return this.Role;
    }
    public int getLevel() {
        return this.level;
    }
    public int getXP() {
        return this.xp;
    }
    public int getMaxHealth() {
        return this.maxHealth;
    }
    public int getHealth() {
        return this.health;
    }
    public int getMaxMana() {
        return this.maxMana;
    }
    public int getMana() {
        return this.mana;
    }
    public int getAtk () {
        return this.atk;
    }
    public int getDef() {
        return this.def;
    }
    public int getCurrency() {
        return this.currency;
    }
    // Sets stats for players of the Mage class.
    public void mage() {
        setMaxHealth(20);
        setMaxMana(60);
        setAtk(5);
        setDef(10);
        setLevel(1);
        setXP(0);
        inventory.add("staff");
        inventory.add("cloth armor");
        currency = 100;
    }
    // Sets stats for players of the ranger class.
    public void ranger() {
        setMaxHealth(40);
        setMaxMana(0);
        setAtk(10);
        setDef(20);
        setLevel(1);
        setXP(0);
        inventory.add("longbow ");
        inventory.add("mail armor ");
        currency = 100;
    }
    // Sets the stats for players of the warrior class.
    public void warrior() {
        setMaxHealth(60);
        setMaxMana(0);
        setAtk(5);
        setDef(40);
        setLevel(1);
        setXP(0);
        inventory.add("sword ");
        inventory.add("plate armor ");
        inventory.add("shield ");
        currency = 100;
    }
    // Sets the stats for dwarves
    public void dwarf() {
        this.maxHealth +=15;
        this.atk +=5;
        this.def +=10;
        this.Race = "dwarf";
    }
    // Sets the stats for elves
    public void elf() {
        this.maxHealth +=10;
        this.atk +=15;
        this.def +=5;
        this.Race = "elf";
    }
    // Sets the stats for humans
    public void human() {
        this.maxHealth +=10;
        this.atk +=10;
        this.def +=10;
        this.Race = "human";
    }
    // Sets the stats for gnomes
    public void gnome() {
        this.maxHealth +=5;
        this.atk +=15;
        this.def +=5;
        this.Race = "gnome";
    }
    // Sets the stats for orcs
    public void orc() {
        this.maxHealth +=15;
        this.atk +=15;
        this.def +=5;
        this.Race = "orc";
    }
}
