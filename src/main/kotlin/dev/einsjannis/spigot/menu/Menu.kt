package dev.einsjannis.spigot.menu

import dev.einsjannis.spigot.event.EventListenerBuilder
import org.bukkit.entity.Player

interface Menu {

    fun open(player: Player): MenuContext

    fun close(player: Player)

    fun context(player: Player): MenuContext

    companion object {

        val eventListenerBuilder = EventListenerBuilder()

        val eventListener get() = eventListenerBuilder.listener

    }

}
