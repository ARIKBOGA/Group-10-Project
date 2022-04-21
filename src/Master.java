
import java.util.Scanner;

class Employee implements Runnable {
    private final String name;
    private static final Work work;

    static {
        work = new Work(new Scanner(System.in).nextDouble());
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        doWork(work);
    }


    public synchronized void doWork(Work work) {

        while (work.getAmount() > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            work.setAmount(work.getAmount() - 1);
            System.out.println(this.getName() + "-> Remaining work: " + work.getAmount());
        }
        if (work.getAmount() < 5 && work.getAmount() != 0) {
            work.setAmount(0);
            System.out.println("Remaining work: " + work.getAmount());
        }

    }
}

class Work {
    private double amount;

    public Work(double amount) {
        this.amount = amount;
    }

    public synchronized double getAmount() {
        return amount;
    }

    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }
}

class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("E-1");
        Employee e2 = new Employee("E-2");
        Employee e3 = new Employee("E-3");


        Thread t1 = new Thread(e1);
        Thread t2 = new Thread(e2);
        Thread t3 = new Thread(e3);


        t1.start();
        t2.start();
        t3.start();
    }
}