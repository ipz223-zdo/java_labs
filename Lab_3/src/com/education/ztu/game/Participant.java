package com.education.ztu.game;

public abstract class Participant implements Cloneable, Comparable<Participant>  {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Participant clone() {
        try {
            return (Participant) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Перевизначення equals та hashCode для порівняння та хешування
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age;
    }

    // Перевизначення toString для зручного виведення
    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + "}";
    }

    // Перевизначення методу compareTo для порівняння учасників по імені
    @Override
    public int compareTo(Participant other) {
        return this.name.compareTo(other.name);
    }
}
