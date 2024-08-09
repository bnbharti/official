package adapter;

public class ICICIBankApiAdapter implements BankApiAdapter {
	IciciBankApi iciciApi = new IciciBankApi();

	@Override
	public double checkBalance(User user) {
		return iciciApi.checkBalance(user);
	}

	@Override
	public int doTransfer(User fromUser, User toUser, int amount) {
		return iciciApi.doTransfer(fromUser, toUser, amount);
	}

	@Override
	public boolean changePin(User user, String oldPing, String newPin) {
		System.out.println("Doing pin change from ICICI Bank");
		return iciciApi.changePint(user, oldPing, newPin);
	}

}
