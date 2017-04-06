package com.sand_head.virtualadmin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ResponseHandler implements Runnable {
	private Player topic;
	private String[] response;
	private String type;
	
	public ResponseHandler(Player player, String[] s, String type1) {
		topic = player;
		response = s;
		type = type1;
	}

	@Override
	public void run() {
		if (type.equalsIgnoreCase("join")) {
			Bukkit.broadcastMessage(VirtualAdmin.getVaPrefix() + "Welcome to " + topic.getServer().getMotd() + ", " + topic.getName() + "!");
			Bukkit.broadcastMessage(VirtualAdmin.getVaPrefix() + "If you need anything, feel free to ask me! Just mention my name in chat.");
		} else if (type.equalsIgnoreCase("normal")) {
			for (String s : response) {
				Bukkit.broadcastMessage(s);
			}
		}
	}
}
