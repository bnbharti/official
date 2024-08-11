package observer;

public class CustomerNortificationServcie implements OrderPlaceSubscriber {

	@Override
	public void orderPlaceEvent() {
		System.out.println("Send SMS for order placed");
		System.out.println("Send email for order placed");
	}

}
