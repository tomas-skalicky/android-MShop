package cz.skalicky.android.MShopService.domain;

import java.net.URL;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cz.skalicky.android.MShopService.publicapi.Address;
import cz.skalicky.android.MShopService.publicapi.PhoneNumber;
import cz.skalicky.android.MShopService.publicapi.Product;
import cz.skalicky.android.MShopService.publicapi.Shop;

@Entity
@Table(name = "SHOPS")
public class ShopImpl implements Shop {

	private static final long serialVersionUID = -9163656938293549663L;

	private int id = -1;
	private String name = null;
	private String description = null;
	private Address headquarterAddress = null;
	private PhoneNumber phoneNumber = null;
	private String email = null;
	private URL homepage = null;
	private List<Product> products = null;

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
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Override
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne(mappedBy = "occupier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(nullable = false)
	@Override
	public Address getHeadquarterAddress() {
		return this.headquarterAddress;
	}

	public void setHeadquarterAddress(Address headquarterAddress) {
		this.headquarterAddress = headquarterAddress;
	}

	@Embedded
	@Column(nullable = false)
	@Override
	public PhoneNumber getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Basic(optional = false)
	@Override
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic(optional = false)
	@Override
	public URL getHomepage() {
		return this.homepage;
	}

	public void setHomepage(URL homepage) {
		this.homepage = homepage;
	}

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Override
	public List<Product> getProducts() {
		return this.products;
	}

	@Transient
	@Override
	public Address getAddress() {
		return this.getHeadquarterAddress();
	}
}
