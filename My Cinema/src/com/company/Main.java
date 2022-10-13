package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        char[][] seatPlaces = new char[rows][columns];
        int action;
        int allSeats = rows * columns;
        boolean program = false;
        int purchased = 0;
        int income = 0;
        int price;
        int[] cords = new int[2];


        int totalPrice = total(rows, columns);

        do {
            System.out.println();
            System.out.println("1. Show the seats \n2. Buy a ticket \n3. Statistics \n0. Exit");
            action = scanner.nextInt();

            switch (action) {
                case 1 -> seats(seatPlaces, columns);

                case 2 -> {
                    System.out.println();
                    cords(cords, rows, columns);
                    byuTicket(seatPlaces, cords, rows, columns);
                    System.out.println();
                    price = ticketPrice(rows, columns, cords, seatPlaces);
                    System.out.println("Ticket price: $" + price);
                    purchased = bought(purchased) ;
                    income += ticketPrice(rows, columns, cords, seatPlaces);
                }

                case 3 -> statistics(purchased, allSeats, income, totalPrice);

                case 0 -> program = true;
            }
        } while (!program);

    }

    public static void cords(int[] cords, int rows, int columns) {
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;
        while (!correct) {
            System.out.println("Enter a row number:");
            cords[0] = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            cords[1] = scanner.nextInt();
            if (cords[0] > rows || cords[1] > columns) {
                System.out.println("Wrong input!");
            }else if (cords[0] <= 0 || cords[1] <= 0) {
                System.out.println("Wrong input!");
            } else {
                correct = true;
            }
        }
    }

    public static void seats(char[][] seatPlaces, int columns) {
        for (int i = 0; i < seatPlaces.length; i++) {
            for (int j = 0; j < seatPlaces[i].length; j++) {
                if (seatPlaces[i][j] == 'B'){
                    seatPlaces[i][j] = 'B';
                } else {
                    seatPlaces[i][j] = 'S';
                }
            }
        }
        System.out.println();
        int counter = 1;
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= columns; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for (char[] seatPlace : seatPlaces) {
            System.out.print(counter++ + " ");
            for (char c : seatPlace) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void byuTicket(char[][] seatPlaces, int[] cords, int rows, int columns) {

        if (seatPlaces[cords[0] - 1][cords[1] - 1] == 'B') {
            System.out.println();
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            cords(cords, rows, columns);
        }
        seatPlaces[cords[0] - 1][cords[1] - 1] = 'B';


    }

    public static int ticketPrice(int rows, int columns, int[] cords, char[][] seatPlaces) {
        int ticketPrice = 0;
        int back;
        back = (int)Math.floor(rows/2.0);
        for (int i = 0; i < seatPlaces.length; i++) {
            for (int j = 0; j < seatPlaces[i].length; j++) {
                if (i + 1 == cords[0] && j + 1 == cords[1]){
                    if (rows * columns <= 60) {
                        ticketPrice = 10;
                    } else if (i + 1 <= back) {
                        ticketPrice = 10;
                    } else {
                        ticketPrice = 8;
                    }
                }
            }
        }

        return ticketPrice;
    }
    public static int bought(int purchased){
        return ++purchased;
    }

    public static int total (int rows, int columns) {
        int back;
        back = (int)Math.floor(rows/2.0) + 1;
        int total;
        int front = rows - back;

                    if (rows * columns <= 60) {
                        total = rows * columns * 10;

                    } else {
                        total = back * columns * 8 + front * columns * 10;
                    }



        return total;
    }



    public static void statistics (int purchased, int allSeats, int income, int totalPrice) {
        System.out.printf("Number of purchased tickets: %d \n", purchased);

        double percentage = (double) purchased * 100 / allSeats;
        System.out.printf("Percentage: %.2f%% \n" , percentage);

        System.out.printf("Current income: $%d \n", income);

        System.out.printf("Total income: $%d \n", totalPrice);

    }

}




