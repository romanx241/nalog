package ru.netology.java30.nalogip;
import java.util.Scanner;

public class NalogIP3 {


    public static void main(String[] args) {
        int income = 0;
        int expense = 0;

        Scanner scan = new Scanner(System.in);

        while (true) {
            printMenu();
            final String userSelect = scan.nextLine();
            switch (userSelect) {
                case "1":
                    System.out.println("Введите новый доход: ");
                    income += Integer.parseInt(scan.nextLine());
                    break;
                case "2":
                    System.out.println("Введите новый расход: ");
                    expense += Integer.parseInt(scan.nextLine());
                    break;
                case "3":
                    int tax6 = calculateTax6(income);
                    int tax15 = calculateTax15(income, expense);
                    if(tax6 == tax15) {
                        System.out.println("Все равно какую стратегию выбирать, придется заплатить "
                                + tax6 / 100 + " рублей");
                    } else if (tax6 < tax15){
                        printResult("УСН 6%", tax6, tax15);
                    } else {
                        printResult("УСН 15%", tax15, tax6);
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

        private static void printResult(String strategy, int targetTax, int altTax) {
            System.out.println("Вам лучше выбрать стратегию " + strategy);
            System.out.println("По ней нужно заплатить " + targetTax);
            System.out.println("По другой нужно заплатить " + altTax);
            System.out.println("Экономия составит " + (altTax - targetTax));
        }

        private static int calculateTax6(int income) {
            return income * 6 / 100;
         }

         private static int calculateTax15(int income, int expense) {
            int diff = income - expense;
            if (diff <= 0) return 0;
             return diff * 15 / 100;
    }

         private static void printMenu() {
             System.out.println("Выберите операцию и введите ее номер: \n" +
                     "1. Добавьте новый доход\n" +
                     "2. Добавьте новый расход\n" +
                     "3. Выберите систему налогообложения");

    }
}








