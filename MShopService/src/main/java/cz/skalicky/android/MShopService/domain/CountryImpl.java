package cz.skalicky.android.MShopService.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cz.skalicky.android.MShopService.publicapi.Country;

@Entity
@Table(name = "COUNTRIES")
public class CountryImpl implements Country {

	private static final long serialVersionUID = 2817115031944850068L;

	private int id = -1;
	private String name = null;
	private int valueAddedTax = -1;

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
	@Column(unique = true)
	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Override
	public int getValueAddedTax() {
		return this.valueAddedTax;
	}

	public void setValueAddedTax(int valueAddedTax) {
		this.valueAddedTax = valueAddedTax;
	}
}
