package fr.club.utils.subscriptions;

import java.time.LocalDate;

public class CustomSubscription extends Subscription{

	private static final long serialVersionUID = 7260029456052266676L;

	public CustomSubscription(LocalDate debut, int amountOfDay) {
		super(debut, amountOfDay);
	}

	public CustomSubscription(LocalDate debut, LocalDate fin) {
		super(debut, fin);
	}

	public CustomSubscription(LocalDate debut, TypeSubscription type) {
		super(debut, type);
	}

	@Override
	public TypeSubscription getType() {
		return TypeSubscription.CUSTOM;
	}
	
}
