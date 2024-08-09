package adapter;

public interface BankApiAdapter {

	double checkBalance(User user);
	int doTransfer(User fromUser, User toUser,int amount);
	boolean changePin(User user,String oldPing,String newPin);
}
