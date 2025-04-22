package ru.liga.antisolid.antiL;

/**
 * Liskov Substitution
 * Нарушение: в суперклассе вручную прописываем наследников, логику для которых будем реализовывать
 */
public class Car {

    public static void refuel(Car car) {
        if (car instanceof PassengerCar) {
            System.out.println("Заправляем легковой автомобиль...");
        } else if (car instanceof Truck) {
            System.out.println("Заправляем грузовой автомобиль...");
        }
    }


    public static void main(String[] args) {
        Car passengerCar = new PassengerCar();
        Car truck = new Truck();
        ElectroCar electroCar = new ElectroCar();

        refuel(passengerCar);
        refuel(truck);
        refuel(electroCar); // Ничего не выведет, так как в Car.refuel нет логики для класса ElectroCar

    }

    public static class Truck extends Car {
    }

    public static class ElectroCar extends Car {
    }

    public static class PassengerCar extends Car {
    }
}

