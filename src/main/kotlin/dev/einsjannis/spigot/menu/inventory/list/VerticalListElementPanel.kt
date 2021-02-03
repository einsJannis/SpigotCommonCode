package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.move

interface VerticalListElementPanel : ListElementPanel {
    
    override val parent: VerticalListPanel
    
    override var x: Int
        get() = parent.children.indexOf(this) % parent.width
        set(value) {
            val index = parent.children.indexOf(this)
            parent.children.move(index, index - this.x + value)
        }
    
    override var y: Int
        get() = parent.children.indexOf(this) / parent.width
        set(value) {
            val index = parent.children.indexOf(this)
            parent.children.move(index, this.x + value * parent.width)
        }
    
}
