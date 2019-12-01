package fr.club.utils.customevents;

import java.time.LocalDate;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ChangeDayEvent extends Event implements Cancellable
{

	private static HandlerList handler = new HandlerList();
	private boolean cancel;
	
	private LocalDate oldDate;
	private LocalDate newDate;
	
	public ChangeDayEvent(LocalDate oldDate, LocalDate newDate)
	{
		this.oldDate = oldDate;
		this.newDate = newDate;
	}
	
	public LocalDate getOldDate() {
		return oldDate;
	}
	
	public LocalDate getNewDate() {
		return newDate;
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
