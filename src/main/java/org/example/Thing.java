package org.example;

abstract public class Thing implements IInventory, INamed {
    private int number;
    @Override
    final public void setNumber(int number) {
        this.number = number;
    }

    @Override
    final public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return getName() + " " + getNumber();
    }
}
