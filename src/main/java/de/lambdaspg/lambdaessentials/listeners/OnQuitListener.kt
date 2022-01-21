package de.lambdaspg.lambdaessentials.listeners

import de.lambdaspg.lambdaessentials.LambdaEssentials
import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class OnQuitListener : Listener {
    @EventHandler
    fun onQuit(e: PlayerQuitEvent){
        if(LambdaEssentials.vanishList.contains(e.player)) {
            LambdaEssentials.vanishList.remove(e.player)
            for(all in Bukkit.getOnlinePlayers()){
                all.showPlayer(LambdaEssentials.getInstance(), e.player)
            }
        }
        if(LambdaEssentials.cmdSpyList.contains(e.player)) LambdaEssentials.cmdSpyList.remove(e.player)
        e.quitMessage = ""
        Bukkit.broadcastMessage("${MessageManager.info}${e.player.name} hat uns verlassen!")
    }
}