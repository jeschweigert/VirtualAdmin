package com.sand_head.virtualadmin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import net.md_5.bungee.api.ChatColor;

public class ChatListener implements Listener {

	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Random ra = new Random();
		Player player = e.getPlayer();
		String ogmsg = e.getMessage();
		String ogmsgnc = e.getMessage().replaceAll(",", "").replaceAll("\\?", "");
		String msg = ogmsg.toLowerCase().replaceAll("teh", "the");
		String[] array = msg.replaceAll(",", "").split(" ");
		String[] arrwhy = ogmsgnc.split(" ");
		String vaName = VirtualAdmin.getVaName();
		// String rpmsg = ogmsg.replaceAll("(?i)virad", ChatColor.DARK_RED +
		// "[VA]" + ChatColor.RESET);

		if (msg.contains(vaName.toLowerCase())) {
			if ((msg.contains("what") && msg.contains("do")) || msg.contains("help")) {
				sendMessage("Let me show you a list of what I can do.");
				Bukkit.getScheduler().scheduleSyncDelayedTask(VirtualAdmin.getPlugin(VirtualAdmin.class),
						new PlayerHandler(player, "help"));
			} else if (msg.contains("call you")) {
				if (player.isOp() || player.hasPermission("va.renameva")) {
					ItemHandler ih = new ItemHandler();
					VirtualAdmin.setVaName(arrwhy[ih.getItemIndex(ogmsgnc, "call") + 2]);
					sendMessage(ChatColor.GREEN + "[From now on, you can call me " + VirtualAdmin.getVaName() + ".]");
				} else {
					sendMessage("You cannot tame me, " + player.getName() + "!");
				}
			} else if (msg.contains("stop the rain") || msg.contains("make it sunny")
					|| msg.contains("rain, rain, go away")) {
				if (player.isOp() || player.hasPermission("va.stopRain")) {
					if (msg.contains("rain, rain, go away")) {
						sendMessage("Come again another day.");
					} else {
						sendMessage("Sure, I can stop the rain for you.");
					}
					player.getWorld().setStorm(false);
					player.getWorld().setThundering(false);
				} else {
					sendMessage("Sorry, " + player.getName() + ", I can't, but the sun will come out soon.");
				}
			} else if (msg.contains("stop the server")) {
				if (player.isOp() || player.hasPermission("va.stop")) {
					sendMessage(ChatColor.RED + "[The server is shutting down...]");
					e.setCancelled(true);
					Bukkit.getServer().shutdown();
				} else {
					sendMessage("I'm sorry, " + player.getName() + ", but I'm afraid I can't let you do that.");
				}
			} else if (msg.contains("reload the server")) {
				if (player.isOp() || player.hasPermission("va.reload")) {
					sendMessage(ChatColor.GREEN + "[The server was reloaded.]");
					e.setCancelled(true);
					Bukkit.getServer().reload();
				} else {
					sendMessage("Sorry, " + player.getName() + ", but access is denied.");
				}
			} else if (msg.contains("heal")) {
				if (player.isOp() || player.hasPermission("va.heal")) {
					int index = -1;

					// modify the args
					for (int i = 0; i < array.length; i++) {
						if (array[i].equals("heal")) {
							index = i;
							break;
						}
					}
					String who = array[index + 1];
					if (who.equalsIgnoreCase("me") || who.equalsIgnoreCase(player.getName())) {
						sendMessage("Okay, " + player.getName() + ", consider yourself healed.");
						player.setHealth(player.getMaxHealth());
					} else if (who.equalsIgnoreCase("yourself")) {
						sendMessage("Thanks for the thought, but that won't be necessary.");
					} else {
						Player feed = PlayerHandler.getPlayer(who);
						if (feed != null) {
							sendMessage("Okay, " + player.getName() + ", I'll heal " + feed.getName() + " for you.");
							feed.setHealth(feed.getMaxHealth());

						} else {
							sendMessage("'" + who + "' doesn't seem to be online right now.");
						}
					}
				} else {
					sendMessage("I can't let just anyone get healed, " + player.getName() + ".");
				}
			} else if (msg.contains("feed")) {
				if (player.isOp() || player.hasPermission("va.feed")) {
					int index = -1;

					// modify the args
					for (int i = 0; i < array.length; i++) {
						if (array[i].equals("feed")) {
							index = i;
							break;
						}
					}
					String who = array[index + 1];
					if (who.equalsIgnoreCase("me") || who.equalsIgnoreCase(player.getName())) {
						sendMessage("Okay, " + player.getName() + ", consider yourself fed.");
						player.setFoodLevel(20);
					} else if (who.equalsIgnoreCase("yourself")) {
						sendMessage("I... do? Often?");
					} else {
						Player feed = PlayerHandler.getPlayer(who);
						if (feed != null) {
							sendMessage("Okay, " + player.getName() + ", I'll feed " + feed.getName() + " for you.");
							feed.setFoodLevel(20);

						} else {
							sendMessage("'" + who + "' doesn't seem to be online right now.");
						}
					}
				} else {
					sendMessage("You don't have permission to tell me who to feed, " + player.getName() + ".");
				}
			} else if (msg.contains("starve")) {
				if (player.isOp() || player.hasPermission("va.starve")) {
					int index = -1;

					// modify the args
					for (int i = 0; i < array.length; i++) {
						if (array[i].equals("starve")) {
							index = i;
							break;
						}
					}
					String who = array[index + 1];
					if (who.equalsIgnoreCase("me") || who.equalsIgnoreCase(player.getName())) {
						sendMessage("Okay, " + player.getName() + ", you're now very hungry.");
						player.setFoodLevel(0);
					} else if (who.equalsIgnoreCase("yourself")) {
						sendMessage("I would really rather not.");
					} else {
						Player feed = PlayerHandler.getPlayer(who);
						if (feed != null) {
							sendMessage("Okay, " + player.getName() + ", I'll starve " + feed.getName() + " for you.");
							feed.setFoodLevel(0);

						} else {
							sendMessage("'" + who + "' doesn't seem to be online right now.");
						}
					}
				} else {
					sendMessage("I can't allow you to starve anyone right now, " + player.getName() + "?");
				}
			} else if (msg.contains("kill")) {
				int index = -1;

				// modify the args
				for (int i = 0; i < array.length; i++) {
					if (array[i].equals("kill")) {
						index = i;
						break;
					}
				}
				String who = array[index + 1];
				if (who.equalsIgnoreCase("me") || who.equalsIgnoreCase(player.getName())) {
					sendMessage("Okay, " + player.getName() + ", the deed is done.");
					Bukkit.getScheduler().scheduleSyncDelayedTask(VirtualAdmin.getPlugin(VirtualAdmin.class),
							new PlayerHandler(player, "kill"));
				} else if (who.equalsIgnoreCase("yourself")) {
					sendMessage("That's rude.");
				} else {
					Player kill = PlayerHandler.getPlayer(who);
					if (kill != null) {
						if (player.isOp() || player.hasPermission("va.killOthers")) {
							sendMessage("Okay, " + player.getName() + ", I'll kill " + kill.getName() + " for you.");
							Bukkit.getScheduler().scheduleSyncDelayedTask(VirtualAdmin.getPlugin(VirtualAdmin.class),
									new PlayerHandler(kill, "kill"));
						} else {
							sendMessage("I won't just kill " + ChatColor.ITALIC + "anybody" + ChatColor.RESET + " for "
									+ ChatColor.ITALIC + "anyone" + ChatColor.RESET + ", " + player.getName() + ".");
						}
					} else {
						sendMessage("'" + who + "' doesn't seem to be online right now.");
					}
				}
			} else if (msg.contains("kick")) {
				int index = -1;

				// modify the args
				for (int i = 0; i < array.length; i++) {
					if (array[i].equals("kick")) {
						index = i;
						break;
					}
				}
				String who = array[index + 1];
				if (who.equalsIgnoreCase("me") || who.equalsIgnoreCase(player.getName())) {
					sendMessage("Okay, " + player.getName() + ", the deed is done.");
					Bukkit.getScheduler().scheduleSyncDelayedTask(VirtualAdmin.getPlugin(VirtualAdmin.class),
							new PlayerHandler(player, "kick"));
				} else if (who.equalsIgnoreCase("yourself")) {
					sendMessage("I'm not even a player!");
				} else {
					if (player.isOp() || player.hasPermission("va.kick")) {
						Player kick = PlayerHandler.getPlayer(who);
						if (kick != null) {
							sendMessage("Okay, " + player.getName() + ", I'll kick " + kick.getName() + " for you.");
							Bukkit.getScheduler().scheduleSyncDelayedTask(VirtualAdmin.getPlugin(VirtualAdmin.class),
									new PlayerHandler(kick, "kick"));

						} else {
							sendMessage("'" + who + "' doesn't seem to be online right now.");
						}
					} else {
						sendMessage("I can't kick for just " + ChatColor.ITALIC + "anybody" + ChatColor.RESET
								+ ", you know.");
					}
				}
			} else if (msg.contains("time")) {
				if (msg.contains("what")) {
					if (msg.contains("in")) {
						Date currentDate = new Date();
						DateFormat dateFormat = new SimpleDateFormat("HH:mm a");
						if (msg.contains("cst")) {
							dateFormat.setTimeZone(TimeZone.getTimeZone("CST"));
							sendMessage("The time in CST is " + dateFormat.format(currentDate) + ".");
						} else if (msg.contains("est")) {
							dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
							sendMessage("The time in EST is " + dateFormat.format(currentDate) + ".");
						} else if (msg.contains("pst")) {
							dateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
							sendMessage("The time in PST is " + dateFormat.format(currentDate) + ".");
						} else if (msg.contains("mst")) {
							dateFormat.setTimeZone(TimeZone.getTimeZone("MST"));
							sendMessage("The time in MST is " + dateFormat.format(currentDate) + ".");
						}
					} else {
						long gameTime = player.getWorld().getTime(), hours = gameTime / 1000 + 6,
								minutes = (gameTime % 1000) * 60 / 1000;
						String ampm = "AM";
						if (hours >= 12) {
							hours -= 12;
							ampm = "PM";
						}
						if (hours >= 12) {
							hours -= 12;
							ampm = "AM";
						}
						if (hours == 0)
							hours = 12;
						String mm = "0" + minutes;
						mm = mm.substring(mm.length() - 2, mm.length());
						sendMessage("The time is currently " + hours + ":" + mm + " " + ampm + ".");
					}
				} else if (msg.contains("day")) {
					player.getWorld().setTime(1000);
					sendMessage("The time has been set to day.");
				}
			} else if (msg.contains("clear my inventory")) {
				sendMessage("Okay, " + player.getName() + ", I've cleared out your inventory.");
				PlayerInventory inv = player.getInventory();
				inv.clear();
				inv.setArmorContents(new ItemStack[4]);
			} else if (msg.contains("give") || msg.contains("send")) {
				if (player.isOp() || player.hasPermission("va.give")) {
					give(msg, player);
				} else {
					if (msg.contains("please")) {
						int chance = ra.nextInt(64);
						if (chance == 32) {
							sendMessage("Well, I guess just once wouldn't hurt...");
							give(msg, player);
						} else {
							sendMessage("No. I won't give you anything, not even if you say please.");
						}
					} else {
						sendMessage(player.getName() + ", I'm afraid I can't give out items for you.");
					}
				}
			} else if (msg.contains("konichiwa") || msg.contains("konnichiwa")) {
				sendMessage("こんにちは、 " + player.getName() + "さん。");
			} else if (msg.contains("sayounara") || msg.contains("sayonara")) {
				sendMessage("後でお会いしましょう、 " + player.getName() + "さん。");
			} else if (msg.contains("hello") || msg.contains("hey") || msg.contains("hi")) {
				sendMessage("Hello, " + player.getName() + "!");
			} else if (msg.contains("bye")) {
				sendMessage("Until next time, " + player.getName() + ".");
			} else if (msg.contains("hola")) {
				sendMessage("¡Hola, " + player.getName() + "!");
			} else if (msg.contains("adios")) {
				sendMessage("¡Hasta luego, " + player.getName() + "!");
			} else if (msg.contains("good night")) {
				sendMessage("Good night, " + player.getName() + ".");
			} else if (msg.contains("good morning")) {
				sendMessage("Good morning, " + player.getName() + ".");
			} else if (msg.contains("good afternoon")) {
				sendMessage("Good afternoon to you, too, " + player.getName() + ".");
			} else if (msg.contains("merry christmas")) {
				Date d = new Date();
				String date = new SimpleDateFormat("MM-dd").format(d);
				if (date.equalsIgnoreCase("12-25")) {
					sendMessage("Merry Christmas, " + player.getName() + "!");
				} else if (date.equalsIgnoreCase("12-24")) {
					sendMessage("Merry Christmas Eve, " + player.getName() + "!");
				} else {
					sendMessage("It isn't Christmas yet, " + player.getName() + ".");
				}
			} else if (msg.contains("happy new year")) {
				Date d = new Date();
				String date = new SimpleDateFormat("MM-dd").format(d);
				String year = new SimpleDateFormat("yyyy").format(d);
				if (date.equalsIgnoreCase("12-31") || date.equalsIgnoreCase("01-01")) {
					sendMessage("Happy New Year, " + year + ", " + player.getName() + "!");
				} else {
					sendMessage("The year isn't quite as new anymore, " + player.getName() + ".");
				}
			} else {
				sendMessage("Is there anything you wanted, " + player.getName() + "?");
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void give(String ogmsg, Player player) {
		String msg = ogmsg.toLowerCase().replaceAll("teh", "the");
		String[] array = msg.replaceAll(",", "").split(" ");
		Random ra = new Random();
		ItemHandler ih = new ItemHandler();
		Player give;
		String reciever;
		int i = 0;
		String lbl = "";
		if (msg.contains("give")) {
			i = ih.getItemIndex(msg, "give");
			lbl = "give";
		} else if (msg.contains("send")) {
			i = ih.getItemIndex(msg, "send");
			lbl = "send";
		}
		if (array[i + 1].equalsIgnoreCase("me") || array[i + 1].equalsIgnoreCase(player.getName())) {
			give = player;
			reciever = "you";
		} else {
			give = PlayerHandler.getPlayer(array[i + 1]);
			reciever = give.getName();
		}
		String[] smsg = msg.split(lbl)[1].replaceFirst(array[i + 1], "").split(" and ");
		List<String> items = new ArrayList<String>();
		int missedItems = 0;
		for (String s : smsg) {
			// sendMessage(s);
			int num = 0;
			String[] arr = s.trim().split(" ");
			// figure out the number of items
			if (arr[0].equalsIgnoreCase("some")) {
				Random r = new Random();
				num = r.nextInt(32);
			} else if (arr[0].equalsIgnoreCase("a") || arr[0].equalsIgnoreCase("an")
					|| arr[0].equalsIgnoreCase("one")) {
				if (1 < arr.length) {
					if (arr[1].equalsIgnoreCase("stack")) {
						num = 64;
					} else {
						num = 1;
					}
				} else {
					num = 1;
				}
			} else {
				try {
					int num2 = Integer.parseInt(arr[0]);
					if (1 < arr.length) {
						if (arr[1].equalsIgnoreCase("stack") || arr[1].equalsIgnoreCase("stacks")) {
							num = 64 * num2;
						} else {
							num = num2;
						}
					} else {
						num = num2;
					}
				} catch (NumberFormatException n) {
					num = ra.nextInt(32);
				}
			}
			// sendMessage("Item Count: " + num);

			// Remove any plural endings
			for (int index = 0; index < arr.length; index++) {
				if (arr[index].endsWith("s") && index != i + 1 && !arr[index].equalsIgnoreCase("bars")
						&& !arr[index].equalsIgnoreCase("leggings") && !arr[index].equalsIgnoreCase("boots")
						&& !arr[index].equalsIgnoreCase("planks") && !arr[index].equalsIgnoreCase("stairs")
						&& !arr[index].equalsIgnoreCase("grass") && !arr[index].equalsIgnoreCase("this")) {
					if (arr[index].endsWith("es") && !arr[index].equalsIgnoreCase("panes")
							&& !arr[index].equalsIgnoreCase("fences") && !arr[index].equalsIgnoreCase("gates")
							&& !arr[index].equalsIgnoreCase("stones") && !arr[index].equalsIgnoreCase("cookies")) {
						if (arr[index].endsWith("lves")) {
							arr[index] = arr[index].substring(0, arr[index].length() - 4);
							arr[index] = arr[index] + "lf";
						} else {
							if (!arr[index].equalsIgnoreCase("leaves")) {
								arr[index] = arr[index].substring(0, arr[index].length() - 2);
							}
						}
					} else {
						if (!arr[index].equalsIgnoreCase("glass")) {
							arr[index] = arr[index].substring(0, arr[index].length() - 1);
						}
					}
				}
			}
			String recombine = StringUtils.join(arr, " ");

			Material mat = null;
			DyeColor color = null;
			byte onlyWhenDesperate = 0;
			if (arr[arr.length - 1].equalsIgnoreCase("this") || arr[arr.length - 1].equalsIgnoreCase("that")
					|| arr[arr.length - 1].equalsIgnoreCase("these") || arr[arr.length - 1].equalsIgnoreCase("those")) {
				Block block = player.getTargetBlock((Set<Material>) null, 200);
				mat = block.getType();
				color = DyeColor.getByData(block.getData());
				Material mat2 = ih.changeBlockToItem(mat);
				if (mat != mat2) {
					color = null;
					mat = mat2;
				}
			} else if (arr[arr.length - 1].equalsIgnoreCase("butter")
					|| arr[arr.length - 1].equalsIgnoreCase("budder")) {
				String b = "budder";
				if (arr[arr.length - 1].equalsIgnoreCase("butter")) {
					b = "butter";
				}
				sendMessage("I don't recognize '" + b + "' as an item, and neither should you.");
				Bukkit.getScheduler().scheduleSyncDelayedTask(VirtualAdmin.getPlugin(VirtualAdmin.class),
						new PlayerHandler(give, "bkick"));
				return;
			} else {
				color = ih.getMinecraftItemColor(recombine);
				mat = ih.getMinecraftItem(recombine);
				if (mat == Material.MONSTER_EGG) {
					onlyWhenDesperate = ih.getSpawnEggValuesBecauseDyeColorsAreDumb(recombine);
				}
			}
			if (mat == null) {
				missedItems++;
			} else {
				String matn = mat.name().toLowerCase().replace("_", " ");
				if (matn.endsWith(" on")) {
					matn = matn.substring(0, matn.length() - 3);
				} else if (matn.endsWith(" off")) {
					matn = matn.substring(0, matn.length() - 4);
				} else if (matn.endsWith(" 2")) {
					matn = matn.substring(0, matn.length() - 2);
				}
				String plurals = "";
				if (num > 1 && !matn.endsWith("s") && !matn.endsWith("wood") && !matn.endsWith("sand")) {
					if (matn.endsWith("torch")) {
						plurals = "es";
					} else if (matn.endsWith("lf")) {
						matn = matn.substring(0, matn.length() - 1);
						plurals = "ves";
					} else {
						plurals = "s";
					}
				}

				if (matn.equalsIgnoreCase("air")) {
					sendMessage("Sorry, but I can't give out air, there'd be nothing to give.");
					return;
				}
				// sendMessage("Item: " + matn + plurals);
				ItemStack is = new ItemStack(mat, num);
				if (color != null) {
					is = new ItemStack(mat, num, color.getData());
				} else if (onlyWhenDesperate != 0) {
					is = new ItemStack(mat, num, onlyWhenDesperate);
				}
				if (matn.equalsIgnoreCase("diamond spade")) {
					Random r = new Random();
					if (r.nextInt(4) == 3) {
						// FOR GREAT SHOVELRY
						is = VirtualAdmin.setName(new ItemStack(mat, num), "Shovel Justice");
					}
				}
				give.getInventory().addItem(is);
				items.add(num + " " + matn + plurals);
			}
		}
		String item = StringUtils.join(items, " and ");
		// sendMessage("missed: " + missedItems + ", total: " +
		// items.size());
		if (items.size() == 0) {
			if (missedItems == 1) {
				sendMessage("Whoops, I couldn't find the item you wanted.");
				return;
			} else {
				sendMessage("Whoops, I couldn't find any of the items you asked for.");
				return;
			}
		} else if (missedItems != 0) {
			String mult = "";
			if (missedItems != 1) {
				mult = "s";
			}
			sendMessage("I couldn't find " + missedItems + " item" + mult + ", but I did give " + reciever + " " + item
					+ ".");
			return;
		} else {
			sendMessage("Okay, I sent " + reciever + " " + item + ".");
		}
	}

	public void sendMessage(String messages) {
		VirtualAdmin.sendMessage(messages);
	}
}
