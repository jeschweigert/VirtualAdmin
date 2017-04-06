package com.sand_head.virtualadmin;

import org.bukkit.DyeColor;
import org.bukkit.Material;

public class ItemHandler {

	public ItemHandler() {

	}

	public int getItemIndex(String message, String word) {
		String[] array = message.split(" ");
		for (int index = 0; index < array.length; index++) {
			if (array[index].equals(word)) {
				return index;
			}
		}
		return -1;
	}
	
	public byte getSpawnEggValuesBecauseDyeColorsAreDumb(String message) {
		String[] array = message.split(" ");
		int i = getItemIndex(message, "spawn");
		if (array[i - 1].equalsIgnoreCase("creeper")) {
			return (byte) 50;
		} else if (array[i - 1].equalsIgnoreCase("skeleton")) {
			return (byte) 51;
		} else if (array[i - 1].equalsIgnoreCase("spider")) {
			if (i - 2 >= 0) {
				if (array[i - 2].equalsIgnoreCase("cave")) {
					return (byte) 59;
				} else {
					return (byte) 52;
				}
			} else {
				return (byte) 52;
			}
		} else if (array[i - 1].equalsIgnoreCase("zombie")) {
			return (byte) 54;
		} else if (array[i - 1].equalsIgnoreCase("slime")) {
			return (byte) 55;
		} else if (array[i - 1].equalsIgnoreCase("ghast")) {
			return (byte) 56;
		} else if (array[i - 1].equalsIgnoreCase("pigman")) {
			if (array[i - 2].equalsIgnoreCase("zombie")) {
				return (byte) 57;
			}
		} else if (array[i - 1].equalsIgnoreCase("enderman")) {
			return (byte) 58;
		} else if (array[i - 1].equalsIgnoreCase("silverfish")) {
			return (byte) 60;
		} else if (array[i - 1].equalsIgnoreCase("blaze")) {
			return (byte) 61;
		} else if (array[i - 1].equalsIgnoreCase("cube")) {
			if (array[i - 2].equalsIgnoreCase("magma")) {
				return (byte) 62;
			}
		} else if (array[i - 1].equalsIgnoreCase("bat")) {
			return (byte) 65;
		} else if (array[i - 1].equalsIgnoreCase("witch")) {
			return (byte) 66;
		} else if (array[i - 1].equalsIgnoreCase("endermite")) {
			return (byte) 67;
		} else if (array[i - 1].equalsIgnoreCase("guardian")) {
			return (byte) 68;
		} /*
			 * else if (array[i - 1].equalsIgnoreCase("shulker")) {
			 * return (byte) 69); }
			 */ else if (array[i - 1].equalsIgnoreCase("pig")) {
			return (byte) 90;
		} else if (array[i - 1].equalsIgnoreCase("sheep")) {
			return (byte) 91;
		} else if (array[i - 1].equalsIgnoreCase("cow")) {
			return (byte) 92;
		} else if (array[i - 1].equalsIgnoreCase("chicken")) {
			return (byte) 93;
		} else if (array[i - 1].equalsIgnoreCase("squid")) {
			return (byte) 94;
		} else if (array[i - 1].equalsIgnoreCase("wolf")) {
			return (byte) 95;
		} else if (array[i - 1].equalsIgnoreCase("mooshroom")) {
			return (byte) 96;
		} else if (array[i - 1].equalsIgnoreCase("ocelot")) {
			return (byte) 98;
		} else if (array[i - 1].equalsIgnoreCase("horse")) {
			return (byte) 100;
		} else if (array[i - 1].equalsIgnoreCase("rabbit")) {
			return (byte) 101;
		} else if (array[i - 1].equalsIgnoreCase("villager")) {
			return (byte) 120;
		}
		return 0;
	}

	@SuppressWarnings("deprecation")
	public DyeColor getMinecraftItemColor(String message) {
		int i;
		String[] array = message.split(" ");
		if (message.contains("light")) {
			i = getItemIndex(message, "light");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("blue")) {
					return DyeColor.LIGHT_BLUE;
				} else if (array[i + 1].equalsIgnoreCase("gray") || array[i + 1].equalsIgnoreCase("grey")) {
					return DyeColor.SILVER;
				}
			}
		} else if (message.contains("orange")) {
			i = getItemIndex(message, "orange");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("tulip")) {
					return null;
				} else {
					return DyeColor.ORANGE;
				}
			} else {
				return DyeColor.ORANGE;
			}
		} else if (message.contains("magenta")) {
			return DyeColor.MAGENTA;
		} else if (message.contains("yellow")) {
			return DyeColor.YELLOW;
		} else if (message.contains("lime")) {
			return DyeColor.LIME;
		} else if (message.contains("pink")) {
			i = getItemIndex(message, "pink");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("tulip")) {
					return null;
				} else {
					return DyeColor.PINK;
				}
			} else {
				return DyeColor.PINK;
			}
		} else if (message.contains("gray") || message.contains("grey")) {
			return DyeColor.GRAY;
		} else if (message.contains("cyan")) {
			return DyeColor.CYAN;
		} else if (message.contains("purple")) {
			return DyeColor.PURPLE;
		} else if (message.contains("blue")) {
			i = getItemIndex(message, "blue");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("orchid")) {
					return null;
				} else {
					return DyeColor.BLUE;
				}
			} else {
				return DyeColor.BLUE;
			}
		} else if (message.contains("brown")) {
			i = getItemIndex(message, "brown");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("mushroom")) {
					return null;
				} else {
					return DyeColor.BROWN;
				}
			} else {
				return DyeColor.BROWN;
			}
		} else if (message.contains("green")) {
			return DyeColor.GREEN;
		} else if (message.contains("red")) {
			i = getItemIndex(message, "red");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("tulip")) {
					return null;
				} else if (array[i + 1].equalsIgnoreCase("mushroom")) {
					return null;
				} else if (array[i + 1].equalsIgnoreCase("sandstone")) {
					return null;
				} else if (array[i + 1].equalsIgnoreCase("sand")) {
					return DyeColor.getByData((byte) 1);
				} else {
					return DyeColor.RED;
				}
			} else {
				return DyeColor.RED;
			}
		} else if (message.contains("black")) {
			return DyeColor.BLACK;
		} else if (message.contains("white")) {
			i = getItemIndex(message, "white");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("tulip")) {
					return null;
				} else {
					return DyeColor.WHITE;
				}
			} else {
				return DyeColor.WHITE;
			}
		} else if (message.contains("chiseled")) {
			i = getItemIndex(message, "chiseled");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("stone")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("brick")) {
							return DyeColor.getByData((byte) 3);
						} else if (array[i + 2].equalsIgnoreCase("monster")) {
							return DyeColor.getByData((byte) 5);
						}
					}
				} else {
					return DyeColor.getByData((byte) 1);
				}
			} else {
				return null;
			}
		} else if (message.contains("polished")) {
			i = getItemIndex(message, "polished");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("granite")) {
					return DyeColor.getByData((byte) 2);
				} else if (array[i + 1].equalsIgnoreCase("diorite")) {
					return DyeColor.getByData((byte) 4);
				} else if (array[i + 1].equalsIgnoreCase("andesite")) {
					return DyeColor.getByData((byte) 6);
				}
			} else {
				return null;
			}
		} else if (message.contains("coarse")) {
			i = getItemIndex(message, "coarse");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("dirt")) {
					return DyeColor.getByData((byte) 1);
				}
			} else {
				return null;
			}
		} else if (message.contains("spawn")) {
			i = getItemIndex(message, "spawn");
			if (array[i - 1].equalsIgnoreCase("creeper")) {
				return DyeColor.getByData((byte) 50);
			} else if (array[i - 1].equalsIgnoreCase("skeleton")) {
				return DyeColor.getByData((byte) 51);
			} else if (array[i - 1].equalsIgnoreCase("spider")) {
				if (i - 2 >= 0) {
					if (array[i - 2].equalsIgnoreCase("cave")) {
						return DyeColor.getByData((byte) 59);
					} else {
						return DyeColor.getByData((byte) 52);
					}
				} else {
					return DyeColor.getByData((byte) 52);
				}
			} else if (array[i - 1].equalsIgnoreCase("zombie")) {
				return DyeColor.getByData((byte) 54);
			} else if (array[i - 1].equalsIgnoreCase("slime")) {
				return DyeColor.getByData((byte) 55);
			} else if (array[i - 1].equalsIgnoreCase("ghast")) {
				return DyeColor.getByData((byte) 56);
			} else if (array[i - 1].equalsIgnoreCase("pigman")) {
				if (array[i - 2].equalsIgnoreCase("zombie")) {
					return DyeColor.getByData((byte) 57);
				}
			} else if (array[i - 1].equalsIgnoreCase("enderman")) {
				return DyeColor.getByData((byte) 58);
			} else if (array[i - 1].equalsIgnoreCase("silverfish")) {
				return DyeColor.getByData((byte) 60);
			} else if (array[i - 1].equalsIgnoreCase("blaze")) {
				return DyeColor.getByData((byte) 61);
			} else if (array[i - 1].equalsIgnoreCase("cube")) {
				if (array[i - 2].equalsIgnoreCase("magma")) {
					return DyeColor.getByData((byte) 62);
				}
			} else if (array[i - 1].equalsIgnoreCase("bat")) {
				return DyeColor.getByData((byte) 65);
			} else if (array[i - 1].equalsIgnoreCase("witch")) {
				return DyeColor.getByData((byte) 66);
			} else if (array[i - 1].equalsIgnoreCase("endermite")) {
				return DyeColor.getByData((byte) 67);
			} else if (array[i - 1].equalsIgnoreCase("guardian")) {
				return DyeColor.getByData((byte) 68);
			} /*
				 * else if (array[i - 1].equalsIgnoreCase("shulker")) {
				 * return DyeColor.getByData((byte) 69); }
				 */ else if (array[i - 1].equalsIgnoreCase("pig")) {
				return DyeColor.getByData((byte) 90);
			} else if (array[i - 1].equalsIgnoreCase("sheep")) {
				return DyeColor.getByData((byte) 91);
			} else if (array[i - 1].equalsIgnoreCase("cow")) {
				return DyeColor.getByData((byte) 92);
			} else if (array[i - 1].equalsIgnoreCase("chicken")) {
				return DyeColor.getByData((byte) 93);
			} else if (array[i - 1].equalsIgnoreCase("squid")) {
				return DyeColor.getByData((byte) 94);
			} else if (array[i - 1].equalsIgnoreCase("wolf")) {
				return DyeColor.getByData((byte) 95);
			} else if (array[i - 1].equalsIgnoreCase("mooshroom")) {
				return DyeColor.getByData((byte) 96);
			} else if (array[i - 1].equalsIgnoreCase("ocelot")) {
				return DyeColor.getByData((byte) 98);
			} else if (array[i - 1].equalsIgnoreCase("horse")) {
				return DyeColor.getByData((byte) 100);
			} else if (array[i - 1].equalsIgnoreCase("rabbit")) {
				return DyeColor.getByData((byte) 101);
			} else if (array[i - 1].equalsIgnoreCase("villager")) {
				return DyeColor.getByData((byte) 120);
			}
		} else if (message.contains("wood") || message.contains("wooden")) {
			i = getItemIndex(message, "wood");
			if (message.contains("wooden")) {
				i = getItemIndex(message, "wooden");
			}
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("slab")) {
					if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
						if (array[i - 1].equalsIgnoreCase("oak")) {
							return DyeColor.getByData((byte) 5);
						}
					} else {
						if (array[i - 1].equalsIgnoreCase("acacia")) {
							return DyeColor.getByData((byte) 4);
						} else if (array[i - 1].equalsIgnoreCase("spruce")) {
							return DyeColor.getByData((byte) 1);
						} else if (array[i - 1].equalsIgnoreCase("birch")) {
							return DyeColor.getByData((byte) 2);
						} else if (array[i - 1].equalsIgnoreCase("jungle")) {
							return DyeColor.getByData((byte) 3);
						} else {
							return null;
						}
					}
				} else if (array[i + 1].equalsIgnoreCase("planks")) {
					if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
						if (array[i - 1].equalsIgnoreCase("oak")) {
							return DyeColor.getByData((byte) 5);
						}
					} else {
						if (array[i - 1].equalsIgnoreCase("acacia")) {
							return DyeColor.getByData((byte) 4);
						} else if (array[i - 1].equalsIgnoreCase("spruce")) {
							return DyeColor.getByData((byte) 1);
						} else if (array[i - 1].equalsIgnoreCase("birch")) {
							return DyeColor.getByData((byte) 2);
						} else if (array[i - 1].equalsIgnoreCase("jungle")) {
							return DyeColor.getByData((byte) 3);
						} else {
							return null;
						}
					}
				} else {
					if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
						if (array[i - 1].equalsIgnoreCase("oak")) {
							return DyeColor.getByData((byte) 1);
						}
					} else {
						if (array[i - 1].equalsIgnoreCase("acacia")) {
							return null;
						} else if (array[i - 1].equalsIgnoreCase("spruce")) {
							return DyeColor.getByData((byte) 1);
						} else if (array[i - 1].equalsIgnoreCase("birch")) {
							return DyeColor.getByData((byte) 2);
						} else if (array[i - 1].equalsIgnoreCase("jungle")) {
							return DyeColor.getByData((byte) 3);
						} else {
							return null;
						}
					}
				}
			} else {
				if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
					if (array[i - 1].equalsIgnoreCase("oak")) {
						return DyeColor.getByData((byte) 1);
					}
				} else {
					if (array[i - 1].equalsIgnoreCase("acacia")) {
						return null;
					} else if (array[i - 1].equalsIgnoreCase("spruce")) {
						return DyeColor.getByData((byte) 1);
					} else if (array[i - 1].equalsIgnoreCase("birch")) {
						return DyeColor.getByData((byte) 2);
					} else if (array[i - 1].equalsIgnoreCase("jungle")) {
						return DyeColor.getByData((byte) 3);
					} else {
						return null;
					}
				}
			}
		} else if (message.contains("leaves")) {
			i = getItemIndex(message, "leaves");
			if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
				if (array[i - 1].equalsIgnoreCase("oak")) {
					return DyeColor.getByData((byte) 1);
				}
			} else {
				if (array[i - 1].equalsIgnoreCase("acacia")) {
					return null;
				} else if (array[i - 1].equalsIgnoreCase("spruce")) {
					return DyeColor.getByData((byte) 1);
				} else if (array[i - 1].equalsIgnoreCase("birch")) {
					return DyeColor.getByData((byte) 2);
				} else if (array[i - 1].equalsIgnoreCase("jungle")) {
					return DyeColor.getByData((byte) 3);
				} else {
					return null;
				}
			}
		} else if (message.contains("sapling")) {
			i = getItemIndex(message, "sapling");
			if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
				if (array[i - 1].equalsIgnoreCase("oak")) {
					return DyeColor.getByData((byte) 5);
				}
			} else {
				if (array[i - 1].equalsIgnoreCase("acacia")) {
					return DyeColor.getByData((byte) 4);
				} else if (array[i - 1].equalsIgnoreCase("spruce")) {
					return DyeColor.getByData((byte) 1);
				} else if (array[i - 1].equalsIgnoreCase("birch")) {
					return DyeColor.getByData((byte) 2);
				} else if (array[i - 1].equalsIgnoreCase("jungle")) {
					return DyeColor.getByData((byte) 3);
				} else {
					return null;
				}
			}
		} else if (message.contains("granite")) {
			return DyeColor.getByData((byte) 1);
		} else if (message.contains("diorite")) {
			return DyeColor.getByData((byte) 3);
		} else if (message.contains("andesite")) {
			return DyeColor.getByData((byte) 5);
		} else if (message.contains("podzol")) {
			return DyeColor.getByData((byte) 2);
		}
		return null;
	}

	public Material getMinecraftItem(String message) {
		int i = 0;
		String[] array = message.split(" ");

		if (message.contains("diamond")) {
			i = getItemIndex(message, "diamond");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("pickaxe") || array[i + 1].equalsIgnoreCase("pick")) {
					return Material.DIAMOND_PICKAXE;
				} else if (array[i + 1].equalsIgnoreCase("sword")) {
					return Material.DIAMOND_SWORD;
				} else if (array[i + 1].equalsIgnoreCase("axe")) {
					return Material.DIAMOND_AXE;
				} else if (array[i + 1].equalsIgnoreCase("hoe")) {
					return Material.DIAMOND_HOE;
				} else if (array[i + 1].equalsIgnoreCase("shovel")) {
					return Material.DIAMOND_SPADE;
				} else if (array[i + 1].equalsIgnoreCase("helmet")) {
					return Material.DIAMOND_HELMET;
				} else if (array[i + 1].equalsIgnoreCase("leggings")) {
					return Material.DIAMOND_LEGGINGS;
				} else if (array[i + 1].equalsIgnoreCase("boots")) {
					return Material.DIAMOND_BOOTS;
				} else if (array[i + 1].equalsIgnoreCase("chestplate")) {
					return Material.DIAMOND_CHESTPLATE;
				} else if (array[i + 1].equalsIgnoreCase("ore")) {
					return Material.DIAMOND_ORE;
				} else if (array[i + 1].equalsIgnoreCase("block")) {
					return Material.DIAMOND_BLOCK;
				} else if (array[i + 1].equalsIgnoreCase("horse")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("armor") || array[i + 1].equalsIgnoreCase("armour")) {
							return Material.DIAMOND_BARDING;
						} else {
							return Material.DIAMOND;
						}
					} else {
						return Material.DIAMOND;
					}
				} else {
					return Material.DIAMOND;
				}
			} else {
				return Material.DIAMOND;
			}
		} else if (message.contains("gold") || message.contains("golden")) {
			i = getItemIndex(message, "gold");
			if (message.contains("wooden")) {
				i = getItemIndex(message, "golden");
			}
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("pickaxe") || array[i + 1].equalsIgnoreCase("pick")) {
					return Material.GOLD_PICKAXE;
				} else if (array[i + 1].equalsIgnoreCase("sword")) {
					return Material.GOLD_SWORD;
				} else if (array[i + 1].equalsIgnoreCase("axe")) {
					return Material.GOLD_AXE;
				} else if (array[i + 1].equalsIgnoreCase("hoe")) {
					return Material.GOLD_HOE;
				} else if (array[i + 1].equalsIgnoreCase("shovel")) {
					return Material.GOLD_SPADE;
				} else if (array[i + 1].equalsIgnoreCase("helmet")) {
					return Material.GOLD_HELMET;
				} else if (array[i + 1].equalsIgnoreCase("leggings")) {
					return Material.GOLD_LEGGINGS;
				} else if (array[i + 1].equalsIgnoreCase("boots")) {
					return Material.GOLD_BOOTS;
				} else if (array[i + 1].equalsIgnoreCase("chestplate")) {
					return Material.GOLD_CHESTPLATE;
				} else if (array[i + 1].equalsIgnoreCase("ore")) {
					return Material.GOLD_ORE;
				} else if (array[i + 1].equalsIgnoreCase("block")) {
					return Material.GOLD_BLOCK;
				} else if (array[i + 1].equalsIgnoreCase("ingot")) {
					return Material.GOLD_INGOT;
				} else if (array[i + 1].equalsIgnoreCase("nugget")) {
					return Material.GOLD_NUGGET;
				} else if (array[i + 1].equalsIgnoreCase("horse")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("armor") || array[i + 1].equalsIgnoreCase("armour")) {
							return Material.GOLD_BARDING;
						} else {
							return Material.GOLD_INGOT;
						}
					} else {
						return Material.GOLD_INGOT;
					}
				} else {
					return Material.GOLD_INGOT;
				}
			} else {
				return Material.GOLD_INGOT;
			}
		} else if (message.contains("iron")) {
			i = getItemIndex(message, "iron");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("pickaxe") || array[i + 1].equalsIgnoreCase("pick")) {
					return Material.IRON_PICKAXE;
				} else if (array[i + 1].equalsIgnoreCase("sword")) {
					return Material.IRON_SWORD;
				} else if (array[i + 1].equalsIgnoreCase("axe")) {
					return Material.IRON_AXE;
				} else if (array[i + 1].equalsIgnoreCase("hoe")) {
					return Material.IRON_HOE;
				} else if (array[i + 1].equalsIgnoreCase("shovel")) {
					return Material.IRON_SPADE;
				} else if (array[i + 1].equalsIgnoreCase("helmet")) {
					return Material.IRON_HELMET;
				} else if (array[i + 1].equalsIgnoreCase("leggings")) {
					return Material.IRON_LEGGINGS;
				} else if (array[i + 1].equalsIgnoreCase("boots")) {
					return Material.IRON_BOOTS;
				} else if (array[i + 1].equalsIgnoreCase("chestplate")) {
					return Material.IRON_CHESTPLATE;
				} else if (array[i + 1].equalsIgnoreCase("ore")) {
					return Material.IRON_ORE;
				} else if (array[i + 1].equalsIgnoreCase("block")) {
					return Material.IRON_BLOCK;
				} else if (array[i + 1].equalsIgnoreCase("ingot")) {
					return Material.IRON_INGOT;
				} else if (array[i + 1].equalsIgnoreCase("door")) {
					return Material.IRON_DOOR;
				} else if (array[i + 1].equalsIgnoreCase("trapdoor")) {
					return Material.IRON_TRAPDOOR;
				} else if (array[i + 1].equalsIgnoreCase("bars")) {
					return Material.IRON_FENCE;
				} else if (array[i + 1].equalsIgnoreCase("horse")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("armor") || array[i + 1].equalsIgnoreCase("armour")) {
							return Material.IRON_BARDING;
						} else {
							return Material.IRON_INGOT;
						}
					} else {
						return Material.IRON_INGOT;
					}
				} else {
					return Material.IRON_INGOT;
				}
			} else {
				return Material.IRON_INGOT;
			}
		} else if (message.contains("redstone")) {
			i = getItemIndex(message, "redstone");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("ore")) {
					return Material.REDSTONE_ORE;
				} else if (array[i + 1].equalsIgnoreCase("torch")) {
					return Material.REDSTONE_TORCH_ON;
				} else if (array[i + 1].equalsIgnoreCase("repeater")) {
					return Material.DIODE;
				} else if (array[i + 1].equalsIgnoreCase("comparator")) {
					return Material.REDSTONE_COMPARATOR;
				} else if (array[i + 1].equalsIgnoreCase("lamp")) {
					return Material.REDSTONE_LAMP_OFF;
				} else if (array[i + 1].equalsIgnoreCase("block")) {
					return Material.REDSTONE_BLOCK;
				} else {
					return Material.REDSTONE;
				}
			} else {
				return Material.REDSTONE;
			}
		} else if (message.contains("wood") || message.contains("wooden")) {
			i = getItemIndex(message, "wood");
			if (message.contains("wooden")) {
				i = getItemIndex(message, "wooden");
			}
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("pickaxe") || array[i + 1].equalsIgnoreCase("pick")) {
					return Material.WOOD_PICKAXE;
				} else if (array[i + 1].equalsIgnoreCase("sword")) {
					return Material.WOOD_SWORD;
				} else if (array[i + 1].equalsIgnoreCase("axe")) {
					return Material.WOOD_AXE;
				} else if (array[i + 1].equalsIgnoreCase("hoe")) {
					return Material.WOOD_HOE;
				} else if (array[i + 1].equalsIgnoreCase("shovel")) {
					return Material.WOOD_SPADE;
				} else if (array[i + 1].equalsIgnoreCase("door")) {
					if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
						if (array[i - 1].equalsIgnoreCase("oak")) {
							return Material.DARK_OAK_DOOR_ITEM;
						}
					} else {
						if (array[i - 1].equalsIgnoreCase("acacia")) {
							return Material.ACACIA_DOOR_ITEM;
						} else if (array[i - 1].equalsIgnoreCase("spruce")) {
							return Material.SPRUCE_DOOR_ITEM;
						} else if (array[i - 1].equalsIgnoreCase("birch")) {
							return Material.BIRCH_DOOR_ITEM;
						} else if (array[i - 1].equalsIgnoreCase("jungle")) {
							return Material.JUNGLE_DOOR_ITEM;
						} else {
							return Material.WOOD_DOOR;
						}
					}
				} else if (array[i + 1].equalsIgnoreCase("trapdoor")) {
					return Material.TRAP_DOOR;
				} else if (array[i + 1].equalsIgnoreCase("slab")) {
					return Material.WOOD_STEP;
				} else if (array[i + 1].equalsIgnoreCase("stairs")) {
					if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
						if (array[i - 1].equalsIgnoreCase("oak")) {
							return Material.DARK_OAK_STAIRS;
						}
					} else {
						if (array[i - 1].equalsIgnoreCase("acacia")) {
							return Material.ACACIA_STAIRS;
						} else if (array[i - 1].equalsIgnoreCase("spruce")) {
							return Material.SPRUCE_WOOD_STAIRS;
						} else if (array[i - 1].equalsIgnoreCase("birch")) {
							return Material.BIRCH_WOOD_STAIRS;
						} else if (array[i - 1].equalsIgnoreCase("jungle")) {
							return Material.JUNGLE_WOOD_STAIRS;
						} else {
							return Material.WOOD_STAIRS;
						}
					}
				} else if (array[i + 1].equalsIgnoreCase("button")) {
					return Material.WOOD_BUTTON;
				} else if (array[i + 1].equalsIgnoreCase("planks")) {
					return Material.WOOD;
				} else if (array[i + 1].equalsIgnoreCase("pressure")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("plate")) {
							return Material.WOOD_PLATE;
						} else {
							return Material.LOG;
						}
					} else {
						if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
							if (array[i - 1].equalsIgnoreCase("oak")) {
								return Material.LOG_2;
							}
						} else {
							if (array[i - 1].equalsIgnoreCase("acacia")) {
								return Material.LOG_2;
							} else {
								return Material.LOG;
							}
						}
					}
				} else {
					if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
						if (array[i - 1].equalsIgnoreCase("oak")) {
							return Material.LOG_2;
						}
					} else {
						if (array[i - 1].equalsIgnoreCase("acacia")) {
							return Material.LOG_2;
						} else {
							return Material.LOG;
						}
					}
				}
			} else {
				if (i - 2 >= 0 && array[i - 2].equalsIgnoreCase("dark")) {
					if (array[i - 1].equalsIgnoreCase("oak")) {
						return Material.LOG_2;
					}
				} else {
					if (array[i - 1].equalsIgnoreCase("acacia")) {
						return Material.LOG_2;
					} else {
						return Material.LOG;
					}
				}
			}
		} else if (message.contains("fence")) {
			i = getItemIndex(message, "fence");
			if (array[i - 1].equalsIgnoreCase("acacia")) {
				if (i + 1 < array.length) {
					if (array[i + 1].equalsIgnoreCase("gate")) {
						return Material.ACACIA_FENCE_GATE;
					} else {
						return Material.ACACIA_FENCE;
					}
				} else {
					return Material.ACACIA_FENCE;
				}
			} else if (array[i - 1].equalsIgnoreCase("birch")) {
				if (i + 1 < array.length) {
					if (array[i + 1].equalsIgnoreCase("gate")) {
						return Material.BIRCH_FENCE_GATE;
					} else {
						return Material.BIRCH_FENCE;
					}
				} else {
					return Material.BIRCH_FENCE;
				}
			} else if (array[i - 1].equalsIgnoreCase("jungle")) {
				if (i + 1 < array.length) {
					if (array[i + 1].equalsIgnoreCase("gate")) {
						return Material.JUNGLE_FENCE_GATE;
					} else {
						return Material.JUNGLE_FENCE;
					}
				} else {
					return Material.JUNGLE_FENCE;
				}
			} else if (array[i - 1].equalsIgnoreCase("spruce")) {
				if (i + 1 < array.length) {
					if (array[i + 1].equalsIgnoreCase("gate")) {
						return Material.SPRUCE_FENCE_GATE;
					} else {
						return Material.SPRUCE_FENCE;
					}
				} else {
					return Material.SPRUCE_FENCE;
				}
			} else if (array[i - 1].equalsIgnoreCase("nether")) {
				return Material.NETHER_FENCE;
			} else if (array[i - 1].equalsIgnoreCase("oak")) {
				if (i + 1 < array.length) {
					if (array[i + 1].equalsIgnoreCase("gate")) {
						return Material.FENCE_GATE;
					} else {
						return Material.FENCE;
					}
				} else {
					return Material.FENCE;
				}
			} else {
				if (i - 2 >= 0) {
					if (array[i - 2].equalsIgnoreCase("dark")) {
						if (array[i - 1].equalsIgnoreCase("oak")) {
							if (i + 1 < array.length) {
								if (array[i + 1].equalsIgnoreCase("gate")) {
									return Material.DARK_OAK_FENCE_GATE;
								} else {
									return Material.DARK_OAK_FENCE;
								}
							} else {
								return Material.DARK_OAK_FENCE;
							}
						} else {
							return Material.DARK_OAK_FENCE;
						}
					}
				} else {
					if (i + 1 < array.length) {
						if (array[i + 1].equalsIgnoreCase("gate")) {
							return Material.FENCE_GATE;
						} else {
							return Material.FENCE;
						}
					} else {
						return Material.FENCE;
					}
				}
			}
		} else if (message.contains("stained")) {
			i = getItemIndex(message, "stained");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("glass")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("pane")) {
							return Material.STAINED_GLASS_PANE;
						} else {
							return Material.STAINED_GLASS;
						}
					} else {
						return Material.STAINED_GLASS;
					}
				} else if (array[i + 2].equalsIgnoreCase("clay")) {
					return Material.STAINED_CLAY;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else if (message.contains("glass")) {
			i = getItemIndex(message, "glass");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("pane")) {
					return Material.THIN_GLASS;
				} else {
					return Material.GLASS;
				}
			} else {
				return Material.GLASS;
			}
		} else if (message.contains("tall")) {
			i = getItemIndex(message, "tall");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("grass")) {
					return Material.LONG_GRASS;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else if (message.contains("dead")) {
			i = getItemIndex(message, "dead");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("shrub") || array[i + 1].equalsIgnoreCase("bush")) {
					return Material.DEAD_BUSH;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else if (message.contains("cobblestone") || message.contains("cobble")) {
			i = getItemIndex(message, "cobble");
			if (message.contains("cobblestone")) {
				i = getItemIndex(message, "cobblestone");
			}
			if (array[i - 1].equalsIgnoreCase("mossy") || array[i - 1].equalsIgnoreCase("moss")) {
				if (i + 1 < array.length) {
					if (array[i + 1].equalsIgnoreCase("wall")) {
						return Material.COBBLE_WALL;
					} else {
						return Material.MOSSY_COBBLESTONE;
					}
				} else {
					return Material.MOSSY_COBBLESTONE;
				}
			} else {
				if (i + 1 < array.length) {
					if (array[i + 1].equalsIgnoreCase("wall")) {
						return Material.COBBLE_WALL;
					} else if (array[i + 1].equalsIgnoreCase("stairs")) {
						return Material.COBBLESTONE_STAIRS;
					} else {
						return Material.COBBLESTONE;
					}
				} else {
					return Material.COBBLESTONE;
				}
			}
		} else if (message.contains("leather")) {
			i = getItemIndex(message, "leather");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("cap") || array[i + 1].equalsIgnoreCase("helmet")) {
					return Material.LEATHER_HELMET;
				} else if (array[i + 1].equalsIgnoreCase("tunic") || array[i + 1].equalsIgnoreCase("chestplate")) {
					return Material.LEATHER_CHESTPLATE;
				} else if (array[i + 1].equalsIgnoreCase("pants") || array[i + 1].equalsIgnoreCase("leggings")) {
					return Material.LEATHER_LEGGINGS;
				} else if (array[i + 1].equalsIgnoreCase("boots")) {
					return Material.LEATHER_BOOTS;
				} else if (array[i + 1].equalsIgnoreCase("hoe")) {
					return Material.STONE_HOE;
				} else {
					return Material.LEATHER;
				}
			} else {
				return Material.LEATHER;
			}
		} else if (message.contains("stone")) {
			i = getItemIndex(message, "stone");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("sword")) {
					return Material.STONE_SWORD;
				} else if (array[i + 1].equalsIgnoreCase("shovel")) {
					return Material.STONE_SPADE;
				} else if (array[i + 1].equalsIgnoreCase("pickaxe") || array[i + 1].equalsIgnoreCase("pick")) {
					return Material.STONE_PICKAXE;
				} else if (array[i + 1].equalsIgnoreCase("axe")) {
					return Material.STONE_AXE;
				} else if (array[i + 1].equalsIgnoreCase("hoe")) {
					return Material.STONE_HOE;
				} else if (array[i + 1].equalsIgnoreCase("pressure")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("plate")) {
							return Material.STONE_PLATE;
						} else {
							return Material.STONE;
						}
					} else {
						return Material.STONE;
					}
				} else if (array[i + 1].equalsIgnoreCase("brick")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("slab")) {
							return Material.STEP;
						} else if (array[i + 2].equalsIgnoreCase("stairs")) {
							return Material.SMOOTH_STAIRS;
						} else {
							return Material.SMOOTH_BRICK;
						}
					} else {
						return Material.SMOOTH_BRICK;
					}
				} else {
					return Material.STONE;
				}
			} else {
				return Material.STONE;
			}
		} else if (message.contains("mushroom")) {
			i = getItemIndex(message, "mushroom");
			if (array[i - 1].equalsIgnoreCase("brown")) {
				return Material.BROWN_MUSHROOM;
			} else if (array[i - 1].equalsIgnoreCase("red")) {
				return Material.RED_MUSHROOM;
			} else {
				return null;
			}
		} else if (message.contains("sandstone")) {
			i = getItemIndex(message, "sandstone");
			if (array[i - 1].equalsIgnoreCase("red")) {
				if (i + 1 < array.length) {
					if (array[i + 1].equalsIgnoreCase("stairs")) {
						return Material.RED_SANDSTONE_STAIRS;
					} else if (array[i + 1].equalsIgnoreCase("slab")) {
						return Material.STONE_SLAB2;
					} else {
						return Material.RED_SANDSTONE;
					}
				} else {
					return Material.RED_SANDSTONE;
				}
			} else {
				return Material.SANDSTONE;
			}
		} else if (message.contains("sand")) {
			i = getItemIndex(message, "sand");
			if (array[i - 1].equalsIgnoreCase("soul")) {
				return Material.SOUL_SAND;
			} else {
				return Material.SAND;
			}
		} else if (message.contains("chest")) {
			i = getItemIndex(message, "chest");
			if (array[i - 1].equalsIgnoreCase("ender")) {
				return Material.ENDER_CHEST;
			} else {
				return Material.CHEST;
			}
		} else if (message.contains("wool")) {
			return Material.WOOL;
		} else if (message.contains("jukebox")) {
			return Material.JUKEBOX;
		} else if (message.contains("lever")) {
			return Material.LEVER;
		} else if (message.contains("furnace")) {
			return Material.FURNACE;
		} else if (message.contains("farmland")) {
			return Material.SOIL;
		} else if (message.contains("rail")) {
			i = getItemIndex(message, "rail");
			if (array[i - 1].equalsIgnoreCase("activator")) {
				return Material.ACTIVATOR_RAIL;
			} else if (array[i - 1].equalsIgnoreCase("powered")) {
				return Material.POWERED_RAIL;
			} else if (array[i - 1].equalsIgnoreCase("detector")) {
				return Material.DETECTOR_RAIL;
			} else {
				return Material.RAILS;
			}
		} else if (message.contains("flint")) {
			i = getItemIndex(message, "flint");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("and") || array[i + 1].equalsIgnoreCase("&")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("steel")) {
							return Material.FLINT_AND_STEEL;
						} else {
							return Material.FLINT;
						}
					} else {
						return Material.FLINT;
					}
				} else {
					return Material.FLINT;
				}
			} else {
				return Material.FLINT;
			}
		} else if (message.contains("sugar")) {
			i = getItemIndex(message, "sugar");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("cane")) {
					return Material.SUGAR_CANE;
				} else {
					return Material.SUGAR;
				}
			} else {
				return Material.SUGAR;
			}
		} else if (message.contains("granite") || message.contains("diorite") || message.contains("andesite")) {
			return Material.STONE;
		} else if (message.contains("dirt") || message.contains("podzol")) {
			return Material.DIRT;
		} else if (message.contains("tnt") || message.contains("dynamite")) {
			return Material.TNT;
		} else if (message.contains("torch")) {
			return Material.TORCH;
		} else if (message.contains("ladder")) {
			return Material.LADDER;
		} else if (message.contains("obsidian")) {
			return Material.OBSIDIAN;
		} else if (message.contains("sunflower")) {
			return Material.DOUBLE_PLANT;
		} else if (message.contains("bed")) {
			return Material.BED;
		} else if (message.contains("cake")) {
			return Material.CAKE;
		} else if (message.contains("paper")) {
			return Material.PAPER;
		} else if (message.contains("book")) {
			i = getItemIndex(message, "book");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("and") || array[i + 1].equalsIgnoreCase("&")) {
					if (i + 2 < array.length) {
						if (array[i + 2].equalsIgnoreCase("quill")) {
							return Material.BOOK_AND_QUILL;
						} else {
							return Material.BOOK;
						}
					} else {
						return Material.BOOK;
					}
				} else {
					return Material.BOOK;
				}
			} else {
				return Material.BOOK;
			}
		} else if (message.contains("emerald")) {
			i = getItemIndex(message, "emerald");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("ore")) {
					return Material.EMERALD_ORE;
				} else if (array[i + 1].equalsIgnoreCase("block")) {
					return Material.EMERALD_BLOCK;
				} else {
					return Material.EMERALD;
				}
			} else {
				return Material.EMERALD;
			}
		} else if (message.contains("carrot")) {
			return Material.CARROT_ITEM;
		} else if (message.contains("potato")) {
			return Material.POTATO_ITEM;
		} else if (message.contains("wheat")) {
			return Material.WHEAT;
		} else if (message.contains("cookie")) {
			return Material.COOKIE;
		} else if (message.contains("stick")) {
			return Material.STICK;
		} else if (message.contains("bowl")) {
			return Material.BOWL;
		} else if (message.contains("bow")) {
			return Material.BOW;
		} else if (message.contains("arrow")) {
			return Material.ARROW;
		} else if (message.contains("string")) {
			return Material.STRING;
		} else if (message.contains("grass")) {
			return Material.GRASS;
		} else if (message.contains("planks")) {
			return Material.WOOD;
		} else if (message.contains("sign")) {
			return Material.SIGN;
		} else if (message.contains("gunpowder") || message.contains("sulphur")) {
			return Material.SULPHUR;
		} else if (message.contains("coal")) {
			i = getItemIndex(message, "coal");
			if (i + 1 < array.length) {
				if (array[i + 1].equalsIgnoreCase("ore")) {
					return Material.COAL_ORE;
				} else if (array[i + 1].equalsIgnoreCase("block")) {
					return Material.COAL_BLOCK;
				} else {
					return Material.COAL;
				}
			} else {
				return Material.COAL;
			}
		} else if (message.contains("spawn egg")) {
			return Material.MONSTER_EGG;
		} else {
			for (String s : array) {
				Material m = Material.getMaterial(s);
				if (m != null && m != Material.AIR) {
					return m;
				}
			}
		}
		return null;
	}

	public Material changeBlockToItem(Material m) {
		if (m == Material.BED_BLOCK) {
			return Material.BED;
		} else if (m == Material.ACACIA_DOOR) {
			return Material.ACACIA_DOOR_ITEM;
		} else if (m == Material.CAKE_BLOCK) {
			return Material.CAKE;
		} else if (m == Material.WOODEN_DOOR) {
			return Material.WOOD_DOOR;
		} else if (m == Material.DARK_OAK_DOOR) {
			return Material.DARK_OAK_DOOR_ITEM;
		} else if (m == Material.POTATO) {
			return Material.POTATO_ITEM;
		} else if (m == Material.CARROT) {
			return Material.CARROT_ITEM;
		} else if (m == Material.DIODE_BLOCK_OFF || m == Material.DIODE_BLOCK_ON) {
			return Material.DIODE;
		} else if (m == Material.REDSTONE_COMPARATOR_OFF || m == Material.REDSTONE_COMPARATOR_ON) {
			return Material.REDSTONE_COMPARATOR;
		} else if (m == Material.REDSTONE_WIRE) {
			return Material.REDSTONE;
		} else if (m == Material.SUGAR_CANE_BLOCK) {
			return Material.SUGAR_CANE;
		} else if (m == Material.CROPS) {
			return Material.WHEAT;
		} else if (m == Material.SIGN_POST || m == Material.WALL_SIGN) {
			return Material.SIGN;
		} else if (m == Material.CAULDRON) {
			return Material.CAULDRON_ITEM;
		} else if (m == Material.LAVA || m == Material.STATIONARY_LAVA) {
			return Material.LAVA_BUCKET;
		} else if (m == Material.WATER || m == Material.STATIONARY_WATER) {
			return Material.WATER_BUCKET;
		} else if (m == Material.FLOWER_POT) {
			return Material.FLOWER_POT_ITEM;
		} else if (m == Material.SKULL) {
			return Material.SKULL_ITEM;
		} else if (m == Material.STANDING_BANNER || m == Material.WALL_BANNER) {
			return Material.BANNER;
		} else if (m == Material.DAYLIGHT_DETECTOR_INVERTED) {
			return Material.DAYLIGHT_DETECTOR;
		} else if (m == Material.SPRUCE_DOOR) {
			return Material.SPRUCE_DOOR_ITEM;
		} else if (m == Material.JUNGLE_DOOR) {
			return Material.JUNGLE_DOOR_ITEM;
		} else if (m == Material.BIRCH_DOOR) {
			return Material.BIRCH_DOOR_ITEM;
		} else if (m == Material.PUMPKIN_STEM) {
			return Material.PUMPKIN_SEEDS;
		} else if (m == Material.MELON_STEM) {
			return Material.MELON_SEEDS;
		} else if (m == Material.BREWING_STAND) {
			return Material.BREWING_STAND_ITEM;
		} else if (m == Material.REDSTONE_LAMP_ON) {
			return Material.REDSTONE_LAMP_OFF;
		} else if (m == Material.TRIPWIRE) {
			return Material.STRING;
		} else if (m == Material.PISTON_EXTENSION || m == Material.PISTON_MOVING_PIECE) {
			return Material.AIR;
		}
		return m;
	}
}
