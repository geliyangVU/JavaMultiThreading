package Shared_Resource.DeadLock.TheDiningPhilosphersProblem;

public class TestClass {
    public static void main(String[] args) {
        Chopstick chopstick1 = new Chopstick("Chopstick1");
        Chopstick chopstick2 = new Chopstick("Chopstick2");
        Chopstick chopstick3 = new Chopstick("Chopstick3");
        Chopstick chopstick4 = new Chopstick("Chopstick4");
        Chopstick chopstick5 = new Chopstick("Chopstick5");

        new Philosopher("PhilospherOne", chopstick1, chopstick2).start();
        new Philosopher("PhilospherTwo", chopstick2, chopstick3).start();
        new Philosopher("PhilospherThree", chopstick3, chopstick4).start();
        new Philosopher("PhilospherFour", chopstick4, chopstick5).start();
        new Philosopher("PhilospherFive", chopstick5, chopstick1).start();

    }

}
