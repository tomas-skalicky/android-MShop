package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;

public interface PhoneNumber extends Serializable {

	public String getCountry();

	public String getPrefix();

	public int getLocalNumber();
}
