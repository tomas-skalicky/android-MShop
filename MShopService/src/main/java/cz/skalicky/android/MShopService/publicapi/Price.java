package cz.skalicky.android.MShopService.publicapi;

public interface Price {

	/**
	 * It can be a number with a decimal part.
	 */
	public String getAmount();

	public Currency getCurrency();
}
