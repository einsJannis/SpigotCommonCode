package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.spigot.menu.inventory.ParentPanel

class VerticalListPanel(
    override var x: Int,
    override var y: Int,
    override val width: Int,
    override val height: Int,
    override val parent: ParentPanel
) : ListPanel() {
    
    override val originY: Int
        get() = -scroll
    
    override val children: MutableList<VerticalListElementPanel> = mutableListOf()
    
}
