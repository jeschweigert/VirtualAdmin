package com.sand_head.virtualadmin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		Bukkit.getScheduler().scheduleSyncDelayedTask(VirtualAdmin.getPlugin(VirtualAdmin.class),
				new ResponseHandler(player, null, "join"));
	}
	
}
