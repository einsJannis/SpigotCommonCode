package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.spigot.menu.inventory.ParentPanel

class HorizontalListPanel(
    override var x: Int,
    override var y: Int,
    override val width: Int,
    override val height: Int,
    override val parent: ParentPanel
) : ListPanel() {
    
    override val originX: Int
        get() = -scroll
    
    override val children: MutableList<HorizontalListElementPanel> = mutableListOf()
    
}
