package com.company;

import java.util.Scanner;

public class Coffee {

    public static Scanner scanner = new Scanner(System.in);
    public static int water = 400;
    public static int milk = 540;
    public static int beans = 120;
    public static int cups = 9;
    public static int money = 550;
    public static boolean process = true;
    public static String action;

    public static void choose () {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        action = scanner.next();
        System.out.println();

    }

    public static void menu() {
        while (process) {
            Coffee.choose();
            switch (action) {
                case "buy" -> Coffee.buy();
                case "fill" -> Coffee.fill();
                case "take" -> Coffee.take();
                case "remaining" -> Coffee.remaining();
                case "exit" -> process = false;

            }
        }
    }

    public static void buy () {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffee = scanner.next();
        switch (coffee) {
            case "1" -> {
                if (water < Kinds.ESPRESSO.water) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (beans < Kinds.ESPRESSO.beans) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else {
                    water -= Kinds.ESPRESSO.water;
                    beans -= Kinds.ESPRESSO.beans;
                    money += Kinds.ESPRESSO.price;
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
            }
            case "2" -> {
                if (water < Kinds.LATTE.water) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (milk < Kinds.LATTE.milk) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (beans < Kinds.LATTE.beans) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else {
                    water -= Kinds.LATTE.water;
                    milk -= Kinds.LATTE.milk;
                    beans -= Kinds.LATTE.beans;
                    money += Kinds.LATTE.price;
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
            }
            case "3" -> {
                if (water < Kinds.CAPPUCCINO.water) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (milk < Kinds.CAPPUCCINO.milk) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (beans < Kinds.CAPPUCCINO.beans) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else {
                    water -= Kinds.CAPPUCCINO.water;
                    milk -= Kinds.CAPPUCCINO.milk;
                    beans -= Kinds.CAPPUCCINO.beans;
                    money += Kinds.CAPPUCCINO.price;
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
            }
            case "back" -> {
                System.out.println();
                menu();
            }
        }
    }

    public static void fill () {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
        System.out.println();
    }

    public static void take () {
        System.out.printf("I gave you $%d\n\n", money);
        money = 0;
    }

    public static void remaining () {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water \n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", beans);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n\n", money);
    }
}

