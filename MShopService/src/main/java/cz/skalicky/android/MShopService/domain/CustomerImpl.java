package cz.skalicky.android.MShopService.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import cz.skalicky.android.MShopService.publicapi.Address;
import cz.skalicky.android.MShopService.publicapi.Customer;
import cz.skalicky.android.MShopService.publicapi.Order;

@Entity
@Table(name = "CUSTOMERS")
public class CustomerImpl extends PersonImpl implements Customer {

	private static final long serialVersionUID = 6635645349811540383L;

	private List<Address> deliveryAddresses = null;
	private List<Address> invoiceAddresses = null;
	private List<Order> ordersOrderedByDate = null;

	@OneToMany(mappedBy = "occupier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Override
	public List<Address> getDeliveryAddresses() {
		return this.deliveryAddresses;
	}

	public void setDeliveryAddresses(List<Address> deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	@OneToMany(mappedBy = "occupier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Override
	public List<Address> getInvoiceAddresses() {
		return this.invoiceAddresses;
	}

	public void setInvoiceAddresses(List<Address> invoiceAddresses) {
		this.invoiceAddresses = invoiceAddresses;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Override
	public List<Order> getOrdersOrderedByDate() {
		return this.ordersOrderedByDate;
	}

	public void setOrdersOrderedByDate(List<Order> ordersOrderedByDate) {
		this.ordersOrderedByDate = ordersOrderedByDate;
	}

	@Transient
	@Override
	public Address getAddress() {
		if (this.getInvoiceAddresses().size() > 0) {
			return this.getInvoiceAddresses().get(0);
		} else {
			return null;
		}
	}
}
