package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int passengersCount) {
        System.out.println("Количество пассажиров: " + passengersCount);
    }

    @Override
    public int refuel(int gas) {
        int price = 57;
        return gas * price;
    }

}
