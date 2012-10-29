package cz.skalicky.android.MShopService.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import cz.skalicky.android.MShopService.publicapi.Address;
import cz.skalicky.android.MShopService.publicapi.Customer;
import cz.skalicky.android.MShopService.publicapi.Order;
import cz.skalicky.android.MShopService.publicapi.OrderItem;
import cz.skalicky.android.MShopService.publicapi.Price;

@Entity
@Table(name = "ORDERS")
public class OrderImpl implements Order {

	private static final long serialVersionUID = 6132592928994873145L;

	private int id = -1;
	private List<OrderItem> orderItems = null;
	private Price totalPriceExcludingVat = null;
	private Price totalPriceIncludingVat = null;
	private Customer customer = null;
	private Date creationDate = null;
	private Date receiveDate = null;
	private Date payDate = null;
	private Date shippingDate = null;
	private Date closeDate = null;
	private Address invoiceAddress = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Override
	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Embedded
	@Column(nullable = false)
	@Override
	public Price getTotalPriceExcludingVat() {
		return this.totalPriceExcludingVat;
	}

	public void setTotalPriceExcludingVat(Price totalPriceExcludingVat) {
		this.totalPriceExcludingVat = totalPriceExcludingVat;
	}

	@Embedded
	@Column(nullable = false)
	@Override
	public Price getTotalPriceIncludingVat() {
		return this.totalPriceIncludingVat;
	}

	public void setTotalPriceIncludingVat(Price totalPriceIncludingVat) {
		this.totalPriceIncludingVat = totalPriceIncludingVat;
	}

	@ManyToOne(targetEntity = CustomerImpl.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@Override
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Basic
	@Override
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Basic
	@Override
	public Date getReceiveDate() {
		return this.receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	@Basic
	@Override
	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	@Basic
	@Override
	public Date getShippingDate() {
		return this.shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	@Basic
	@Override
	public Date getCloseDate() {
		return this.closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@ManyToOne(targetEntity = AddressImpl.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@Override
	public Address getInvoiceAddress() {
		return this.invoiceAddress;
	}

	public void setInvoiceAddress(Address invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	@Transient
	@Override
	public boolean isReceived() {
		final Date now = new Date();
		return (this.receiveDate != null) && !now.before(this.receiveDate);
	}

	@Transient
	@Override
	public boolean isPaid() {
		final Date now = new Date();
		return (this.payDate != null) && !now.before(this.payDate);
	}

	@Transient
	@Override
	public boolean isShipped() {
		final Date now = new Date();
		return (this.shippingDate != null) && !now.before(this.shippingDate);
	}

	@Transient
	@Override
	public boolean isClosed() {
		final Date now = new Date();
		return (this.closeDate != null) && !now.before(this.closeDate);
	}
}
