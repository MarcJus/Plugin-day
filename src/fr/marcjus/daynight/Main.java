package fr.marcjus.daynight;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	 @Override
	public void onEnable() {
		 System.out.println("Plugin DayNight actif");
		 getCommand("day").setExecutor(this);
	}
	 
	@Override
	public void onDisable() {
		 System.out.println("Plugin DayNight inactif");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("day")){
			if(args.length==0) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					player.getWorld().setTime(1000);
					player.sendMessage(ChatColor.GREEN+"Il fait jour dans ton monde!");
				}else {
					sender.sendMessage("Usage : /day <world>");
				}
			}else {
				World world = Bukkit.getWorld(args[0]);
				if(world != null) {
					world.setTime(1000);
					sender.sendMessage("Il fait jour dans le monde "+world.getName()+"!");
					
				}else {
					sender.sendMessage(ChatColor.RED+"Erreur! Le monde n'existe pas!");
				}
			}
		}else if(cmd.getName().equalsIgnoreCase("night")) {
			if(args.length==0) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					player.getWorld().setTime(13000);
					player.sendMessage(ChatColor.GREEN+"Il fit nuit dans ton monde");
				}else {
					sender.sendMessage("Usage : /night <world>");
				}
			}else {
				World world = Bukkit.getWorld(args[0]);
				if(world != null) {
					world.setTime(13000);
					sender.sendMessage("Il fait nuit dans le monde "+world.getName()+"!");
				}else {
					sender.sendMessage(ChatColor.RED+"Erreur! Le monde n'existe pas!");
				}
			}
		}
		
		return false;
	}

}
