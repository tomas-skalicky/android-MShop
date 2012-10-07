package cz.skalicky.android.MShopService.publicapi;

import java.util.Date;
import java.util.List;

public interface Order {

	public int getId();

	public List<OrderItem> getOrderItems();

	/**
	 * Gets the total price excluding VAT.
	 */
	public Price getTotalPriceExcludingVat();

	/**
	 * Gets the total price including VAT.
	 */
	public Price getTotalPriceIncludingVat();

	/**
	 * Gets the {@link Customer} which has made this {@link Order}.
	 */
	public Customer getCustomer();

	/**
	 * Gets the time when this {@link Order} has been created.
	 */
	public Date getCreationDate();

	/**
	 * Gets the time when this {@link Order} has been received by an appropriate
	 * {@link Shop}.
	 */
	public Date getReceiveDate();

	/**
	 * Determines whether this {@link Order} has been received by an appropriate
	 * {@link Shop}.
	 */
	public boolean isReceived();

	/**
	 * Gets the time when this {@link Order} has been paid by the
	 * {@link Customer}.
	 */
	public Date getPayDate();

	/**
	 * Determines whether this {@link Order} has been paid by the
	 * {@link Customer}.
	 */
	public boolean isPaid();

	/**
	 * Gets the time when the ordered {@link Product products} have been shipped
	 * to the {@link Customer}.
	 */
	public Date getShippingDate();

	/**
	 * Determines whether the ordered {@link Product products} have been shipped
	 * to the {@link Customer}.
	 */
	public boolean isShipped();

	/**
	 * Gets the time when this {@link Order} has been closed.
	 * 
	 * @see Order#isClosed()
	 */
	public Date getCloseDate();

	/**
	 * Determines whether this {@link Order} has been closed. If so, it means
	 * that {@link Customer} has paid this {@link Order} and the ordered
	 * {@link Product}s have been shipped to him.
	 */
	public boolean isClosed();

	public Address getInvoiceAddress();
}
