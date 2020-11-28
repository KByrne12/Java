public class BankerThread extends Thread {

    Bank bank;

    int costumerNum;

    public BankerThread(Bank b1, int costumerNum) {
        this.bank = b1;
        this.costumerNum = costumerNum;
    }

    @Override
    public void run() {
        synchronized (bank) {
            bank.requestResources(costumerNum);
            bank.calculateCustomerNeed(costumerNum);
            bank.runProcess(costumerNum);
        }
    }


}
