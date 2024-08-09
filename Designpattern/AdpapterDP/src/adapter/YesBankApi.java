
package adapter;

public class YesBankApi {
	int checkBalance(User user) {
		System.out.println(user.getName() + " -Checking balance from YES");
		return 2000;
	}

	double doTransfer(User fromUser, User toUser, int amount) {
		System.out.println(fromUser.getName() + " transfering an amount of " + amount + " to " + toUser.getName());
		return 200;
	}

	char changePint(User user, String oldPing, String newPin) {
		System.out.println("Doing pin change from Yes Bank");
		return 'N';
	}

}
