package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;

public interface Price extends Serializable {

	/**
	 * It can be a number with a decimal part.
	 */
	public String getAmount();

	public Currency getCurrency();
}
