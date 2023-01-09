package ru.netology.java30.nalogip;
import java.util.Scanner;

public class NalogIP1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0; // доходы
        int spendings = 0; // расходы
        int money;
        int taxEMS = taxEarningsMinusSpendings(earnings, spendings); // Налог по УНС "Доходы Минус Расходы"
        int taxE = taxEarnings(earnings); // Налог по УНС "Доходы"

        while(true) {
            System.out.println("Выберите операцию и введите ее номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("end - выход из программы");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStr2 = scanner.nextLine();
                    money = Integer.parseInt(moneyStr2);
                    spendings += money;
                    break;
                case 3:
                    if (taxEMS < taxE) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxEMS);
                        System.out.println("Налог на другой системе: " + taxE);
                        System.out.println("Экономия: " + (taxE - taxEMS));
                    } else {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxE);
                        System.out.println("Налог на другой системе: " + taxEMS);
                        System.out.println("Экономия: " + (taxEMS - taxE));
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена");
    }

    /* Метод рассчета УСН доходы минус расходы */

    private static int taxEarningsMinusSpendings (int earnings, int spendings){
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    /* Метод рассчета УСН доходы */

    public static int taxEarnings (int earnings){
        int tax2 = earnings * 6 / 100;
        if (tax2 >= 0) {
            return tax2;
        } else {
            return 0;
        }
    }
}
