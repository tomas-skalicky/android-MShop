package cz.skalicky.android.MShopService.publicapi;

import java.io.Serializable;
import java.util.Date;

public interface Rating extends Serializable {

	/**
	 * Gets the rated {@link Product}.
	 */
	public Product getProduct();

	public RatingAuthor getAuthor();

	/**
	 * Gets the rating value itself.
	 */
	public int getRatingValue();

	/**
	 * Gets the time when this {@link Rating} has been created.
	 */
	public Date getDate();
}
