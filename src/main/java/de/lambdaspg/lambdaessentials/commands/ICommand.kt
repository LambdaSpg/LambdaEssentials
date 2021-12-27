package de.lambdaspg.lambdaessentials.commands

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.*

class ICommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val p: Player = sender;
            if(p.hasPermission("lambda.cmd.i")){
                if(args.size == 1){
                    val mat: Material? = Material.getMaterial(args[0].uppercase())

                    if(mat != null){
                        p.inventory.addItem(ItemStack(mat, 64))
                    }else {
                        MessageManager.sendPlayerError("Bitte verwende /i item", p)
                    }
                }else {
                    MessageManager.sendPlayerError("Bitte verwende /i item", p)
                }
            } else MessageManager.noPermission(p)
        }

        return false;
    }
}