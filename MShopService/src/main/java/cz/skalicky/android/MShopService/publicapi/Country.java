package cz.skalicky.android.MShopService.publicapi;

public interface Country {

	public String getName();

	/**
	 * <p>
	 * Gets the VAT.
	 * </p>
	 * <p>
	 * <i>DPH</i> is the equivalent for VAT in the Czech language.
	 * </p>
	 */
	public int getValueAddedTax();
}
