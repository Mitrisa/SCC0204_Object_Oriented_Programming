// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessôto 13749653

//Exception para saldo negativo
class InvalidBalanceException extends Exception {
    InvalidBalanceException(String errorMessage) {
        super(errorMessage);
    }
}

//Exception para saque negativo
class InvalidAmountException extends Exception {
    InvalidAmountException(String errorMessage) {
        super(errorMessage);
    }
}

//Exception para deposito negativo
class InvalidDepositException extends Exception {
    InvalidDepositException(String errorMessage) {
        super(errorMessage);
    }
}

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //Verifica se o depósito é negativo
    public void deposit(double amount) throws InvalidDepositException{
        if ( amount < 0) {
            throw new InvalidDepositException("Valor de depósito inválido");
        }
        balance += amount;
    }

    // Método para sacar dinheiro modificado para lançar exceções
    public void withdraw(double amount) throws InvalidBalanceException, InvalidAmountException {
        // Verifica saldo negativo
        if (balance < 0) {
            throw new InvalidBalanceException("Saldo inválido");
        }
        // Verifica valor de saque negativo
        if (amount < 0) {
            throw new InvalidAmountException("Valor inválido");
        }
        // Verifica se o valor de saque é maior que o saldo
        if (amount > balance) {
            throw new InvalidAmountException("Fundos insuficientes para saque");
        }
        // Saque válido, atualiza o saldo
        balance -= amount;
    }

    //Mostra o saldo atual
    public void displayBalance() {
        System.out.println("Saldo atual: " + balance);
    }

    // Método para lidar com o saque
    public void performTransaction(double amount) {
        try {
            withdraw(amount);
            System.out.println("Saque de " + amount + " realizado com sucesso.");
        } catch (InvalidBalanceException | InvalidAmountException e) {
            System.out.println("Erro ao realizar saque: " + e.getMessage());
        }
    }

    //Método para lidar com depósito
    public void performDeposit (double amount) {
        try {
            deposit(amount);
            System.out.println("Depósito de " + amount + " realizado com sucesso.");
        } catch (InvalidDepositException e) {
            System.out.println("Erro ao realizar depósito: " + e.getMessage());
        }
    }
    

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(100);
        myAccount.performDeposit(50); // Depósito sem exceções
        myAccount.performDeposit(-20); //Depósito com exceção (valor negativo)
        myAccount.performTransaction(20); // Saque sem exceções
        myAccount.performTransaction(200); // Saque com exceção (saldo insuficiente)
        myAccount.displayBalance(); // Sem exceções
    }
}
