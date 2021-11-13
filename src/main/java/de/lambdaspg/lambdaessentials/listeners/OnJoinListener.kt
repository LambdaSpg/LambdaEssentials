package de.lambdaspg.lambdaessentials.listeners

import de.lambdaspg.lambdaessentials.MessageManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class OnJoinListener : Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent){
        e.joinMessage = ""
        MessageManager.sendPlayerInfo("Willkommen auf LegitGames!", e.player)
    }
}