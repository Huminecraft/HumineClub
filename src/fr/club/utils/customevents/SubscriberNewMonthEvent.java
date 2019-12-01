package fr.club.utils.customevents;

import java.time.LocalDate;
import java.time.Month;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import fr.club.utils.Subscriber;

public class SubscriberNewMonthEvent extends Event implements Cancellable{

	private static HandlerList handler = new HandlerList();
	private boolean cancel;
	
	private LocalDate newDate;
	private Subscriber subscriber;
	
	public SubscriberNewMonthEvent(Subscriber subscriber, LocalDate newDate)
	{
		this.newDate = newDate;
		this.subscriber = subscriber;
	}
	
	public LocalDate getNewDate() {
		return newDate;
	}
	
	public Subscriber getSubscriber() {
		return subscriber;
	}
	
	public Month getNewMonth() {
		return newDate.getMonth();
	}
	
	@Override
	public HandlerList getHandlers() {
		return handler;
	}
	
	public static HandlerList getHandlerList() {
		return handler;
	}

	@Override
	public boolean isCancelled()
	{
		return cancel;
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		this.cancel = cancel;
	}
}
