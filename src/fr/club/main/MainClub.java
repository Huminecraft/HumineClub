package fr.club.main;


import java.time.LocalDate;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.club.utils.SubscriberManager;
import fr.club.utils.customevents.ChangeDayEvent;

public class MainClub extends JavaPlugin{

	private static MainClub instance;
	private static LocalDate currentDate;
	
	private static SubscriberManager subscriberManager;
	
	@Override
	public void onEnable() {
		instance = this;
		currentDate = LocalDate.now();
		subscriberManager = new SubscriberManager();
		
		events();
		
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				if(LocalDate.now().isAfter(currentDate)) {
					getServer().getPluginManager().callEvent(new ChangeDayEvent(currentDate, LocalDate.now()));
					currentDate = LocalDate.now();
				}
			}
		}, (20 * 60), 0);
	}
	
	public void events() {
	}
	
	public static MainClub getInstance() {
		return instance;
	}
	
	public static SubscriberManager getSubscriberManager() {
		return subscriberManager;
	}
	
	public static LocalDate getCurrentDate() {
		return currentDate;
	}
	
	public static void sendMessage(CommandSender sender, String message) {
		sender.sendMessage(ChatColor.AQUA + "[Club] " + ChatColor.WHITE + message);
	}
}
