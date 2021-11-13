package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class DiscordCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val p: Player = sender;
            if(p.hasPermission("lambda.cmd.discord")){
                MessageManager.sendPlayerInfo("https://discord.gg/FCyKJtqpGK", p)
            }else {
                MessageManager.noPermission(p)
            }
        }
        return false
    }
}