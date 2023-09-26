import java.util.List;
import java.util.Random;

public class App{
    public static void main(String[] args) throws Exception{
        dndCharacter c1 = new dndCharacter("The First", "Human", "lawful good");
        dndCharacter c2 = new dndCharacter("The Other", "Gnome", "lawful Evil");

        System.out.format("the battle started \n");
        while(c1.isAlive() && c2.isAlive()){
            c1.attack(c2, c1.rollDice(8));
            c2.attack(c1, c2.rollDice(8));
        }
        System.out.format("the battle ended \n");
    }
}

//based on dnd character sheet
public class dndCharacter{
    private Random dice = new Random();     
    private String name;
    private String race;
    private String alignment;
    private int level = 1;
    private int strength = 10;
    private int dexterity = 10;
    private int constitution = 10;
    private int inteligence = 10;
    private int wisdow = 10;
    private int charisma = 10;
    private int hitPoints = 10;
    private int armorClass = 10;
    private int init = 0;
    private int speed = 25;
    private String hitDice;

    private List<String> skills;
    private List<String> spells;
    
    public String getName(){
        return  this.name;
    }
    
    public boolean isAlive(){
        if(this.hitPoints > 0)
            return true;
        return false;
    }

    public int getAC(){
        return this.armorClass;
    }

    public void hitted(int damage ){
        hitPoints -= damage;
        System.out.format("%s new HP is %d \n", this.name,this.hitPoints);
        if(hitPoints <= 0)
            this.die();
    }

    private void die(){
        System.out.format("%s received too much damage and died\n", this.name);
    }

    public void attack(dndCharacter target, int damage){
        System.out.format("%s attacked %s \n", this.name, target.getName());

        if(rollDice(20) > target.getAC())
            target.hitted(damage);
        else
            System.out.format("... but %s missed the attack\n", this.name);
    }

    public int rollDice(int d){
        return 1 + dice.nextInt(d-1);
    }

    public dndCharacter(String name, String race, String alignment){
        this.name = name;
        this.race = race;
        this.alignment = alignment;

        System.out.format("%s has born \n", name);
    }
}