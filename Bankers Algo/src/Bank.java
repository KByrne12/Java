public class Bank {
    int numThreads;
    int numResources;
    int minAvailable = 1;
    int maxAvailable = 10;
    int minNeed = 0;

    int[] available;
    int[] currentAvailable;
    int[] customerResource;
    int[] safeCustomers;
    int[][] maximum;
    int[][] allocation;
    int[][] need;

    public Bank(int m, int n) {
        this.numResources = m;
        this.numThreads = n;

        available = new int[this.numResources];

        currentAvailable = new int[this.numResources];

        safeCustomers = new int[this.numThreads];

        for (int i = 0; i < this.numResources; i++) {
            int allocationOfResource = (int) Math.round(Math.random() *
                    (this.maxAvailable - minAvailable) + minAvailable);
            available[i] = allocationOfResource;
            currentAvailable[i] = allocationOfResource;
        }

        maximum = new int[numThreads][numResources];

        for (int i = 0; i < maximum.length; i++) {
            for (int j = 0; j < maximum[i].length; j++) {

                int maxs = (int) Math.round(Math.random() *
                        (this.available[j] - minNeed) + minNeed);
                maximum[i][j] = maxs;

            }
        }

        allocation = new int[numThreads][numResources];

        need = new int[numThreads][numResources];

        customerResource = new int[this.numResources];

        getState();

    }

    public void calculateCustomerNeed(int customerNum) {

        for (int i = 0; i < this.numResources; i++) {
            int customerNeed = maximum[customerNum][i] - allocation[customerNum][i];

            need[customerNum][i] = customerNeed = Math.abs(customerNeed);

        }

        displayNeed();

    }


    public boolean requestResources(int customerNumber) {

        for (int i = 0; i < this.numResources; i++) {
            int customerNeed = (int) Math.round(Math.random() *
                    (this.maximum[customerNumber][i] - minNeed) + minNeed);
            customerResource[i] = customerNeed;

            allocation[customerNumber][i] += customerResource[i];

            if (allocation[customerNumber][i] > maximum[customerNumber][i])
                allocation[customerNumber][i] = maximum[customerNumber][i];

        }

        displayCustomerRequest(customerNumber);

        displayAllocation();

        return false;
    }


    public void releaseRecources(int customerNumber, int[] release) {
        // TODO Auto-generated method stub

    }

    public boolean safeProcess(int customerNumber) {
        boolean safe = false;

        for (int i = 0; i < this.numResources; i++) {
            if (currentAvailable[i] >= need[customerNumber][i])
                safe = true;

            else {
                safe = false;
                break;
            }

        }

        return safe;
    }


    public void runProcess(int customerNumber) {

        if (safeProcess(customerNumber)) {

            for (int j = 0; j < this.numResources; j++) {
                currentAvailable[j] = allocation[customerNumber][j] + currentAvailable[j];

            }
            displayOnCommandLine("Customer " + customerNumber + " request is granted\n");

            displayCurrentlyAvailable();

            displayOnCommandLine("\n");

        }
    }

    private static void displayOnCommandLine(Object o) {

        System.out.print(o);

    }


    public void displayCustomerRequest(int customerNumber) {

        displayOnCommandLine("Customer " + customerNumber + "Request: \n");

        for (int b : this.customerResource) {
            displayOnCommandLine(b + " ");
        }

        displayOnCommandLine("\n");


    }

    public void displayAllocation() {
        displayOnCommandLine("\nBank - Allocation: \n");

        for (int j = 0; j < this.allocation.length; j++) {
            for (int k = 0; k < this.allocation[j].length; k++) {
                displayOnCommandLine(this.allocation[j][k] + " ");
            }

            displayOnCommandLine("\n");

        }
    }

    public void displayNeed() {
        displayOnCommandLine("\nBank - Need: \n");

        for (int j = 0; j < this.need.length; j++) {
            for (int k = 0; k < this.need[j].length; k++) {
                displayOnCommandLine(this.need[j][k] + " ");
            }

            displayOnCommandLine("\n");
        }

        displayOnCommandLine("\n");
    }

    public void displayMax() {

        displayOnCommandLine("\nBank - Max:\n");

        for (int i = 0; i < this.maximum.length; i++) {
            for (int j = 0; j < this.maximum[i].length; j++) {
                displayOnCommandLine(this.maximum[i][j] + " ");
            }
            displayOnCommandLine("\n");
        }
    }

    public void displayAvailable() {
        displayOnCommandLine("\nBank - Initial Resources Available:\n");

        for (int a : this.available) {
            displayOnCommandLine(a + " ");
        }

        displayOnCommandLine("\n");
    }

    public void displayCurrentlyAvailable() {
        displayOnCommandLine("\nCurrent Available Work: \n");

        for (int c : this.currentAvailable) {
            displayOnCommandLine(c + " ");
        }

        displayOnCommandLine("\n");
    }

    public void getState() {

        displayAvailable();
        displayMax();
        displayAllocation();
        displayNeed();
    }

}