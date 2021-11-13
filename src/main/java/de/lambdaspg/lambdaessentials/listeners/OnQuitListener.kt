package de.lambdaspg.lambdaessentials.listeners

import de.lambdaspg.lambdaessentials.LambdaEssentials
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class OnQuitListener : Listener {
    @EventHandler
    fun onQuit(e: PlayerQuitEvent){
        if(LambdaEssentials.vanishlist.contains(e.player)) LambdaEssentials.vanishlist.remove(e.player)
        e.quitMessage = ""
    }
}