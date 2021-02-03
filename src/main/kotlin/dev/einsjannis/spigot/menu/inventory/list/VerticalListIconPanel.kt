package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.spigot.menu.inventory.IconPanel
import org.bukkit.inventory.ItemStack

class VerticalListIconPanel(
    override val parent: VerticalListPanel,
    item: ItemStack
) : IconPanel(0, 0, parent, item), VerticalListElementPanel {
    
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
