package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public void show() {
        System.out.printf("Имя: %s\nКотик сегодня ел: %s", name, food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    void giveNick(String nick) {
        name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.show();
    }
}