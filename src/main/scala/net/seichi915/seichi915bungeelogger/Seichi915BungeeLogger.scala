package net.seichi915.seichi915bungeelogger

import net.seichi915.seichi915bungeelogger.api.Seichi915BungeeLoggerAPI
import net.seichi915.seichi915bungeelogger.listener.PluginMessageListener
import org.bukkit.plugin.java.JavaPlugin

object Seichi915BungeeLogger {
  var instance: Seichi915BungeeLogger = _

  def getAPI: Seichi915BungeeLoggerAPI = new Seichi915BungeeLoggerAPI
}

class Seichi915BungeeLogger extends JavaPlugin {
  Seichi915BungeeLogger.instance = this

  override def onEnable(): Unit = {
    getServer.getMessenger.registerOutgoingPluginChannel(
      Seichi915BungeeLogger.instance,
      "BungeeCord")
    getServer.getMessenger.registerIncomingPluginChannel(
      Seichi915BungeeLogger.instance,
      "BungeeCord",
      new PluginMessageListener)

    getLogger.info("seichi915BungeeLoggerが有効になりました。")
  }

  override def onDisable(): Unit = {
    getLogger.info("seichi915BungeeLoggerが無効になりました。")
  }
}
