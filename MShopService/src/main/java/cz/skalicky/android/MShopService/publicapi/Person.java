package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;

public interface Person extends Serializable {

	public int getId();

	public int getFirstName();

	public int getLastName();

	public PhoneNumber getPhoneNumber();

	public String getEmail();
}
