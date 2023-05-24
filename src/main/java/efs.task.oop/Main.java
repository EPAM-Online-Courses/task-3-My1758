package efs.task.oop;

class Villager {
    private String name;
    private int age;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old.");
    }
}

class ExtraordinaryVillager  extends Villager{
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

    @Override
    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + getName() + " and I'm " + getAge() + " years old. " + skill.getDescription());
    }
}

public class Main {
    public static void main(String[] args) {
        Villager villager1 = new Villager("Kashya", 30);
        //Villager villager2 = new Villager("Akara", 40);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager villager3 = new Villager("Gheed", 50);
        //Villager villager4 = new Villager("Deckard Cain", 85);
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager villager5 = new Villager("Warriv", 35);
        Villager villager6 = new Villager("Flawia", 25);

        villager1.sayHello();
       // villager2.sayHello();
       akara.sayHello();
        villager3.sayHello();
       // villager4.sayHello();
       deckardCain.sayHello();
        villager5.sayHello();
        villager6.sayHello();
    }
}

