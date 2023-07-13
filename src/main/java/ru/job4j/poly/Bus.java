package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет!");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Пассажиры садятся");
    }

    @Override
    public double refuel(double volume) {
        return volume * 87;
    }
}
