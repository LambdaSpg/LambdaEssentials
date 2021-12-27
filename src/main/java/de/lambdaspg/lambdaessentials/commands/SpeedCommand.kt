package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SpeedCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val player: Player = sender

            if(player.hasPermission("lambda.cmd.speed")){
                if(args.size == 1){

                    val speed: Int = try {
                        args[0].toInt()
                    } catch (e: NumberFormatException) {
                        MessageManager.sendPlayerError("Bitte verwende /speed 1-9", player)
                        return false
                    }

                    if(speed in 1..9){
                        player.flySpeed = (speed.toFloat() / 10);
                        player.walkSpeed = (speed.toFloat() / 10) + 0.1f;
                    }else {
                        MessageManager.sendPlayerError("Bitte verwende /speed 1-9", player)
                    }

                }else {
                    MessageManager.sendPlayerError("Bitte verwende /speed 1-9", player)
                }
            }else {
                MessageManager.noPermission(player)
            }
        }

        return false;
    }

}