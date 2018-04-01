package com.songoda.kitpreview.kits;

import com.songoda.arconix.Arconix;
import com.songoda.arconix.method.formatting.TextComponent;
import com.songoda.kitpreview.KitPreview;
import com.songoda.kitpreview.Lang;
import com.songoda.kitpreview.utils.Debugger;
import com.songoda.kitpreview.utils.Methods;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

/**
 * Created by songoda on 3/3/2017.
 */
public class BlockEditor {

    Location location;
    String locationStr;
    Kit kit;
    Block block;
    Player player;

    public BlockEditor(Block block, Player player) {
        try {
            this.location = block.getLocation();
            this.locationStr = Arconix.pl().serialize().serializeLocation(block);
            this.player = player;
            this.kit = new Kit(location);
            this.block = block;
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }

    private void defineInstance(String window) {
        try {
            KitPreview.getInstance().inEditor.put(player.getUniqueId(), window);
            KitPreview.getInstance().editing.put(player.getUniqueId(), block);
            KitPreview.getInstance().editingKit.put(player.getUniqueId(), kit);
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }

    public void open() {
        try {
            Inventory i = Bukkit.createInventory(null, 27, TextComponent.formatText("&8This contains &a" + Arconix.pl().format().formatTitle(kit.getShowableName())));

            Methods.fillGlass(i);

            i.setItem(0, Methods.getBackgroundGlass(true));
            i.setItem(1, Methods.getBackgroundGlass(true));
            i.setItem(2, Methods.getBackgroundGlass(false));
            i.setItem(6, Methods.getBackgroundGlass(false));
            i.setItem(7, Methods.getBackgroundGlass(true));
            i.setItem(8, Methods.getBackgroundGlass(true));
            i.setItem(9, Methods.getBackgroundGlass(true));
            i.setItem(10, Methods.getBackgroundGlass(false));
            i.setItem(16, Methods.getBackgroundGlass(false));
            i.setItem(17, Methods.getBackgroundGlass(true));
            i.setItem(18, Methods.getBackgroundGlass(true));
            i.setItem(19, Methods.getBackgroundGlass(true));
            i.setItem(20, Methods.getBackgroundGlass(false));
            i.setItem(24, Methods.getBackgroundGlass(false));
            i.setItem(25, Methods.getBackgroundGlass(true));
            i.setItem(26, Methods.getBackgroundGlass(true));

            ItemStack exit = new ItemStack(Material.valueOf(KitPreview.getInstance().getConfig().getString("Interfaces.Exit Icon")), 1);
            ItemMeta exitmeta = exit.getItemMeta();
            exitmeta.setDisplayName(Lang.EXIT.getConfigValue());
            exit.setItemMeta(exitmeta);
            i.setItem(8, exit);

            ItemStack alli = new ItemStack(Material.REDSTONE_COMPARATOR);
            ItemMeta allmeta = alli.getItemMeta();
            allmeta.setDisplayName(TextComponent.formatText("&5&lSwitch kit type"));
            ArrayList<String> lore = new ArrayList<>();
            lore.add(TextComponent.formatText("&7Click to swap this kits type."));
            lore.add("");
            if (KitPreview.getInstance().getConfig().getString("data.type." + locationStr) == null) {
                lore.add(TextComponent.formatText("&6Normal"));
                lore.add(TextComponent.formatText("&7Crate"));
                lore.add(TextComponent.formatText("&7Daily"));
            } else if (KitPreview.getInstance().getConfig().getString("data.type." + locationStr).equals("crate")) {
                lore.add(TextComponent.formatText("&7Normal"));
                lore.add(TextComponent.formatText("&6Crate"));
                lore.add(TextComponent.formatText("&7Daily"));
            } else if (KitPreview.getInstance().getConfig().getString("data.type." + locationStr).equals("daily")) {
                lore.add(TextComponent.formatText("&7Normal"));
                lore.add(TextComponent.formatText("&7Crate"));
                lore.add(TextComponent.formatText("&6Daily"));
            }
            allmeta.setLore(lore);
            alli.setItemMeta(allmeta);

            i.setItem(11, alli);

            alli = new ItemStack(Material.RED_ROSE);
            allmeta = alli.getItemMeta();
            allmeta.setDisplayName(TextComponent.formatText("&9&lDecor Options"));
            lore = new ArrayList<>();
            lore.add(TextComponent.formatText("&7Click to edit the decoration"));
            lore.add(TextComponent.formatText("&7options for this kit."));
            allmeta.setLore(lore);
            alli.setItemMeta(allmeta);

            i.setItem(13, alli);

            alli = new ItemStack(Material.DIAMOND_PICKAXE);
            allmeta = alli.getItemMeta();
            allmeta.setDisplayName(TextComponent.formatText("&a&lEdit kit"));
            lore = new ArrayList<>();
            lore.add(TextComponent.formatText("&7Click to edit the kit"));
            lore.add(TextComponent.formatText("&7contained in this block."));
            allmeta.setLore(lore);
            alli.setItemMeta(allmeta);

            i.setItem(15, alli);

            player.openInventory(i);
            defineInstance("menu");
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }

    public void decor() {
        try {
            Inventory i = Bukkit.createInventory(null, 27, TextComponent.formatText("&8Editing decor for &a" + Arconix.pl().format().formatTitle(kit.getShowableName()) + "&8."));

            Methods.fillGlass(i);

            i.setItem(0, Methods.getBackgroundGlass(true));
            i.setItem(1, Methods.getBackgroundGlass(true));
            i.setItem(2, Methods.getBackgroundGlass(false));
            i.setItem(6, Methods.getBackgroundGlass(false));
            i.setItem(7, Methods.getBackgroundGlass(true));
            i.setItem(8, Methods.getBackgroundGlass(true));
            i.setItem(9, Methods.getBackgroundGlass(true));
            i.setItem(10, Methods.getBackgroundGlass(false));
            i.setItem(16, Methods.getBackgroundGlass(false));
            i.setItem(17, Methods.getBackgroundGlass(true));
            i.setItem(18, Methods.getBackgroundGlass(true));
            i.setItem(19, Methods.getBackgroundGlass(true));
            i.setItem(20, Methods.getBackgroundGlass(false));
            i.setItem(24, Methods.getBackgroundGlass(false));
            i.setItem(25, Methods.getBackgroundGlass(true));
            i.setItem(26, Methods.getBackgroundGlass(true));

            ItemStack exit = new ItemStack(Material.valueOf(KitPreview.getInstance().getConfig().getString("Interfaces.Exit Icon")), 1);
            ItemMeta exitmeta = exit.getItemMeta();
            exitmeta.setDisplayName(Lang.EXIT.getConfigValue());
            exit.setItemMeta(exitmeta);


            ItemStack head2 = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
            ItemStack back = Arconix.pl().getGUI().addTexture(head2, "http://textures.minecraft.net/texture/3ebf907494a935e955bfcadab81beafb90fb9be49c7026ba97d798d5f1a23");
            SkullMeta skull2Meta = (SkullMeta) back.getItemMeta();
            back.setDurability((short) 3);
            skull2Meta.setDisplayName(Lang.BACK.getConfigValue());
            back.setItemMeta(skull2Meta);

            i.setItem(0, back);
            i.setItem(8, exit);

            ItemStack alli = new ItemStack(Material.SIGN);
            ItemMeta allmeta = alli.getItemMeta();
            allmeta.setDisplayName(TextComponent.formatText("&9&lToggle Holograms"));
            ArrayList<String> lore = new ArrayList<>();
            if (KitPreview.getInstance().getConfig().getString("data.holo." + locationStr) != null) {
                lore.add(TextComponent.formatText("&7Currently: &aEnabled&7."));
            } else {
                lore.add(TextComponent.formatText("&7Currently &cDisabled&7."));
            }
            allmeta.setLore(lore);
            alli.setItemMeta(allmeta);

            i.setItem(10, alli);

            alli = new ItemStack(Material.POTION);
            allmeta = alli.getItemMeta();
            allmeta.setDisplayName(TextComponent.formatText("&9&lToggle Particles"));
            lore = new ArrayList<>();
            if (KitPreview.getInstance().getConfig().getString("data.particles." + locationStr) != null) {
                lore.add(TextComponent.formatText("&7Currently: &aEnabled&7."));
            } else {
                lore.add(TextComponent.formatText("&7Currently &cDisabled&7."));
            }
            allmeta.setLore(lore);
            alli.setItemMeta(allmeta);

            i.setItem(12, alli);

            alli = new ItemStack(Material.GRASS);
            allmeta = alli.getItemMeta();
            allmeta.setDisplayName(TextComponent.formatText("&9&lToggle DisplayItems"));
            lore = new ArrayList<>();
            if (KitPreview.getInstance().getConfig().getString("data.displayitems." + locationStr) != null) {
                lore.add(TextComponent.formatText("&7Currently: &aEnabled&7."));
            } else {
                lore.add(TextComponent.formatText("&7Currently &cDisabled&7."));
            }
            allmeta.setLore(lore);
            alli.setItemMeta(allmeta);

            i.setItem(14, alli);

            alli = new ItemStack(Material.GLASS);
            if (KitPreview.getInstance().getConfig().getItemStack("data.kit." + kit.getShowableName() + ".displayitem") != null) {
                alli = KitPreview.getInstance().getConfig().getItemStack("data.kit." + kit.getShowableName() + ".displayitem");
            }
            allmeta = alli.getItemMeta();
            allmeta.setDisplayName(TextComponent.formatText("&9&lSet single DisplayItem"));
            lore = new ArrayList<>();
            if (KitPreview.getInstance().getConfig().getItemStack("data.kit." + kit.getShowableName() + ".displayitem") != null) {
                ItemStack is = KitPreview.getInstance().getConfig().getItemStack("data.kit." + kit.getShowableName() + ".displayitem");
                lore.add(TextComponent.formatText("&7Currently set to: &a" + is.getType().toString() + "&7."));
            } else {
                lore.add(TextComponent.formatText("&7Currently &cDisabled&7."));
            }
            lore.add("");
            lore.add(TextComponent.formatText("&7Right-Click to &9Set a"));
            lore.add(TextComponent.formatText("&9forced display item for this "));
            lore.add(TextComponent.formatText("&9kit to the item in your hand."));
            lore.add("");
            lore.add(TextComponent.formatText("&7Left-Click to &9Remove the item."));
            allmeta.setLore(lore);
            alli.setItemMeta(allmeta);

            i.setItem(16, alli);

            player.openInventory(i);
            defineInstance("decor");
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }


    public void toggleHologram() {
        try {
            if (KitPreview.getInstance().getConfig().getString("data.holo." + locationStr) == null) {
                KitPreview.getInstance().getConfig().set("data.holo." + locationStr, true);
                KitPreview.getInstance().saveConfig();
            } else {
                KitPreview.getInstance().getConfig().set("data.holo." + locationStr, null);
                KitPreview.getInstance().saveConfig();
            }
            KitPreview.getInstance().holo.updateHolograms();
            decor();
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }

    public void toggleParticles() {
        try {
            if (KitPreview.getInstance().getConfig().getString("data.particles." + locationStr) == null) {
                KitPreview.getInstance().getConfig().set("data.particles." + locationStr, true);
                KitPreview.getInstance().saveConfig();
            } else {
                KitPreview.getInstance().getConfig().set("data.particles." + locationStr, null);
                KitPreview.getInstance().saveConfig();
            }
            decor();
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }

    public void toggleDisplayItems() {
        try {
            boolean holo = KitPreview.getInstance().getConfig().getString("data.holo." + locationStr) != null;

            if (holo) {
                KitPreview.getInstance().getConfig().set("data.holo." + locationStr, null);
                KitPreview.getInstance().holo.updateHolograms();
            }

            if (KitPreview.getInstance().getConfig().getString("data.displayitems." + locationStr) == null) {
                KitPreview.getInstance().getConfig().set("data.displayitems." + locationStr, true);
                KitPreview.getInstance().saveConfig();
            } else {
                KitPreview.getInstance().getConfig().set("data.displayitems." + locationStr, null);
                KitPreview.getInstance().saveConfig();
                kit.removeDisplayItems();
            }
            decor();
            if (holo) {
                KitPreview.getInstance().getConfig().set("data.holo." + locationStr, true);
                KitPreview.getInstance().holo.updateHolograms();
            }
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }

    public void setDisplayItem(boolean type) {
        try {
            if (type) {
                ItemStack is = player.getItemInHand();
                KitPreview.getInstance().getConfig().set("data.kit." + kit.getShowableName() + ".displayitem", is);
                KitPreview.getInstance().saveConfig();
            } else {
                KitPreview.getInstance().getConfig().set("data.kit." + kit.getShowableName() + ".displayitem", null);
                KitPreview.getInstance().saveConfig();
            }
            decor();
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }


    public void changeDisplayType() {
        try {
            if (KitPreview.getInstance().getConfig().getString("data.type." + locationStr) == null) {
                KitPreview.getInstance().getConfig().set("data.type." + locationStr, "crate");
            } else if (KitPreview.getInstance().getConfig().getString("data.type." + locationStr).equals("crate")) {
                KitPreview.getInstance().getConfig().set("data.type." + locationStr, "daily");
            } else if (KitPreview.getInstance().getConfig().getString("data.type." + locationStr).equals("daily")) {
                KitPreview.getInstance().getConfig().set("data.type." + locationStr, null);
            }
            KitPreview.getInstance().saveConfig();
            KitPreview.getInstance().holo.updateHolograms();
            open();
        } catch (Exception ex) {
            Debugger.runReport(ex);
        }
    }

}
