package net.seichi915.seichi915bungeelogger.api

import com.google.common.io.ByteStreams
import net.md_5.bungee.api.connection.{ProxiedPlayer, Server}

@SuppressWarnings(Array[String]("UnstableApiUsage"))
class Seichi915BungeeLoggerAPI {
  def info(server: Server, message: String): Unit = {
    val byteArrayDataOutput = ByteStreams.newDataOutput()
    byteArrayDataOutput.writeUTF("Seichi915BungeeLogger-INFO")
    byteArrayDataOutput.writeUTF(message)
    server.sendData("BungeeCord", byteArrayDataOutput.toByteArray)
  }

  def warning(server: Server, message: String): Unit = {
    val byteArrayDataOutput = ByteStreams.newDataOutput()
    byteArrayDataOutput.writeUTF("Seichi915BungeeLogger-WARN")
    byteArrayDataOutput.writeUTF(message)
    server.sendData("BungeeCord", byteArrayDataOutput.toByteArray)
  }

  def severe(server: Server, message: String): Unit = {
    val byteArrayDataOutput = ByteStreams.newDataOutput()
    byteArrayDataOutput.writeUTF("Seichi915BungeeLogger-SEVERE")
    byteArrayDataOutput.writeUTF(message)
    server.sendData("BungeeCord", byteArrayDataOutput.toByteArray)
  }

  def logProxyCommand(server: Server,
                      proxiedPlayer: ProxiedPlayer,
                      command: String): Unit = {
    val byteArrayDataOutput = ByteStreams.newDataOutput()
    byteArrayDataOutput.writeUTF("Seichi915BungeeLogger-INFO")
    byteArrayDataOutput.writeUTF(
      s"${proxiedPlayer.getName} issued proxy command: $command")
    server.sendData("BungeeCord", byteArrayDataOutput.toByteArray)
  }
}
