package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int passengersCount);

    int refuel(int gas);
}
