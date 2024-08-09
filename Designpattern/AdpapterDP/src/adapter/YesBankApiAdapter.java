package adapter;

public class YesBankApiAdapter implements BankApiAdapter {
	YesBankApi yesApi = new YesBankApi();

	@Override
	public double checkBalance(User user) {
		return yesApi.checkBalance(user);
	}

	@Override
	public int doTransfer(User fromUser, User toUser, int amount) {
		return (int) yesApi.doTransfer(fromUser, toUser, amount);
	}

	@Override
	public boolean changePin(User user, String oldPing, String newPin) {
		char changePint = yesApi.changePint(user, oldPing, newPin);
		return changePint == 'Y' ? true : false;
	}

}
