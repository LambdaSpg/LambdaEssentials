package de.lambdaspg.lambdaessentials

import de.lambdaspg.lambdaessentials.commands.*
import de.lambdaspg.lambdaessentials.commands.teleport.TeleportAllCommand
import de.lambdaspg.lambdaessentials.commands.teleport.TeleportHereCommand
import de.lambdaspg.lambdaessentials.listeners.*
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class LambdaEssentials : JavaPlugin() {

    companion object{
        val commandBlockList = ArrayList<String>()
        val cmdSpyList = ArrayList<Player>()
        val vanishList = ArrayList<Player>()
        lateinit var plugin: LambdaEssentials;

        fun getInstance() : LambdaEssentials{
            return plugin;
        }
    }

    override fun onEnable() {
        plugin = this;
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
        getCommand("vanish")!!.setExecutor(VanishCommand())
        getCommand("i")!!.setExecutor(ICommand())
        getCommand("message")!!.setExecutor(MessageCommand())

        server.pluginManager.registerEvents(CommandSpyListener(), this)
        server.pluginManager.registerEvents(OnQuitListener(), this)
        server.pluginManager.registerEvents(CommandBlocker(), this)
        server.pluginManager.registerEvents(OnJoinListener(), this)

        initializeLists()
    }

    private fun initializeLists() {
        commandBlockList.add("/me")
        commandBlockList.add("/pl")
        commandBlockList.add("/?")
        commandBlockList.add("/mv ^(.........................*.++)\$^")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }



}