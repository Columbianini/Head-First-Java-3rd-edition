package Chapter18;

public class BankAccount {
    private int balance;

    public BankAccount(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void spend(int amount){
        balance -= amount;
        if (balance < 0) {
            System.out.println("Overdrawn!");}
    }
    
}
