package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();

		System.out.print("Holder: ");
		String holder = sc.nextLine();
		sc.nextLine();

		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();

		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, initialBalance, withdrawLimit);

		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();

		try {
			acc.withdraw(amount);
			System.out.println(acc);

		} catch (AccountExceptions e) {
			System.out.println(e.getMessage());

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}

}
