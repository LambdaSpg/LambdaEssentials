package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class BroadcastCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender.hasPermission("lambda.cmd.broadcast")){
            var message: String = ""
            for(s in args){
                message += " $s"
            }

            Bukkit.broadcastMessage("»")
            Bukkit.broadcastMessage("§c[§4§lBROADCAST§c]: §4$message")
            Bukkit.broadcastMessage("»")
        }else MessageManager.noPermission(sender as Player)
        return false
    }
}