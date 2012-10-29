package cz.skalicky.android.MShopService.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import cz.skalicky.android.MShopService.publicapi.Rating;
import cz.skalicky.android.MShopService.publicapi.RatingAuthor;

@Entity
@Table(name = "RATING_AUTHORS")
public class RatingAuthorImpl extends PersonImpl implements RatingAuthor {

	private static final long serialVersionUID = -7568754517678346726L;

	private List<Rating> ratings = null;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Override
	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Transient
	@Override
	public List<Rating> getRatings(Comparator<Rating> comparator) {
		List<Rating> collectionForSort = new ArrayList<Rating>(this.ratings);
		Collections.sort(collectionForSort, comparator);
		return collectionForSort;
	}
}
