package com.sand_head.virtualadmin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class VirtualAdmin extends JavaPlugin {

	private static String vaName;
	public static String prefix = ChatColor.DARK_RED + "[VA]" + ChatColor.RESET + "<" + getVaName() + "> ";

	public void onEnable() {
		PluginDescriptionFile pdf = getDescription();
		Logger logger = getLogger();
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ChatListener(), this);
		pm.registerEvents(new JoinListener(), this);
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		setVaName(getConfig().getString("VA Name"));

		logger.info(pdf.getName() + " (" + pdf.getVersion() + ")" + " has been enabled");
	}

	public void onDisable() {
		PluginDescriptionFile pdf = getDescription();
		Logger logger = getLogger();

		logger.info("Saving 'VA Name' as " + vaName);
		getConfig().set("VA Name", vaName);
		saveConfig();

		logger.info(pdf.getName() + " has been disabled");
	}
	
	public static String getVaName() {
		return vaName;
	}
	
	public static String getVaPrefix() {
		return prefix;
	}
	
	public static void setVaName(String newName) {
		vaName = newName;
		prefix = ChatColor.DARK_RED + "[VA]" + ChatColor.RESET + "<" + getVaName() + "> ";
	}
	
	public static ItemStack setName(ItemStack is, String name){
        ItemMeta m = is.getItemMeta();
        m.setDisplayName(name);
        is.setItemMeta(m);
        return is;
    }

	public static void sendMessage(String messages) {
		String[] s = { prefix + messages };
		sendMessage(s);
	}
	public static void sendMessage(String[] messages) {
		Bukkit.getScheduler().runTask(VirtualAdmin.getPlugin(VirtualAdmin.class),
				new ResponseHandler(null, messages, "normal"));
	}
}