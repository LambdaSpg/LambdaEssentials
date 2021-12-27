package de.lambdaspg.lambdaessentials.listeners

import de.lambdaspg.lambdaessentials.LambdaEssentials
import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class CommandBlocker : Listener {
    @EventHandler
    fun onCommand(e: PlayerCommandPreprocessEvent){

        for(blocked in LambdaEssentials.commandBlockList){
            if(e.message.startsWith(blocked)){
                if(!(e.player.hasPermission("lambda.cmdblocker.bypass"))){
                    MessageManager.sendPlayerError("Dieser Command ist deaktiviert", e.player)
                    e.isCancelled = true
                }
            }
        }

        if(e.message.contains("/") && e.message.contains(":")){
            MessageManager.sendPlayerError("Dieser Command ist deaktiviert", e.player)
            e.isCancelled = true
        }
    }
}