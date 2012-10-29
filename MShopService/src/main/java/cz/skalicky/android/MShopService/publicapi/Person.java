package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;

public interface Person extends Serializable {

	public int getId();

	public String getFirstName();

	public String getLastName();

	public PhoneNumber getPhoneNumber();

	public String getEmail();
}
