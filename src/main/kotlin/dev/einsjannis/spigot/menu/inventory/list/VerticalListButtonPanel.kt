package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.spigot.menu.inventory.ButtonPanel
import dev.einsjannis.spigot.menu.inventory.InventoryMenuContext
import org.bukkit.inventory.ItemStack

class VerticalListButtonPanel(
    override val parent: VerticalListPanel,
    item: ItemStack,
    onClick: InventoryMenuContext.(isRightClick: Boolean, isShiftClick: Boolean) -> Unit
) : ButtonPanel(0, 0, parent, item, onClick), VerticalListElementPanel {
    
    override var x: Int
        get() = super<VerticalListElementPanel>.x
        set(value) {
            super<VerticalListElementPanel>.x = value
        }
    override var y: Int
        get() = super<VerticalListElementPanel>.y
        set(value) {
            super<VerticalListElementPanel>.y = value
        }
    
}
