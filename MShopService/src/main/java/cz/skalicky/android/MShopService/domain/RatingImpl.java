package cz.skalicky.android.MShopService.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cz.skalicky.android.MShopService.publicapi.Product;
import cz.skalicky.android.MShopService.publicapi.Rating;
import cz.skalicky.android.MShopService.publicapi.RatingAuthor;

@Entity
@Table(name = "ratings")
public class RatingImpl implements Rating {

	private static final long serialVersionUID = 8497522842039455766L;

	private RatingPrimaryKey primaryKey = new RatingPrimaryKey();
	private int ratingValue = -1;
	private Date date = null;

	@Embedded
	@Id
	@Column(nullable = false, insertable = false, updatable = false)
	public RatingPrimaryKey getPrimaryKey() {
		return this.primaryKey;
	}

	@Override
	public int getRatingValue() {
		return this.ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}

	@Basic(optional = false)
	@Override
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Product getProduct() {
		return this.primaryKey.getProduct();
	}

	@Override
	public RatingAuthor getAuthor() {
		return this.primaryKey.getAuthor();
	}

	@Embeddable
	public class RatingPrimaryKey implements Serializable {

		private static final long serialVersionUID = -2145731311848237858L;

		private Product product = null;
		private RatingAuthor author = null;

		@ManyToOne
		@JoinColumn(name = "rating_product_fk", insertable = false, updatable = false)
		public Product getProduct() {
			return this.product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		@ManyToOne
		@JoinColumn(name = "rating_ratingAuthor_fk", insertable = false, updatable = false)
		public RatingAuthor getAuthor() {
			return this.author;
		}

		public void setAuthor(RatingAuthor author) {
			this.author = author;
		}
	}
}
