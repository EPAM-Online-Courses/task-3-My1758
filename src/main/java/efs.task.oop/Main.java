package efs.task.oop;

class Villager {
    private String name;
    private int age;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old.");
    }
}

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
    }
}



