package cz.skalicky.android.MShopService.publicapi;

import java.util.Comparator;
import java.util.List;

public interface RatingAuthor extends Person {

	public List<Rating> getRatings();

	public List<Rating> getRatings(Comparator<Rating> comparator);
}
