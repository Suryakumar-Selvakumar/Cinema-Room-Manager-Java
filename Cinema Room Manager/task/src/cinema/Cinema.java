package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        System.out.println();

        String[][] cinema = new String[rows][seats];
        populateTheatre(cinema);

        int[][] prices = new int[rows][seats];
        computePrices(prices);

        boolean showMenu = true;

        while (showMenu) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int input = sc.nextInt();
            switch (input) {
                case 0:
                    showMenu = false;
                    break;
                case 1:
                    printTheatre(cinema);
                    break;
                case 2:
                    boolean seatNotBooked = true;
                    while (seatNotBooked) {
                        System.out.println("\nEnter a row number:");
                        int chosenRow = sc.nextInt();

                        System.out.println("Enter a seat number in that row:");
                        int chosenSeat = sc.nextInt();

                        if (chosenRow - 1 > cinema.length - 1 || chosenSeat - 1 > cinema[0].length - 1) {
                            System.out.println("Wrong input!");
                            continue;
                        }

                        if (cinema[chosenRow - 1][chosenSeat - 1].equals("B")) {
                            System.out.println("\nThat ticket has already been purchased!");
                            continue;
                        } else {
                            cinema[chosenRow - 1][chosenSeat - 1] = "B";
                            seatNotBooked = false;
                        }

                        System.out.printf("Ticket price: $%d\n", prices[chosenRow - 1][chosenSeat - 1]);
                        System.out.println();
                    }
                    break;
                case 3:
                    // stats
                    int purchasedTickets = getPurchasedTickets(cinema);
                    System.out.printf("\nNumber of purchased tickets: %d\n", purchasedTickets);
                    System.out.printf("Percentage: %.2f%%", getBookingPercentage(purchasedTickets, cinema.length * cinema[0].length));
                    System.out.printf("\nCurrent income: $%d\n", calculateCurrentIncome(cinema, prices));
                    System.out.printf("Total income: $%d\n\n", calculateTotalIncome(prices));
                    break;
            }
        }
    }

    static void populateTheatre(String[][] cinema) {
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[0].length; j++) {
                cinema[i][j] = "S";
            }
        }
    }

    static void computePrices(int[][] prices) {
        int seatCount = prices.length * prices[0].length;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices[i].length; j++) {
                if (seatCount <= 60 || i < prices.length / 2) {
                    prices[i][j] = 10;
                } else {
                    prices[i][j] = 8;
                }
            }
        }
    }

    static void printTheatre(String[][] cinema) {
        String theatre = "\nCinema:\n";
        for (int i = -1; i < cinema.length; i++) {
            for (int j = -1; j < cinema[0].length; j++) {
                if (i == -1) {
                    theatre += j == -1 ? "  " : j + 1 + " ";
                    continue;
                }
                theatre += j == -1 ? i + 1 + " " : cinema[i][j] + " ";
            }
            theatre += "\n";
        }

        System.out.println(theatre);
    }

    static int getPurchasedTickets(String[][] cinema) {
        int purchasedTickets = 0;

        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[0].length; j++) {
                if (cinema[i][j].equals("B")) {
                    purchasedTickets++;
                }
            }
        }

        return purchasedTickets;
    }

    static double getBookingPercentage(int purchasedTickets, int seatCount) {
        return ((double) purchasedTickets / seatCount) * 100;
    }

    static int calculateCurrentIncome(String[][] cinema, int[][] prices) {
        int currentIncome = 0;

        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[0].length; j++) {
                if (cinema[i][j].equals("B")) {
                    currentIncome += prices[i][j];
                }
            }
        }

        return currentIncome;
    }

    static int calculateTotalIncome(int[][] prices) {
        int totalIncome = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices[i].length; j++) {
                totalIncome += prices[i][j];
            }
        }

        return totalIncome;
    }
}