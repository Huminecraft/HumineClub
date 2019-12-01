package fr.club.utils.subscriptions;

import java.time.LocalDate;

public class MensualSubscription extends Subscription{

	private static final long serialVersionUID = -3689583499707895748L;

	public MensualSubscription(LocalDate debut) {
		super(debut, TypeSubscription.calculateEndDate(debut, TypeSubscription.MENSUAL));
	}

	@Override
	public TypeSubscription getType() {
		return TypeSubscription.MENSUAL;
	}

}
