package com.sand_head.virtualadmin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerHandler extends BukkitRunnable {

	private Player target;
	private String type;

	public PlayerHandler(Player player, String s) {
		target = player;
		type = s;
	}
	
	public static Player getPlayer(String s) {
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			if (p.getName() == s || p.getDisplayName() == s || p.getCustomName() == s || p.getPlayerListName() == s) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void run() {
		if (type.equalsIgnoreCase("kill")) {
			target.setHealth(0);
		} else if (type.equalsIgnoreCase("kick")) {
			target.kickPlayer("You have been kicked by " + VirtualAdmin.getVaName() + ".");
		} else if (type.equalsIgnoreCase("bkick")) {
			target.kickPlayer("Gold is not 'butter.'");
		} else if (type.equalsIgnoreCase("help")) {
			target.sendMessage(ChatColor.BOLD + "Time/Date Related:");
			target.sendMessage(ChatColor.YELLOW + "\"" + getVaName() + ", what's the time?\"");
			target.sendMessage(ChatColor.YELLOW + "\"" + getVaName() + ", what time is it in PST?\"");
			target.sendMessage(ChatColor.RED + "[ADMIN] \"" + getVaName() + ", set the time to day.\"");

			target.sendMessage(ChatColor.BOLD + "Item Related:");
			target.sendMessage(ChatColor.YELLOW + "\"" + getVaName() + ", trade my iron sword with Steve.\"");
			target.sendMessage(ChatColor.YELLOW + "\"" + getVaName() + ", what block is that?\"");
			target.sendMessage(ChatColor.RED + "[ADMIN] \"" + getVaName() + ", send me some stones and a diamond pickaxe.\"");
			
			target.sendMessage(ChatColor.BOLD + "Miscellaneous:");
			target.sendMessage(ChatColor.YELLOW + "\"Konnichiwa, " + getVaName() + ".\"");
			target.sendMessage(ChatColor.YELLOW + "\"Merry Christmas, " + getVaName() + "!\"");
			target.sendMessage(ChatColor.RED + "[ADMIN] \"" + getVaName() + ", stop the rain.\"");
		}
	}

	private String getVaName() {
		return VirtualAdmin.getVaName();
	}

}
