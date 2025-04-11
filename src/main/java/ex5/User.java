package ex5;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int key;

    public User(String name, int key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', key=" + key + "}";
    }
}