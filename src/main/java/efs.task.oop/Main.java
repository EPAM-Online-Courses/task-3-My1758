package efs.task.oop;

class Villager implements Fighter {
    private String name;
    private int age;
    private int health;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void attack(Fighter victim) {
        int damage = (int) ((100 - age * 0.5) / 10);
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        health -= damage;
    }
     public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old.");
    }
}

class ExtraordinaryVillager extends Villager {
    public enum Skill {
        IDENTIFY("I will identify items for you at no charge."),
        SHELTER("I can offer you poor shelter.");

        private String description;

        Skill(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private Skill skill;

    public ExtraordinaryVillager(String name, int age, Skill skill) {
        super(name, age);
        this.skill = skill;
    }
   // public ExtraordinaryVillager(String name, int age) {
  //      super(name, age);
  //  }

    @Override
    public void attack(Fighter victim) {
        // ExtraordinaryVillager does not deal any damage
    }

    @Override
    public void takeHit(int damage) {
        // ExtraordinaryVillager dies from one hit
        super.takeHit(getHealth());
    }
}

interface Fighter {
    void attack(Fighter victim);
    void takeHit(int damage);
}

abstract class Monster implements Fighter {
    private int health;
    private int damage;

    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void takeHit(int damage) {
        health -= damage;
    }
}
    static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();
public class Main {
    public static void main(String[] args) {
        Villager villager1 = new Villager("Kashya", 30);
        Villager villager2 = new Villager("Akara", 40);
        Villager villager3 = new Villager("Gheed", 50);
        Villager villager4 = new Villager("Deckard Cain", 85);
        Villager villager5 = new Villager("Warriv", 35);
        Villager villager6 = new Villager("Flawia", 25);

        villager1.sayHello();
        villager2.sayHello();
        villager3.sayHello();
        villager4.sayHello();
        villager5.sayHello();
        villager6.sayHello();
        
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);

        deckardCain.sayHello();
        akara.sayHello();
        System.out.println("Initial monsters' health: " + monstersHealth);

        andariel.takeHit(20);
        System.out.println("Andariel's health after taking hit: " + andariel.getHealth());
        System.out.println("Monsters' health after Andariel's hit: " + monstersHealth);

        blacksmith.takeHit(10);
        System.out.println("Blacksmith's health after taking hit: " + blacksmith.getHealth());
        System.out.println("Monsters' health after Blacksmith's hit: " + monstersHealth);

        andariel.attack(blacksmith);
        System.out.println("Blacksmith's health after Andariel's attack: " + blacksmith.getHealth());
        System.out.println("Monsters' health after attack: " + monstersHealth);
         Villager deckardCain = new Villager("Deckard Cain", 85);
        Villager akara = new Villager("Akara", 40);

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;
         if (objectDeckardCain instanceof Villager) {
            Villager villager = (Villager) objectDeckardCain;
            villager.attack(deckardCain);
        }

        
        if (objectAkara instanceof ExtraordinaryVillager) {
            ExtraordinaryVillager extraordinaryVillager = (ExtraordinaryVillager) objectAkara;
            extraordinaryVillager.attack(akara);
        }
    }
}




