package Shared_Resource.DeadLock.TheDiningPhilosphersProblem;

public class Chopstick {
    String name;

    public Chopstick(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "chopstickname: " + name;
    }

}
