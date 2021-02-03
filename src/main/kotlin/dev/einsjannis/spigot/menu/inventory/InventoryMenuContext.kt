package dev.einsjannis.spigot.menu.inventory

import dev.einsjannis.spigot.menu.Menu
import dev.einsjannis.spigot.menu.MenuContext
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

data class InventoryMenuContext(
    override val menu: Menu,
    override val player: Player,
    val inventory: Inventory
) : MenuContext
