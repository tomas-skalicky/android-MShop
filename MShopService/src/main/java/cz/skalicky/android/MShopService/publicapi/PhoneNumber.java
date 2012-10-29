package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;

public interface PhoneNumber extends Serializable {

	public Country getCountry();

	public String getPrefix();

	public int getLocalNumber();
}
