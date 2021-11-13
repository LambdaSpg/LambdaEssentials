package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GamemodeCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val player: Player = sender

            if(player.hasPermission("lambda.cmd.gm")){
                if(args.size == 1){

                    val mode: Int = try {
                        args[0].toInt()
                    } catch (e: NumberFormatException) {
                        return false
                    }

                    var gameMode: GameMode? = null

                    when (mode) {
                        0 ->{
                            gameMode = GameMode.SURVIVAL
                            MessageManager.sendPlayerInfo("Du bist nun im §aSURVIVAL§e mode!", player)
                        }
                        1 -> {
                            gameMode = GameMode.CREATIVE
                            MessageManager.sendPlayerInfo("Du bist nun im §aCREATIVE§e mode!", player)
                        }
                        2 -> {
                            gameMode = GameMode.ADVENTURE
                            MessageManager.sendPlayerInfo("Du bist nun im §aADVENTURE§e mode!", player)
                        }
                        3 -> {
                            gameMode = GameMode.SPECTATOR
                            MessageManager.sendPlayerInfo("Du bist nun im §aSPECTATOR§e mode!", player)
                        }
                        else ->{
                            MessageManager.sendPlayerError("Bitte verwende /gm <0/1/2/3>", player)
                            return false;
                        }
                    }

                    player.gameMode = gameMode;

                }else {
                    MessageManager.sendPlayerError("Bitte verwende /gm <0/1/2/3>", player)
                }
            }else {
                MessageManager.noPermission(player)
            }
        }

        return false;
    }
}