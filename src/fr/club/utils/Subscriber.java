package fr.club.utils;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.club.main.MainClub;
import fr.club.utils.subscriptions.Subscription;

public class Subscriber implements Serializable{

	private static final long serialVersionUID = -1670829709590261325L;

	private UUID player;
	private Subscription subscription;
	private Prestige prestige;
	
	private int amountOfDay;
	
	public Subscriber(Player player, Subscription sub) {
		this.player = player.getUniqueId();
		this.subscription = sub;
		this.prestige = new Prestige();
		this.amountOfDay = 1;
	}
	
	public Player getPlayer() {
		return MainClub.getInstance().getServer().getPlayer(this.player);
	}
	
	public UUID getPlayerUUID() {
		return this.player;
	}
	
	public Subscription getSubscription() {
		return subscription;
	}
	
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	public Prestige getPrestige() {
		return prestige;
	}
	
	public void setPrestige(Prestige prestige) {
		this.prestige = prestige;
	}
	
	public int getAmountOfDay() {
		return amountOfDay;
	}
	
	public void setAmountOfDay(int amountOfDay) {
		this.amountOfDay = amountOfDay;
	}
	
	public void addDay() {
		this.amountOfDay++;
	}
	
	public boolean hasValidSubscription() {
		return this.subscription != null && this.subscription.isValid();
	}
}
