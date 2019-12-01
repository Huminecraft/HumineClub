package fr.club.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.club.utils.subscriptions.Subscription;

public class SubscriberManager {

	private Map<UUID, Subscriber> list;
	
	public SubscriberManager(Map<UUID, Subscriber> list) {
		this.list = list;
	}
	
	public SubscriberManager() {
		this(new HashMap<UUID, Subscriber>());
	}
	
	public void addSubscriber(Subscriber sub) {
		this.list.put(sub.getPlayerUUID(), sub);
	}
	
	public Subscriber createSubscriber(Player player, Subscription sc) {
		Subscriber sub = new Subscriber(player, sc);
		return this.list.put(player.getUniqueId(), sub);
	}
	
	public boolean containsSubscriber(Player player) {
		return containsSubscriber(player.getUniqueId());
	}
	
	public boolean containsSubscriber(UUID id) {
		return this.list.containsKey(id);
	}
	
	public Subscriber getSubscriber(Player player) {
		return getSubscriber(player.getUniqueId());
	}
	
	public Subscriber getSubscriber(UUID id) {
		return this.list.get(id);
	}
	
	public Subscriber removeSubscriber(UUID id) {
		return this.list.remove(id);
	}
	
	public Subscriber removeSubscriber(Player player) {
		return removeSubscriber(player.getUniqueId());
	}
	
	public int size() {
		return this.list.size();
	}
	
	public Collection<Subscriber> getSubscribers() {
		return this.list.values();
	}
}
