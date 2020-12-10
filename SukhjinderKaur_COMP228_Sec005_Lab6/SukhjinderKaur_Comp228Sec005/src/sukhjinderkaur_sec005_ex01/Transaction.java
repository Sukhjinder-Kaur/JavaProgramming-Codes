package sukhjinderkaur_sec005_ex01;

public class Transaction implements Runnable {

	// field for transaction

	private final Account account;
	private final int amount;
	private boolean deposit = true;

	// constructor
	public Transaction(Account account, int amount, boolean deposit) {
		super();
		this.account = account;
		this.amount = amount;
		this.deposit = deposit;
	}

	// method run contains the code that a thread will execute
	public void run() {
		if (deposit) {
			account.deposit(amount);
		} else{
			account.withdraw(amount);
		}
	}

}
