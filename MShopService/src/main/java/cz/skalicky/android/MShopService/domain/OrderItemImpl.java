package cz.skalicky.android.MShopService.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cz.skalicky.android.MShopService.publicapi.OrderItem;
import cz.skalicky.android.MShopService.publicapi.Price;
import cz.skalicky.android.MShopService.publicapi.Product;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItemImpl implements OrderItem {

	private static final long serialVersionUID = 25142647556866928L;

	private int id = -1;
	private Product product = null;
	private int pieceCount = -1;
	private Price totalPriceExcludingVat = null;
	private Price totalPriceIncludingVat = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(targetEntity = ProductImpl.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@Override
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Basic(optional = false)
	@Override
	public int getPieceCount() {
		return this.pieceCount;
	}

	public void setPieceCount(int pieceCount) {
		this.pieceCount = pieceCount;
	}

	@Embedded
	@Column(nullable = false)
	@Override
	public Price getTotalPriceExcludingVat() {
		return this.totalPriceExcludingVat;
	}

	public void setTotalPriceExcludingVat(Price totalPriceExcludingVat) {
		this.totalPriceExcludingVat = totalPriceExcludingVat;
	}

	@Embedded
	@Column(nullable = false)
	@Override
	public Price getTotalPriceIncludingVat() {
		return this.totalPriceIncludingVat;
	}

	public void setTotalPriceIncludingVat(Price totalPriceIncludingVat) {
		this.totalPriceIncludingVat = totalPriceIncludingVat;
	}
}
