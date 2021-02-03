package dev.einsjannis.spigot.menu.inventory

import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.ItemStack

open class RootPanel(val type: InventoryType, size: Int?) : ParentPanel {

    val size = size ?: type.defaultSize

    override var x: Int = 0

    override var y: Int = 0

    override val height: Int
        get() = when (type) {
            InventoryType.CHEST       -> if (size == 6 * 9) 6 else 3
            InventoryType.DROPPER     -> 3
            InventoryType.DISPENSER   -> 3
            InventoryType.HOPPER      -> 1
            InventoryType.ENDER_CHEST -> 3
            InventoryType.BARREL      -> 3
            else                      -> throw IllegalArgumentException("illegal inventory type")
        }

    override val width: Int
        get() = when (type) {
            InventoryType.CHEST       -> 6
            InventoryType.DROPPER     -> 3
            InventoryType.DISPENSER   -> 3
            InventoryType.HOPPER      -> 5
            InventoryType.ENDER_CHEST -> 6
            InventoryType.BARREL      -> 6
            else                      -> throw IllegalArgumentException("illegal inventory type")
        }

    override val children: MutableList<Panel> = mutableListOf()

    override val parent: ParentPanel? = null

    override fun InventoryMenuContext.drawIcon(localX: Int, localY: Int, itemStack: ItemStack) =
        inventory.setItem(localX + localY * width, itemStack)

}
