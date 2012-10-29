package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;

public interface Address extends Serializable {

	public int getId();

	public String getStreet();

	public int getStreetNumber();

	public Country getCountry();

	public int getPostCode();

	public Occupier getOccupier();
}
