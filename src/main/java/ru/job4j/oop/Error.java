package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error baseError = new Error();
        Error indexOutOfBoundsError = new Error(true, 12, "Выход за границы массива");
        Error outOfMemoryError = new Error(false, 1, "Недостаточно оперативной памяти в куче");

        baseError.showInfo();
        indexOutOfBoundsError.showInfo();
        outOfMemoryError.showInfo();
    }

    void showInfo() {
        System.out.printf("Активность: %b", active);
        System.out.printf("Статус: %d", status);
        System.out.printf("Сообщение: %s", message);
    }

}
