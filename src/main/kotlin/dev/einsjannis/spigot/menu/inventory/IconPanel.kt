package dev.einsjannis.spigot.menu.inventory

import org.bukkit.inventory.ItemStack

open class IconPanel(
    x: Int,
    y: Int,
    parent: ParentPanel,
    item: ItemStack
) : ItemPanel(x, y, parent, item) {
    
    override fun InventoryMenuContext.onClick(
        localX: Int,
        localY: Int,
        isRightClick: Boolean,
        isShiftClick: Boolean
    ): Boolean = false
    
    override fun InventoryMenuContext.draw() {
        drawIcon(0, 0, item)
    }
    
}
