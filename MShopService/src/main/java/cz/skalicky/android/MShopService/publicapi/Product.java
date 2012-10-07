package cz.skalicky.android.MShopService.publicapi;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public interface Product {

	public int getId();

	public String getName();

	public String getDescription();

	/**
	 * Gets the {@link Shop} which sells this {@link Product}.
	 */
	public Shop getShop();

	/**
	 * Gets the price excluding VAT.
	 */
	public Price getPriceExcludingVat();

	/**
	 * Gets the price including VAT.
	 */
	public Price getPriceIncludingVat();

	/**
	 * Gets the average rating of this {@link Product}.
	 */
	public double getAverageRating();

	public List<Rating> getRatings();

	public List<Rating> getRatings(Comparator<Rating> comparator);

	/**
	 * Gets {$link Category}s of which this {@link Product} is a part of.
	 */
	public Set<Category> getCategories();

	/**
	 * Gets the availability of this {@link Product}.
	 */
	public String getAvailability();
}
