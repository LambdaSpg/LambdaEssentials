package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HealCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val p: Player = sender
            if(p.hasPermission("lambda.cmd.heal")){
                p.health = 20.0
                p.saturation = 20F
                MessageManager.sendPlayerGood("Du wurdest geheilt!", p)
            }else {
                MessageManager.noPermission(p)
            }
        }

        return false
    }
}