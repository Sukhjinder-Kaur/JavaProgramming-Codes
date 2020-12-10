package sukhjinderkaur_sec005_ex01;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Balance in account at the beginning
		int initialBalance = 3500;
		
		System.out.println("-------------Starting Account Transactions---------------" + "\n");
		System.out.println("Starting balance in account:" + initialBalance + "\n");

		// New account
		Account account = new Account(initialBalance);
		
		
		// array for transactions
		ArrayList<Transaction> listOfTransactions = new ArrayList<Transaction>();

		// Transactions in account

		Transaction firstTransaction = new Transaction(account, 500, true);
		Transaction secondTransaction = new Transaction(account, 700, false);
		Transaction thirdTransaction = new Transaction(account, 30, true);


		// transactions added to list

		listOfTransactions.add(firstTransaction);
		listOfTransactions.add(secondTransaction);
		listOfTransactions.add(thirdTransaction);

		
		// create ExecutorService to manage threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// transaction loop
		listOfTransactions.forEach((n) -> executorService.execute(n));

		// shut down ExecutorService
		executorService.shutdown();

		try {

			boolean transactionComplete = executorService.awaitTermination(40, TimeUnit.SECONDS);
			if (transactionComplete) {

				System.out.println("Final " + account.toString());

			} else {

				System.out.println("Time up");

			}

		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

	}

}
