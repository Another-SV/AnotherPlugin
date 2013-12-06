package com.anothersv.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class GrassDropGrass implements Listener{
    
    @EventHandler
    public void onGrassBreak(BlockBreakEvent bbe) {
        Block block = bbe.getBlock();
        if(block.getType().equals(Material.GRASS)) {
            bbe.setCancelled(true);
            block.setType(Material.AIR);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GRASS));
        }
    }
}
