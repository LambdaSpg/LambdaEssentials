package de.lambdaspg.lambdaessentials.listeners

import de.lambdaspg.lambdaessentials.LambdaEssentials
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandSendEvent

class OnTabListener : Listener {

    @EventHandler
    fun onTab(e: PlayerCommandSendEvent){
        //if(e.player.hasPermission("lambda.cmdblocker.bypass")) return;

        var unblocked: List<String> = LambdaEssentials.unblockedcommands

        unblocked.forEach { s ->
            println(s)

        }

        var toblock = e.commands

        toblock.removeAll(unblocked.toSet())

        e.commands.removeAll(toblock.toSet())
    }
}