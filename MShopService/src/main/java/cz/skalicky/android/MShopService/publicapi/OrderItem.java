package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;

public interface OrderItem extends Serializable {

	public Product getProduct();

	/**
	 * Gets the number of the ordered {@link Product}.
	 */
	public int getPieceCount();

	/**
	 * Gets the price excluding VAT.
	 * 
	 * <pre>
	 * price = {@link Product#getPriceExcludingVat() product's price} * {@link #getPieceCount() amount}
	 * </pre>
	 */
	public Price getTotalPriceExcludingVat();

	/**
	 * Gets the price including VAT.
	 * 
	 * <pre>
	 * price = {@link Product#getPriceIncludingVat() product's price} * {@link #getPieceCount() amount}
	 * </pre>
	 */
	public Price getTotalPriceIncludingVat();
}
