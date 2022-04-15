import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            System.out.println("Введите \"end\" для выхода из программы");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода");
                    String consumptionStr = scanner.nextLine();
                    int consumption = Integer.parseInt(consumptionStr);
                    spendings += consumption;
                    break;
                case 3:
                    int taxEarningsMinus = taxEarningsMinusSpendings(earnings, spendings);
                    int taxEarning = taxEarnings(earnings);
                    if (taxEarning < taxEarningsMinus) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxEarning + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarningsMinus + " рублей");
                        System.out.println("Экономия: " + (taxEarningsMinus - taxEarning) + " рублей");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxEarningsMinus + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarning + " рублей");
                        System.out.println("Экономия: " + (taxEarning - taxEarningsMinus) +" рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }

        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int taxs = earnings * 6 / 100;
        return taxs;

    }
}