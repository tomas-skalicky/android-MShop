package cz.skalicky.android.MShopService.domain;

import java.beans.Transient;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cz.skalicky.android.MShopService.publicapi.Category;
import cz.skalicky.android.MShopService.publicapi.Price;
import cz.skalicky.android.MShopService.publicapi.Product;
import cz.skalicky.android.MShopService.publicapi.Rating;
import cz.skalicky.android.MShopService.publicapi.Shop;

@Entity
@Table(name = "PRODUCTS")
public class ProductImpl implements Product {

	private static final long serialVersionUID = 8732642156264793179L;

	private int id = -1;
	private String name = null;
	private String description = null;
	private Shop shop = null;
	private Price priceExcludingVat = null;
	private Price priceIncludingVat = null;
	private List<Rating> ratings = null;
	private Set<Category> categories = null;
	private String availability = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic(optional = false)
	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Override
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "PRODUCT_SHOP_FK", insertable = false, updatable = false)
	@Override
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Embedded
	@Column(nullable = false)
	@Override
	public Price getPriceExcludingVat() {
		return this.priceExcludingVat;
	}

	public void setPriceExcludingVat(Price priceExcludingVat) {
		this.priceExcludingVat = priceExcludingVat;
	}

	@Embedded
	@Column(nullable = false)
	@Override
	public Price getPriceIncludingVat() {
		return this.priceIncludingVat;
	}

	public void setPriceIncludingVat(Price priceIncludingVat) {
		this.priceIncludingVat = priceIncludingVat;
	}

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Override
	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@ManyToMany(targetEntity = Category.class)
	@JoinTable(name = "PRODUCT_CATEGORY", joinColumns = @JoinColumn(name = "productId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
	@Override
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Basic(optional = false)
	@Override
	public String getAvailability() {
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Transient
	@Override
	public double getAverageRating() {
		int ratingSum = 0;
		for (Rating rating : this.ratings) {
			ratingSum += rating.getRatingValue();
		}
		return (ratingSum / this.ratings.size());
	}

	@Transient
	@Override
	public List<Rating> getRatings(Comparator<Rating> comparator) {
		List<Rating> unsortedRatings = this.getRatings();
		Collections.sort(unsortedRatings, comparator);
		return unsortedRatings;
	}
}
