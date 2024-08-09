package adapter;

public class PhonePe {
	 BankApiAdapter apiAdapter=new YesBankApiAdapter();

	public double checkBalance(User user) {
		return apiAdapter.checkBalance(user);
	}

	public int doTransfer(User fromUser, User toUser, int amount) {
		return apiAdapter.doTransfer(fromUser, toUser, amount);
	}

	public boolean changePin(User user, String oldPing, String newPin) {
		return apiAdapter.changePin(user, oldPing, newPin);
	}
}
