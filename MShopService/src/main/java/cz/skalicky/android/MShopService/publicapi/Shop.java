package cz.skalicky.android.MShopService.publicapi;

import java.net.URL;

public interface Shop {

	public int getId();

	public int getName();

	public String getDescription();

	public Address getHeadquarterAddress();

	public PhoneNumber getPhoneNumber();

	public String getEmail();

	public URL getHomepage();
}
