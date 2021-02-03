package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.move

interface HorizontalListElementPanel : ListElementPanel {
    
    override val parent: HorizontalListPanel
    
    override var x: Int
        get() = parent.children.indexOf(this) / parent.height
        set(value) {
            val index = parent.children.indexOf(this)
            parent.children.move(index, this.y + value * parent.height)
        }
    
    override var y: Int
        get() = parent.children.indexOf(this) % parent.height
        set(value) {
            val index = parent.children.indexOf(this)
            parent.children.move(index, index - this.y + value)
        }
    
}
