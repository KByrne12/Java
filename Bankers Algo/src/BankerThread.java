public class BankerThread extends Thread {

    Bank bank;

    int customerNum;

    public BankerThread(Bank b1, int customerNum) {
        this.bank = b1;
        this.customerNum = customerNum;
    }

    @Override
    public void run() {
        synchronized (bank) {
            bank.requestResources(customerNum);
            bank.calculateCustomerNeed(customerNum);
            bank.runProcess(customerNum);
        }
    }


}
