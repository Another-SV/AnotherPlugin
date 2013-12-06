package com.anothersv.anotherplugin;

import net.minecraft.server.v1_7_R1.EntityPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AnotherPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player;
        if(cmd.getName().equalsIgnoreCase("ping")) {
            if(sender.getServer().getConsoleSender().equals(sender) && args.length != 1) {
                sender.sendMessage(ChatColor.RED+"Este comando não pode ser ultilizado pelo console.");
                return true;
            }
            if(args.length == 1) {
                player = this.getServer().getPlayer(args[0]);
                if(player == null || !player.isOnline()) {
                    sender.sendMessage(ChatColor.RED+"O player não existe ou não está online.");
                    return true;
                }
            } else {
                player = this.getServer().getPlayer(sender.getName());
            }
            EntityPlayer eplayer = ((CraftPlayer) player).getHandle();
            if(player.getName().equals(sender.getName()))
                sender.sendMessage(ChatColor.BLUE+"O seu ping no momento é: "+eplayer.ping+"ms");
            else
                sender.sendMessage(ChatColor.BLUE+"O ping do player "+player.getName()+" no momento é: "+eplayer.ping+"ms");
            return true;
        }
        return false;
    }

    
}
