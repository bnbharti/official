package observer;

import java.util.ArrayList;
import java.util.List;

public class Amazon {
	List<OrderPlaceSubscriber> orderPlaceSubscribers;

	public Amazon() {
		this.orderPlaceSubscribers = new ArrayList<>();
	}

	public void placeOrder() {
		for (OrderPlaceSubscriber o : orderPlaceSubscribers) {
			o.orderPlaceEvent();
		}
	}

	public void addOrderPlaceSubscriber(OrderPlaceSubscriber orderPlaceSubscriber) {
		orderPlaceSubscribers.add(orderPlaceSubscriber);
	}

	public void removeOrderPlaceSubscriber(OrderPlaceSubscriber orderPlaceSubscriber) {
		orderPlaceSubscribers.remove(orderPlaceSubscriber);
	}
}
