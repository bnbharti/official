package observer;

public class InvoiceGneratorService implements OrderPlaceSubscriber {

	@Override
	public void orderPlaceEvent() {
		System.out.println("Generate invoice");
	}
}
