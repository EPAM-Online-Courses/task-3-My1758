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
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return isDead;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
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
        void setDescription(String depcription){
            this.description=depcription;
        }
        public String getDescription() {
            return description;
        }
    }

    private Skill skill;
    private boolean dead;
    public ExtraordinaryVillager(String name, int age,Skill skill) {
        super(name, age);
        this.skill=skill;
        this.dead=false;
    }
    void setSkill(Skill skil ){
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
        if(getHealth() <=0){
            dead=true;
        }
    }
    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + getName() + " and I'm " + getAge() + " years old. " + skill.getDescription());
    }
    public boolean isDead() {
        return dead;
    }
}
/*class Monsters {
    static final Monster andariel = new Monster() {
        private int health = 10;
        private int damage = 70;

        public int getHealth() {
            return health;
        }

        public int getDamage() {
            return damage;
        }

        public void takeHit(int damage) {
            health -= damage;
        }

        public void attack(Fighter victim) {
            victim.takeHit(damage);
        }
    };

    static final Monster blacksmith = new Monster() {
        private int health = 100;
        private int damage = 25;

        public int getHealth() {
            return health;
        }

        public int getDamage() {
            return damage;
        }

        public void takeHit(int damage) {
            health -= damage;
        }

        public void attack(Fighter victim) {
            victim.takeHit(damage);
        }
    };

    static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();
}
 */
 class Monster implements Fighter {
    private int health;
    private int damage;
    private boolean isDead;

    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
        this.isDead = false;
    }
    void setHealth(int health){
        this.health=health;
    }
    void setDamage(int damage){
        this.damage=damage;
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
        
        
        ExtraordinaryVillager DeckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        ExtraordinaryVillager Akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);

        DeckardCain.sayHello();
        Akara.sayHello();
        Fighter[] villagers = { kashya, akara, gheed, deckardCain, warriv, flawia };
        
        Monster andariel = new Monster(10, 70);
        Monster blacksmith = new Monster(100, 25);
      
        int monstersHealth = andariel.getHealth() + blacksmith.getHealth();
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

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;
        // Przykład rzutowania i wywołania metody klasy Villager
        if (objectDeckardCain instanceof Villager) {
            Villager villager = (Villager) objectDeckardCain;
            villager.attack(deckardCain);
        }

        // Przykład rzutowania i wywołania metody klasy ExtraordinaryVillager
        if (objectAkara instanceof ExtraordinaryVillager) {
            ExtraordinaryVillager extraordinaryVillager = (ExtraordinaryVillager) objectAkara;
            extraordinaryVillager.attack(akara);
        }

        Random random = new Random();
        boolean villagersTurn = true;

        while (andariel.getHealth() > 0 || blacksmith.getHealth() > 0) {
            if (villagersTurn) {
                for (Fighter villager : new Fighter[]{kashya, akara, gheed, deckardCain, warriv, flawia}) {
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

            boolean anyVillagerAlive = false;
            for (Fighter villager : new Fighter[]{kashya, akara, gheed, deckardCain, warriv, flawia}) {
                if (!villager.isDead()) {
                    System.out.println("Aktualnie walczacy osadnik to " + ((Villager) villager).getName());
                    anyVillagerAlive = true;
                }
            }

            if (!anyVillagerAlive) {
                System.out.println("Obozowisko zostalo zniszczone!");
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (andariel.getHealth() <= 0 && blacksmith.getHealth() <= 0) {
            System.out.println("Obozowisko ocalone!");
        }

        deckardCain = (ExtraordinaryVillager) deckardCain;
        akara = (ExtraordinaryVillager) akara;

        DeckardCain.attack(andariel);
        Akara.takeHit(10);
        //DeckardCain.attack(andariel);
       // Akara.attack(andariel);
    }
}

 

 
    

    


    


    



 
    





