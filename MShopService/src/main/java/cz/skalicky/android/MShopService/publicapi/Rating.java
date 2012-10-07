package cz.skalicky.android.MShopService.publicapi;

import java.util.Date;

public interface Rating {

	/**
	 * Gets the rated {@link Product}.
	 */
	public Product getProduct();

	public RatingAuthor getAuthor();

	public int getRatingNumber();

	/**
	 * Gets the time when this {@link Rating} has been created.
	 */
	public Date getDate();
}
