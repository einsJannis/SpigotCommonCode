package dev.einsjannis.spigot.menu.inventory

import dev.einsjannis.spigot.menu.Menu
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType

open class InventoryMenu(val title: String, val root: RootPanel) : Menu {
    
    private val _contextMap = mutableMapOf<Player, InventoryMenuContext>()
    
    init {
        Menu.eventListenerBuilder.event<InventoryClickEvent> { event ->
            val inventoryMenuContext = _contextMap.values.find { it.inventory == event.inventory } ?: return@event
            val slot = event.slot
            val x = slot % root.width
            val y = slot / root.width
            event.isCancelled = !root.run { inventoryMenuContext.onClick(x, y, event.isRightClick, event.isShiftClick) }
        }
    }
    
    override fun open(player: Player): InventoryMenuContext =
        context(player).also { player.openInventory(it.inventory) }
    
    override fun close(player: Player): Unit =
        context(player).also { if (player.openInventory == it.inventory) player.closeInventory() }
            .let { _contextMap.remove(player) }
    
    override fun context(player: Player): InventoryMenuContext =
        _contextMap[player] ?: run {
            val inventory =
                if (root.type != InventoryType.CHEST)
                    Bukkit.createInventory(player, root.type, title)
                else
                    Bukkit.createInventory(player, root.size, title)
            InventoryMenuContext(this, player, inventory)
        }
    
}
