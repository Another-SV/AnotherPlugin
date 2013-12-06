package com.anothersv.anotherplugin;

import com.anothersv.events.GrassDropGrass;
import org.bukkit.plugin.java.JavaPlugin;

public class AnotherPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new GrassDropGrass(), this);
    }

    
}
