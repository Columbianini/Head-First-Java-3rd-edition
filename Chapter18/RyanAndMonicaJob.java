package Chapter18;

public class RyanAndMonicaJob implements Runnable {
    private final BankAccount account;
    private final String name;
    private final int amountToSpend;

    public RyanAndMonicaJob(BankAccount account, int amountToSpend, String name){
        this.name = name;
        this.amountToSpend = amountToSpend;
        this.account = account;
    }
    @Override
    public void run() {
        goShopping();        
    }

    private void goShopping(){
        if(account.getBalance() >= amountToSpend){
            System.out.println(name+" is about to spend");
            account.spend(amountToSpend);
            System.out.println(name+" finishes spending");
        }else{
            System.out.println("Sorry, not enough for "+name);
        }
    }
    
}
