package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class InvseeCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            val p: Player = sender
            if (p.hasPermission("lambda.cmd.invsee")) {
                if(args.size == 1){
                    if(Bukkit.getPlayer(args[0]) != null){

                    }else {

                    }
                }else MessageManager.sendPlayerError("Bitte verwende /invsee player", p)
            }
        }
    }
}