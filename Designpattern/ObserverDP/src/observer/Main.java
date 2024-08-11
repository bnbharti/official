package observer;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Amazon amazon = new Amazon();
		amazon.addOrderPlaceSubscriber(new CustomerNortificationServcie());
		amazon.addOrderPlaceSubscriber(new InvoiceGneratorService());
		amazon.placeOrder();
	}
}
