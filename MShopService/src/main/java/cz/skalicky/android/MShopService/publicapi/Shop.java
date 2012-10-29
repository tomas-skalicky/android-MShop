package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;
import java.net.URL;
import java.util.List;

public interface Shop extends Serializable, Occupier {

	public int getId();

	public String getName();

	public String getDescription();

	public Address getHeadquarterAddress();

	public PhoneNumber getPhoneNumber();

	public String getEmail();

	public URL getHomepage();

	public List<Product> getProducts();
}
