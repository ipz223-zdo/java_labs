package com.education.ztu.human;

public interface Human {
    void sayAge();
    void sayGender();
    void sayLocation();
    void sayName();

    default void whoAmI() {
        System.out.println("I am a human.");
    }
}
