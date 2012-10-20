package cz.skalicky.android.MShopService.domain;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cz.skalicky.android.MShopService.publicapi.Category;
import cz.skalicky.android.MShopService.publicapi.Product;

@Entity
@Table(name = "categories")
public class CategoryImpl implements Category {

	private static final long serialVersionUID = 9044713624533599033L;

	private int id = -1;
	private String name = null;
	private Set<Product> products = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(unique = true, nullable = false)
	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(targetEntity = Product.class)
	@JoinTable(name = "category_product", joinColumns = @JoinColumn(name = "categoryId"), inverseJoinColumns = @JoinColumn(name = "productId"))
	@Override
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
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
