package com.bharti;

public class Application {
	public static void main(String[] args) {
		// Child Object parrent reference upcasting
		OldTV oldTV = new NewTV();
		oldTV.switchOf();
		// -----------------------------------
		try {
			NewTV newTv = (NewTV) new OldTV(); /// Down casting is not possible
			// newTv.changeChannel();
		} catch (Exception e) {
			System.out.println("message:-" + e.getMessage());
			System.out.println("Cause: - " + e.getCause());

		}
	}
}
