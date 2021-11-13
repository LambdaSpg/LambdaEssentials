package de.lambdaspg.lambdaessentials.commands.teleport

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TeleportHereCommand : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val p: Player = sender;
            if(p.hasPermission("lambda.cmd.tphere")){
                if(args.size == 1){
                    if(Bukkit.getPlayer(args[0]) != null){
                        val target: Player = Bukkit.getPlayer(args[0])!!;
                        target.teleport(p.location)
                        MessageManager.sendPlayerGood("Der Spieler §e${target.name}§2 wurde zu dir teleportiert!", p)
                        MessageManager.sendPlayerInfo("Du wurdest teleportiert!", target)
                    }else {
                        MessageManager.sendPlayerError("Dieser Spieler existiert nicht!", p)
                    }

                }else {
                    MessageManager.sendPlayerError("Bitte verwende /tphere <Spieler>", p)
                }
            }else {
                MessageManager.noPermission(p)
            }
        }
        return false
    }
}