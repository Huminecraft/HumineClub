package fr.club.utils.subscriptions;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Subscription implements Serializable{

	private static final long serialVersionUID = -4598183465014076543L;
	
	protected LocalDate debut;
	protected LocalDate fin;
	
	public Subscription(LocalDate debut, LocalDate fin) {
		this.debut = debut;
		this.fin = fin;
	}
	
	public Subscription(LocalDate debut, TypeSubscription type) {
		this(debut, TypeSubscription.calculateEndDate(debut, type));
	}
	
	public Subscription(LocalDate debut, int amountOfDay) {
		this(debut, TypeSubscription.calculateEndDate(debut, amountOfDay));
	}
	
	public LocalDate getStart() {
		return debut;
	}
	
	public LocalDate getEnd() {
		return fin;
	}
	
	public boolean isValid() {
		return LocalDate.now().isBefore(this.fin) || LocalDate.now().isEqual(this.fin);
	}
	
	public int getRemainingDays() {
		if(!isValid()) return 0;
		return LocalDate.now().until(this.fin).getDays() + 1;
	}
	
	public int getAmountOfDays() {
		return this.debut.until(this.fin).getDays() + 1;
	}
	
	public boolean almostFinished(int dayRange) {
		if(!isValid()) return false;
		return this.fin.minusDays(dayRange).isBefore(LocalDate.now()) || this.fin.minusDays(dayRange).isEqual(LocalDate.now());
	}

	public void addDays(int amount) {
		this.fin = this.fin.plusDays(amount);
	}
	
	public void addDays(TypeSubscription type) {
		this.fin = this.fin.plusDays(type.getAmountOfDay());
	}
	
	public void removeDays(int amount) {
		this.fin = this.fin.minusDays(amount);
	}
	
	public abstract TypeSubscription getType();
	
	@Override
	public String toString() {
		return "Abonnement [debut=" + debut + ", fin=" + fin + ", valide=" + isValid() + ", jour(s) restant(s)=" + getRemainingDays() + "]";
	}
	
}
