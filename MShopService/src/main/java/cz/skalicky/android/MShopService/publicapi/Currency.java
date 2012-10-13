package cz.skalicky.android.MShopService.publicapi;

public enum Currency {

	CZK(null, false) {
		@Override
		public <T> T accept(CurrencyVisitor<T> visitor) {
			return visitor.visitCzk();
		}

	},
	EUR("€", true) {
		@Override
		public <T> T accept(CurrencyVisitor<T> visitor) {
			return visitor.visitEur();
		}

	};

	private final String abbreviation;
	private final boolean isCurrencyBeforeAmount;

	/**
	 * Constructor
	 */
	private Currency(final String abbreviation,
			final boolean isCurrencyBeforeAmount) {
		this.abbreviation = abbreviation;
		this.isCurrencyBeforeAmount = isCurrencyBeforeAmount;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public boolean isCurrencyBeforeAmount() {
		return this.isCurrencyBeforeAmount;
	}

	/**
	 * Formats the given {@link Price} according to the position of the currency
	 * sign.
	 */
	public static String formatPrice(Price price) {
		final Currency currency = price.getCurrency();
		if (currency.isCurrencyBeforeAmount()) {
			return new StringBuffer(currency.getAbbreviation()).append(" ")
					.append(price.getAmount()).toString();
		} else {
			return new StringBuffer(price.getAmount()).append(" ")
					.append(currency.getAbbreviation()).toString();
		}
	}

	public abstract <T> T accept(CurrencyVisitor<T> visitor);

	public interface CurrencyVisitor<T> {
		T visitCzk();

		T visitEur();
	}
}
