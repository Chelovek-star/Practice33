
public class TransferService {

    public void transfer(
            BankAccount from,
            BankAccount to,
            double amount
    ) throws InsufficientFundsException {

        if (from == null || to == null) {
            throw new IllegalArgumentException(
                    "Оба счёта должны существовать"
            );
        }

        if (from == to ||
                from.getAccountNumber().equals(to.getAccountNumber())) {
            throw new IllegalArgumentException(
                    "Нельзя переводить деньги на тот же счёт"
            );
        }

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Сумма перевода должна быть положительной"
            );
        }

        // Сначала проверяем баланс и списываем деньги
        from.withdraw(amount);

        // Затем зачисляем деньги получателю
        to.deposit(amount);

        System.out.println("Перевод успешно выполнен!");
    }
}