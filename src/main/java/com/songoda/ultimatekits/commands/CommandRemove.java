package com.songoda.ultimatekits.commands;

import com.songoda.core.commands.AbstractCommand;
import com.songoda.core.hooks.HologramManager;
import com.songoda.ultimatekits.UltimateKits;
import com.songoda.ultimatekits.kit.Kit;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandRemove extends AbstractCommand {

    private final UltimateKits plugin;

    public CommandRemove(UltimateKits plugin) {
        super(CommandType.PLAYER_ONLY, "remove");
        this.plugin = plugin;
    }

    @Override
    protected ReturnType runCommand(CommandSender sender, String... args) {
        Player player = (Player) sender;
        Block block = player.getTargetBlock(null, 200);
        Kit kit = plugin.getKitManager().removeKitFromLocation(block.getLocation());
        if (kit == null) return ReturnType.FAILURE;

        if (HologramManager.isEnabled()) {
            plugin.getKitManager().getKitLocations().values().stream()
                    .filter(data -> data.getKit() == kit)
                    .forEach(data -> plugin.removeHologram(data));
        }

        plugin.getLocale().newMessage("&8Kit &9" + kit.getKey() + " &8unassigned from: &a" + block.getType().toString() + "&8.").sendPrefixedMessage(player);
        return ReturnType.SUCCESS;
    }

    @Override
    protected List<String> onTab(CommandSender sender, String... args) {
        return new ArrayList<>();
    }

    @Override
    public String getPermissionNode() {
        return "ultimatekits.admin";
    }

    @Override
    public String getSyntax() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "Remove a kit from the block you are looking at.";
    }
}
