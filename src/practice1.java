interface Paymentable {
    void pay(double amount);
    void receive(double amount);
}

class TransactionLogger {
    static void logger(String message){
        System.out.println(message);
    };
}

class UPIpayment implements Paymentable {
    private static double totalAmount=0;

    @Override
    public void pay(double amount){
        if(amount>totalAmount){
            TransactionLogger.logger("not enough money in account");
            return;
        }
        totalAmount-=amount;
        TransactionLogger.logger(amount + " money debited from account");
    }

    @Override
    public void receive(double amount){
        totalAmount+=amount;
        TransactionLogger.logger(amount + " money credited in account");
    }
}
