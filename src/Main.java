import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount account1 =
                new BankAccount("ACC001", "Aida", 50000);

        BankAccount account2 =
                new BankAccount("ACC002", "Dana", 10000);

        TransferService transferService = new TransferService();

        try {
            System.out.print("Введите сумму перевода: ");

            String input = scanner.nextLine();

            double amount = Double.parseDouble(input);

            transferService.transfer(account1, account2, amount);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа!");

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } finally {
            System.out.println("Операция перевода завершена");
        }

        System.out.println("\n--- Балансы счетов ---");

        System.out.println(
                account1.getOwner() + ": "
                        + account1.getBalance() + " тенге"
        );

        System.out.println(
                account2.getOwner() + ": "
                        + account2.getBalance() + " тенге"
        );

        scanner.close();
    }
}