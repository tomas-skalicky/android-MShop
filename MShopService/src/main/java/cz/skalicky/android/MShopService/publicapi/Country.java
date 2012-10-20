package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;

public interface Country extends Serializable {

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
