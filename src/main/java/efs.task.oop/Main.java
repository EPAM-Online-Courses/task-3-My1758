package efs.task.oop;



 import java.util.Random;

interface Fighter {
    void attack(Fighter victim);
    void takeHit(int damage);
    boolean isDead();
}

class Villager implements Fighter {
    private String name;
    private int age;
    private int health;
    private boolean isDead;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
        this.health = 100;
        this.isDead = false;
    }

    int getHealth() {
        return health;
    }

    public boolean isDead() {
        return isDead;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }

    @Override
    public void attack(Fighter victim) {
        if (!isDead) {
            int damage = (int) ((100 - age * 0.5) / 10);
            victim.takeHit(damage);
        }
    }

    @Override
    public void takeHit(int damage) {
        if (!isDead) {
            health -= damage;
            if (health <= 0) {
                health = 0;
                isDead = true;
            }
        }
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
    public ExtraordinaryVillager(String name, int age,Skill skill) {
        super(name, age);
        this.skill=skill;
    }

    @Override
    public void attack(Fighter victim) {
        // ExtraordinaryVillager does not deal any damage
    }

    @Override
    public void takeHit(int damage) {
        // ExtraordinaryVillager dies from one hit
        super.takeHit(getHealth());
    }
    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + getName() + " and I'm " + getAge() + " years old. " + skill.getDescription());
    }
}

class Monster implements Fighter {
    private int health;
    private int damage;
    private boolean isDead;

    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
        this.isDead = false;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isDead() {
        return isDead;
    }

    @Override
    public void attack(Fighter victim) {
        if (!isDead) {
            victim.takeHit(damage);
        }
    }

    @Override
    public void takeHit(int damage) {
        if (!isDead) {
            health -= damage;
            if (health <= 0) {
                health = 0;
                isDead = true;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        Villager akara = new Villager("Akara", 40);
        Villager gheed = new Villager("Gheed", 50);
        Villager deckardCain = new Villager("Deckard Cain", 85);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();
        //Villager kashya = new Villager("Kashya", 30);
       // Villager akara = new ExtraordinaryVillager("Akara", 40);
        //Villager gheed = new Villager("Gheed", 50);
        //ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85);
        //Villager warriv = new Villager("Warriv", 35);
        //Villager flawia = new Villager("Flawia", 25);
        
        ExtraordinaryVillager DeckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        ExtraordinaryVillager Akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);

        DeckardCain.sayHello();
        Akara.sayHello();
        Fighter[] villagers = { kashya, akara, gheed, deckardCain, warriv, flawia };

        Monster andariel = new Monster(10, 70);
        Monster blacksmith = new Monster(100, 25);

        int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

        Random random = new Random();
        boolean villagersTurn = true;

        while (monstersHealth > 0) {
            if (villagersTurn) {
                for (Fighter villager : villagers) {
                    if (!villager.isDead()) {
                        villager.attack(andariel);
                        villager.attack(blacksmith);
                    }
                }
            } else {
                if (!andariel.isDead()) {
                    andariel.attack(deckardCain);
                    andariel.attack(akara);
                }

                if (!blacksmith.isDead()) {
                    blacksmith.attack(deckardCain);
                    blacksmith.attack(akara);
                }
            }

            villagersTurn = !villagersTurn;

            System.out.println("Potwory posiadaja jeszcze " + (andariel.getHealth() + blacksmith.getHealth()) + " punkty zycia");

            for (Fighter villager : villagers) {
                if (!villager.isDead()) {
                    System.out.println("Aktualnie walczacy osadnik to " + ((Villager) villager).getName());
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Obozowisko ocalone!");

        DeckardCain = (ExtraordinaryVillager) DeckardCain;
        Akara = (ExtraordinaryVillager) Akara;

        
        DeckardCain.attack(andariel);
        Akara.attack(andariel);
    }
}

 
    





