package adapter;

public class IciciBankApi {
	double checkBalance(User user) {
		System.out.println(user.getName()+" -Checking balance from ICICI");
		return 2000;
	}
	int doTransfer(User fromUser, User toUser,int amount) {
		System.out.println(fromUser.getName()+" transfering an amount of "+amount+" to "+toUser.getName());
		return 200;
	}
	
	boolean changePint(User user,String oldPing,String newPin) {
		return true;
	}

}
