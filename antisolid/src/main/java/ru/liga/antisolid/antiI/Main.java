package ru.liga.antisolid.antiI;

/**
 * Interface Segregation
 * Нарушение: для класса ElectroCar не нужно переопределять метод refuel, так как электромобили не заправляют бензином
 */
public class Main {

    interface Car {
        void drive();

        void refuel();
    }

    static class PassengerCar implements Car {
        public void drive() {
            System.out.println("Легковая машина едет...");
        }

        public void refuel() {
            System.out.println("Заправляем легковую машину...");
        }
    }

    static class ElectroCar implements Car {
        public void drive() {
            System.out.println("Электрическая машина едет...");
        }

        public void refuel() {
            throw new UnsupportedOperationException("Электрическую машину нельзя заправлять!");
        }
    }

    public static void main(String[] args) {
        new PassengerCar().drive();
        new ElectroCar().drive();
        new PassengerCar().refuel();
        new ElectroCar().refuel(); // Возникнет исключение
    }
}