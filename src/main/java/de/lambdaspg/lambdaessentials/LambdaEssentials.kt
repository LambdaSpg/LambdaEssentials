package de.lambdaspg.lambdaessentials

import de.lambdaspg.lambdaessentials.commands.*
import de.lambdaspg.lambdaessentials.commands.teleport.TeleportAllCommand
import de.lambdaspg.lambdaessentials.commands.teleport.TeleportHereCommand
import de.lambdaspg.lambdaessentials.listeners.*
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class LambdaEssentials : JavaPlugin() {

    companion object{
        val commandblocklist = ArrayList<String>()
        val vanishlist = ArrayList<Player>()
        val unblockedcommands = ArrayList<String>()
    }

    override fun onEnable() {
        getCommand("gm")!!.setExecutor(GamemodeCommand())
        getCommand("heal")!!.setExecutor(HealCommand())
        getCommand("fly")!!.setExecutor(FlyCommand())
        getCommand("commandspy")!!.setExecutor(CommandSpyCommand())
        getCommand("speed")!!.setExecutor(SpeedCommand())
        getCommand("enderchest")!!.setExecutor(EnderChestcommand())
        getCommand("broadcast")!!.setExecutor(BroadcastCommand())
        getCommand("tphere")!!.setExecutor(TeleportHereCommand())
        getCommand("tpall")!!.setExecutor(TeleportAllCommand())
        getCommand("discord")!!.setExecutor(DiscordCommand())

        server.pluginManager.registerEvents(CommandSpyListener(), this)
        server.pluginManager.registerEvents(OnQuitListener(), this)
        server.pluginManager.registerEvents(CommandBlocker(), this)
        server.pluginManager.registerEvents(CustomCommandsListener(), this)
        server.pluginManager.registerEvents(OnJoinListener(), this)
        //server.pluginManager.registerEvents(OnTabListener(), this)

        registerLists()

        //TODO: enable message / disable message and add unblockedCommands
    }

    private fun registerLists() {
        commandblocklist.add("/me")
        commandblocklist.add("/pl")
        commandblocklist.add("/?")
        commandblocklist.add("/mv ^(.........................*.++)\$^")

        //unblockedcommands.add("lambdaessentials:discord")
        //unblockedcommands.add("lambdaessentials:fly")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }



}