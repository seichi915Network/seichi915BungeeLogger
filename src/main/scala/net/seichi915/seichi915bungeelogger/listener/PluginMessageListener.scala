package net.seichi915.seichi915bungeelogger.listener

import com.google.common.io.ByteStreams
import net.seichi915.seichi915bungeelogger.Seichi915BungeeLogger
import org.bukkit.entity.Player

class PluginMessageListener
    extends org.bukkit.plugin.messaging.PluginMessageListener {
  @SuppressWarnings(Array[String]("UnstableApiUsage"))
  override def onPluginMessageReceived(channelName: String,
                                       player: Player,
                                       message: Array[Byte]): Unit = {
    if (!channelName.equalsIgnoreCase("BungeeCord")) return
    val byteArrayDataInput = ByteStreams.newDataInput(message)
    val subChannel = byteArrayDataInput.readUTF()
    val msg = byteArrayDataInput.readUTF()
    subChannel match {
      case "Seichi915BungeeLogger-INFO" =>
        Seichi915BungeeLogger.instance.getServer.getLogger.info(msg)
      case "Seichi915BungeeLogger-WARN" =>
        Seichi915BungeeLogger.instance.getServer.getLogger.warning(msg)
      case "Seichi915BungeeLogger-SEVERE" =>
        Seichi915BungeeLogger.instance.getServer.getLogger.severe(msg)
      case _ =>
    }
  }
}
