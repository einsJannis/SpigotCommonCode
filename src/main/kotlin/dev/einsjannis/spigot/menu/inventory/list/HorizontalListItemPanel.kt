package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.spigot.menu.inventory.ItemPanel
import org.bukkit.inventory.ItemStack

class HorizontalListItemPanel(override val parent: HorizontalListPanel, item: ItemStack) :
    ItemPanel(0, 0, parent, item), HorizontalListElementPanel {

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
