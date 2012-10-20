package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;
import java.util.Set;

public interface Category extends Serializable {

	public int getId();

	public String getName();

	public Set<Product> getProducts();
}
