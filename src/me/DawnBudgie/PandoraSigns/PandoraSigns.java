package me.DawnBudgie.PandoraSigns;

import java.util.logging.Level;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PandoraSigns extends JavaPlugin
  implements Listener
{
  public static PandoraSigns cs;

  public void onEnable()
  {
    saveDefaultConfig();
    getServer().getPluginManager().registerEvents(this, this);
    getLogger().log(
      Level.INFO, 
      "PandoraSigns v" + getDescription().getVersion() + 
      " has been enabled.");
  }

  public void onDisable()
  {
    getLogger().log(
      Level.INFO, 
      "PandoraSigns v" + getDescription().getVersion() + 
      " has been enabled.");
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void onSignChange(SignChangeEvent event) {
    String CHAR = getConfig().getString("PandoraSigns.char");
    if (event.getPlayer().hasPermission("PandoraSigns.format")) {
      if (event.getLine(0).contains(CHAR)) {
        event.setLine(
          0, 
          event.getLine(0).replaceAll(
          "(" + CHAR + "([a-fk-or0-9A-FK-OR]))", 
          "§$2"));
      }
      if (event.getLine(1).contains(CHAR)) {
        event.setLine(
          1, 
          event.getLine(1).replaceAll(
          "(" + CHAR + "([a-fk-or0-9A-FK-OR]))", 
          "§$2"));
      }
      if (event.getLine(2).contains(CHAR)) {
        event.setLine(
          2, 
          event.getLine(2).replaceAll(
          "(" + CHAR + "([a-fk-or0-9A-FK-OR]))", 
          "§$2"));
      }
      if (event.getLine(3).contains(CHAR))
        event.setLine(
          3, 
          event.getLine(3).replaceAll(
          "(" + CHAR + "([a-fk-or0-9A-FK-OR]))", 
          "§$2"));
    }
  }
}