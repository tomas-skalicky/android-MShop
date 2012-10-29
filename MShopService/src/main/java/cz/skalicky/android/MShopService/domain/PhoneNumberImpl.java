package cz.skalicky.android.MShopService.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import cz.skalicky.android.MShopService.publicapi.Country;
import cz.skalicky.android.MShopService.publicapi.PhoneNumber;

@Embeddable
public class PhoneNumberImpl implements PhoneNumber {

	private static final long serialVersionUID = 6743689998508206543L;

	private Country country = null;
	private String prefix = null;
	private int localNumber = 0;

	@ManyToOne(targetEntity = CountryImpl.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Override
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Basic
	@Override
	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Basic(optional = false)
	@Override
	public int getLocalNumber() {
		return this.localNumber;
	}

	public void setLocalNumber(int localNumber) {
		this.localNumber = localNumber;
	}
}
