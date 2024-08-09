package adapter;

import java.util.UUID;

public class Main {
	public static void main(String[] args) {
		User fromUser = User.builder().name("Narendra").userId(UUID.randomUUID()).pin(1234).build();
		User toUser = User.builder().name("Bharti").userId(UUID.randomUUID()).pin(8910).build();
		int amount = 100;
		PhonePe phonePe = new PhonePe();
		phonePe.changePin(fromUser, "old", "new");
		phonePe.checkBalance(fromUser);
		phonePe.doTransfer(fromUser, toUser, amount);
	}
}
