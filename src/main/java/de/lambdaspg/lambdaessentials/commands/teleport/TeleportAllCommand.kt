package de.lambdaspg.lambdaessentials.commands.teleport

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TeleportAllCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val p: Player = sender;
            if(p.hasPermission("lambda.cmd.tpall")){
                for(all in Bukkit.getOnlinePlayers()){
                    all.teleport(p.location)
                }
                MessageManager.sendPlayerGood("Alle spieler wurden zu dir teleportiert", p)
            }else MessageManager.noPermission(p)
        }

        return false
    }
}