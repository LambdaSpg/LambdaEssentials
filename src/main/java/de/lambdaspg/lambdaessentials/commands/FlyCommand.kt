package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import de.lambdaspg.lambdaessentials.MessageManager.sendPlayerInfo
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FlyCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val p: Player = sender
            if(p.hasPermission("lambda.cmd.fly")){
                sendPlayerInfo("Du kannst nun" + if (p.allowFlight) " nicht mehr fliegen!" else " fliegen!", p)
                p.isFlying = false
                p.allowFlight = !p.allowFlight;
            }else {
                MessageManager.noPermission(p)
            }
        }

        return false
    }
}