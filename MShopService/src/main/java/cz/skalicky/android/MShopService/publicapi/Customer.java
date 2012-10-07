package cz.skalicky.android.MShopService.publicapi;

import java.util.List;

public interface Customer extends Person {

	public List<Address> getDeliveryAddresses();

	public List<Address> getInvoiceAddresses();

	public List<Order> getOrdersOrderedByDate();
}
