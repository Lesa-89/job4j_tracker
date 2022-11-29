package ru.job4j.oop;

public class Transport {

    public static void main(String[] args) {
        Vehicle planeOne = new Plane();
        Vehicle planeTwo = new Plane();
        Vehicle busOne = new Bus();
        Vehicle trainOne = new Train();
        Vehicle busTwo = new Bus();
        Vehicle trainTwo = new Train();
        Vehicle[] vehicles = new Vehicle[]{planeOne, planeTwo, busOne, trainOne, busTwo, trainTwo};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
