package sukhjinderkaur_sec005_ex01;

public class Account extends Thread {

	// Balance in account
	private double balance;

	// Constructor
	public Account(double initialDeposit) {

		balance = initialDeposit;
	}

	public synchronized double getBalance() {

		return balance;
	}

	// synchronized function to deposit amount in a/c
	public synchronized void deposit(double amountdeposited) {

		try {
			Thread.sleep(1000);
			balance += amountdeposited;

		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		System.out.printf("%s deposited %.2f in account.\n", Thread.currentThread().getName(), amountdeposited);

		System.out.println(toString() + "\n");
	}

	// synchronized function to withdraw amount from a/c
	public synchronized void withdraw(double amountwithdrawn) {

		try {
			Thread.sleep(1000);
			if (balance >= amountwithdrawn) {
				balance -= amountwithdrawn;
			}

		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		System.out.printf("%s withdrawn %.2f from account.\n", Thread.currentThread().getName(), amountwithdrawn);

		System.out.println(toString() + "\n");

	}

	@Override
	public String toString() {
		return "Account Balance is:" + balance;
	}

}
