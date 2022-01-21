package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.LambdaEssentials
import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class VanishCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            val p: Player = sender;
            if(p.hasPermission("lambda.vanish")){
                val contains = LambdaEssentials.vanishList.contains(p)

                MessageManager.sendPlayerInfo("Vanish " + if(contains) "§bdeaktiviert!" else "§baktiviert!", p)
                if(contains) {
                    LambdaEssentials.vanishList.remove(p);

                    for(all: Player in Bukkit.getOnlinePlayers()){
                        all.showPlayer(LambdaEssentials.getInstance(), p)
                    }
                }else {
                    LambdaEssentials.vanishList.add(p);
                    for(all: Player in Bukkit.getOnlinePlayers()){
                        if(!(all.hasPermission("lambda.vanish.bypass"))) {
                            all.hidePlayer(LambdaEssentials.getInstance(), p)
                        }
                    }
                }
            }else MessageManager.noPermission(p);
        }

        return false
    }
}