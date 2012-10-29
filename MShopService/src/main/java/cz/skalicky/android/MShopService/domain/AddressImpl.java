package cz.skalicky.android.MShopService.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cz.skalicky.android.MShopService.publicapi.Address;
import cz.skalicky.android.MShopService.publicapi.Country;
import cz.skalicky.android.MShopService.publicapi.Occupier;

@Entity
@Table(name = "ADDRESSES")
public class AddressImpl implements Address {

	private static final long serialVersionUID = -5299353547444702300L;

	private int id = -1;
	private String street = null;
	private int streetNumber = -1;
	private Country country = null;
	private int postCode = -1;
	private Occupier occupier = null;

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
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Basic(optional = false)
	@Override
	public int getStreetNumber() {
		return this.streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	@ManyToOne(targetEntity = CountryImpl.class)
	@Override
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Basic(optional = false)
	@Override
	public int getPostCode() {
		return this.postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	@ManyToOne
	@JoinColumn(name = "ADDRESS_OCCUPIER_FK", insertable = false, updatable = false)
	@Override
	public Occupier getOccupier() {
		return this.occupier;
	}

	public void setOccupier(Occupier occupier) {
		this.occupier = occupier;
	}
}
