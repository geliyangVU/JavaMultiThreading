package Shared_Resource;

public class Immutable {
    // String and Integer are both Immutable
    private int value = 0;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}