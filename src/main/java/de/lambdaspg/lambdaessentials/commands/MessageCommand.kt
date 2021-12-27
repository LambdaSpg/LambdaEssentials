package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MessageCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val p: Player = sender
            if(p.hasPermission("lambda.cmd.message")){
                if(args.size >= 2){
                    val target: Player? = Bukkit.getPlayer(args[0])
                    if(target != null){
                        var msg: String = ""
                        for (i in args.indices){
                            if(i > 0){
                                msg += " " + args[i]
                            }
                        }

                        target.sendMessage("${ChatColor.BLUE}[${p.name}]${ChatColor.WHITE} -> ${ChatColor.BLUE} You ${ChatColor.GRAY}|$msg")
                        p.sendMessage("${ChatColor.BLUE}You ${ChatColor.WHITE} -> ${ChatColor.BLUE} [${target.name}] ${ChatColor.GRAY} |$msg")
                    }else MessageManager.sendPlayerError("Dieser Spieler existiert nicht", p)
                }else MessageManager.sendPlayerError("Bitte verwende /msg Spieler Text", p)
            }else {
                MessageManager.noPermission(p)
            }
        }
        return false;
    }
}