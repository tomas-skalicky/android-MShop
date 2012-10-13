package cz.skalicky.android.MShopService.beans;

import java.util.Set;

import org.springframework.stereotype.Component;

import cz.skalicky.android.MShopService.publicapi.Category;
import cz.skalicky.android.MShopService.publicapi.Product;

@Component("category")
public class CategoryImpl implements Category {

	@Override
	public int getId() {
		return 111;
	}

	@Override
	public String getName() {
		return "REST ff";
	}

	@Override
	public Set<Product> getProducts() {
		return null;
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer("CategoryImpl [");
		builder.append(this.getId()).append(", ");
		builder.append(this.getName()).append(", ");
		builder.append(this.getProducts()).append("]");
		return builder.toString();
	}
}
