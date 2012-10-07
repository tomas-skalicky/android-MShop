package cz.skalicky.android.MShopService.publicapi;

import java.util.Set;

public interface Category {

	public int getId();

	public String getName();

	public Set<Product> getProducts();
}
