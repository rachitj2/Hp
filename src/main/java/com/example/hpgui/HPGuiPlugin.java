package com.example.hpgui;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerFoodLevelChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;

public class HPGuiPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        
        // Update HP GUI every tick for all players
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                updateHPGui(player);
            }
        }, 0L, 1L); // Update every tick
        
        getLogger().info("HP GUI Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HP GUI Plugin disabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        updateHPGui(event.getPlayer());
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            updateHPGui((Player) event.getEntity());
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        updateHPGui(event.getPlayer());
    }

    @EventHandler
    public void onFoodLevelChange(PlayerFoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            updateHPGui((Player) event.getEntity());
        }
    }

    private void updateHPGui(Player player) {
        // Get player stats
        double currentHp = player.getHealth();
        double maxHp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        int hunger = player.getFoodLevel();
        int mana = 100; // You can replace this with custom plugin data later
        
        // Create HP bar (Red)
        String hpBar = createBar(currentHp, maxHp, 10, ChatColor.RED, "❤");
        
        // Create Mana bar (Blue)
        String manaBar = createBar(mana, 100, 10, ChatColor.BLUE, "✦");
        
        // Create Hunger bar (Brown/Gold)
        String hungerBar = createBar(hunger, 20, 10, ChatColor.GOLD, "🍗");
        
        // Combine into one action bar message
        String actionBar = hpBar + " " + manaBar + " " + hungerBar;
        
        // Send to player
        player.spigot().sendMessage(org.bukkit.ChatMessageType.ACTION_BAR, 
            new net.md_5.bungee.api.chat.TextComponent(actionBar));
    }

    private String createBar(double current, double max, int length, ChatColor color, String symbol) {
        int filled = (int) Math.round((current / max) * length);
        int empty = length - filled;
        
        StringBuilder bar = new StringBuilder();
        bar.append(color);
        for (int i = 0; i < filled; i++) {
            bar.append(symbol);
        }
        bar.append(ChatColor.DARK_GRAY);
        for (int i = 0; i < empty; i++) {
            bar.append(symbol);
        }
        bar.append(ChatColor.RESET);
        bar.append(" ").append(String.format("%.0f/%.0f", current, max));
        
        return bar.toString();
    }
}
