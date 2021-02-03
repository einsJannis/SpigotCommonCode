package dev.einsjannis.spigot.menu

import dev.einsjannis.spigot.menu.inventory.InventoryMenu
import dev.einsjannis.spigot.menu.inventory.RootPanel
import dev.einsjannis.spigot.menu.inventory.RootPanelBuilder
import org.bukkit.event.inventory.InventoryType

@DslMarker
annotation class MenuDsl

@MenuDsl
fun menu(
    inventoryType: InventoryType,
    title: String,
    size: Int? = null,
    builder: RootPanelBuilder.() -> Unit
): InventoryMenu {
    val root: RootPanel = RootPanelBuilder(inventoryType, size).also(builder).panel
    return InventoryMenu(title, root)
}
