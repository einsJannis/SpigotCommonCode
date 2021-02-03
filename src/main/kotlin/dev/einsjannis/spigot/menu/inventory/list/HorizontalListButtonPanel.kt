package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.spigot.menu.inventory.ButtonPanel
import dev.einsjannis.spigot.menu.inventory.InventoryMenuContext
import org.bukkit.inventory.ItemStack

class HorizontalListButtonPanel(
    override val parent: HorizontalListPanel,
    item: ItemStack,
    onClick: InventoryMenuContext.(isRightClick: Boolean, isShiftClick: Boolean) -> Unit
) : ButtonPanel(0, 0, parent, item, onClick), HorizontalListElementPanel {
    
    override var x: Int
        get() = super<HorizontalListElementPanel>.x
        set(value) {
            super<HorizontalListElementPanel>.x = value
        }
    override var y: Int
        get() = super<HorizontalListElementPanel>.y
        set(value) {
            super<HorizontalListElementPanel>.y = value
        }
    
}
