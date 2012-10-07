package cz.skalicky.android.MShopService.publicapi;

public interface Address {

	public String getStreet();

	public int getStreetNumber();

	public Country getCountry();

	public int getPostCode();
}
