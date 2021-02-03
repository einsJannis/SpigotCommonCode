package dev.einsjannis.spigot.event

import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class EventListenerBuilder {

    private val eventHandlers: MutableMap<Class<out Event>, (Event) -> Unit> = mutableMapOf()

    val listener: Listener
        get() = object : Listener {
            @EventHandler
            fun handleEvents(event: Event) {
                eventHandlers.forEach { if (it.key.isInstance(event)) it.value.invoke(event) }
            }
        }

    @Suppress("UNCHECKED_CAST")
    fun <T : Event> event(klass: Class<T>, handler: (T) -> Unit) {
        eventHandlers[klass] = handler as (Event) -> Unit
    }

    inline fun <reified T : Event> event(noinline handler: (T) -> Unit) {
        event(T::class.java, handler)
    }

}

fun eventListener(builder: EventListenerBuilder.() -> Unit): Listener =
    EventListenerBuilder().also(builder).listener
