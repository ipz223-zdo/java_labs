package com.education.ztu.car;

public class Car {
    private String brand;
    public Engine engine;

    public Car(String brand) {
        this.brand = brand;
        this.engine = new Engine();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isEngineRunning() {
        return engine.isEngineWorks();
    }

    public Engine getEngine() {
        return engine;
    }

    public class Engine {
        private boolean engineWorks;

        public void startEngine() {
            engineWorks = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            engineWorks = false;
            System.out.println("Engine stopped.");
        }

        public boolean isEngineWorks() {
            return engineWorks;
        }
    }
}


