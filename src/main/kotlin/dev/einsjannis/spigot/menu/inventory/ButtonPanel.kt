package dev.einsjannis.spigot.menu.inventory

import org.bukkit.inventory.ItemStack

open class ButtonPanel(
    x: Int,
    y: Int,
    parent: ParentPanel,
    item: ItemStack,
    private val _onClick: InventoryMenuContext.(isRightClick: Boolean, isShiftClick: Boolean) -> Unit
) : IconPanel(x, y, parent, item) {
    
    override fun InventoryMenuContext.onClick(
        localX: Int,
        localY: Int,
        isRightClick: Boolean,
        isShiftClick: Boolean
    ): Boolean {
        _onClick(isRightClick, isShiftClick)
        return false
    }
    
}