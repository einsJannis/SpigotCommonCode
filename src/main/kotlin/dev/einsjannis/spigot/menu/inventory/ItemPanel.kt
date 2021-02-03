package dev.einsjannis.spigot.menu.inventory

import org.bukkit.inventory.ItemStack

open class ItemPanel(
    override var x: Int,
    override var y: Int,
    override val parent: ParentPanel,
    val item: ItemStack
) : Panel {
    
    override fun InventoryMenuContext.onClick(
        localX: Int,
        localY: Int,
        isRightClick: Boolean,
        isShiftClick: Boolean
    ): Boolean {
        parent.children.remove(this@ItemPanel)
        return true
    }
    
    override fun InventoryMenuContext.draw() {
        drawIcon(0, 0, item)
    }
    
}
