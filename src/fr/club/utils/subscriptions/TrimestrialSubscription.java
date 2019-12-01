package fr.club.utils.subscriptions;

import java.time.LocalDate;

public class TrimestrialSubscription extends Subscription{

	private static final long serialVersionUID = 3748174308373182725L;

	public TrimestrialSubscription(LocalDate debut) {
		super(debut, TypeSubscription.calculateEndDate(debut, TypeSubscription.TRIMESTRIAL));
	}

	@Override
	public TypeSubscription getType() {
		return TypeSubscription.TRIMESTRIAL;
	}
}
