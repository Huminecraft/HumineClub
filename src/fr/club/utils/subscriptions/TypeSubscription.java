package fr.club.utils.subscriptions;

import java.time.LocalDate;

public enum TypeSubscription {

	MENSUAL (30),
	TRIMESTRIAL (90),
	ANNUAL (365),
	DAILY (1),
	CUSTOM (0);
	
	private int amountOfDay;
	
	private TypeSubscription(int amountOfDay) {
		this.amountOfDay = amountOfDay;
	}
	
	public int getAmountOfDay() {
		return amountOfDay;
	}
	
	public static LocalDate calculateEndDate(LocalDate debut, TypeSubscription type) {
		return debut.plusDays(type.getAmountOfDay());
	}
	
	public static LocalDate calculateEndDate(LocalDate debut, int amountOfDay) {
		return debut.plusDays(amountOfDay);
	}
}
