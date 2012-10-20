package cz.skalicky.android.MShopService.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import cz.skalicky.android.MShopService.publicapi.Currency;
import cz.skalicky.android.MShopService.publicapi.Price;

@Embeddable
public class PriceImpl implements Price {

	private static final long serialVersionUID = 2915894992954874822L;

	private String amount = null;
	private Currency currency = null;

	@Basic(optional = false)
	@Override
	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Embedded
	@Column(nullable = false)
	@Override
	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
