package de.lambdaspg.lambdaessentials.listeners

import de.lambdaspg.lambdaessentials.LambdaEssentials
import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class CommandSpyListener : Listener {
    @EventHandler
    fun onCommand(e: PlayerCommandPreprocessEvent){
        for(s in LambdaEssentials.cmdSpyList){
            if(e.player.name != s.name){
                s.sendMessage(MessageManager.prefix + " §6CommandSpy ${e.player.name} |§e ${e.message}")
            }
        }
    }
}