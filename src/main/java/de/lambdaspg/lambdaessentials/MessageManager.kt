 package de.lambdaspg.lambdaessentials

import org.bukkit.Bukkit.getServer
import org.bukkit.entity.Player

 object MessageManager {
     const val server = "§c§lLegitGames§r"
     const val prefix = "§c§lLegitGames §r§8»"

     const val good = "$prefix§2 "
     const val info = "$prefix§7 "
     const val error = "$prefix§4 "

     fun sendConsoleGood(text: String){
         getServer().consoleSender.sendMessage(good + text)
     }

     fun sendConsoleInfo(text: String){
         getServer().consoleSender.sendMessage(info + text)
     }

     fun sendConsoleError(text: String){
         getServer().consoleSender.sendMessage(error + text)
     }

     fun sendPlayerGood(text: String, player: Player){
         player.sendMessage(good + text)
     }

     fun sendPlayerInfo(text: String, player: Player){
         player.sendMessage(info + text)
     }

     fun sendPlayerError(text: String, player: Player){
         player.sendMessage(error + text)
     }

      fun noPermission(player: Player){
          sendPlayerError("Du darfst diesen Command nicht ausführen", player);
      }
 }