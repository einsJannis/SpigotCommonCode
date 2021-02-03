package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.spigot.menu.inventory.ParentPanel

abstract class ListPanel : ParentPanel {
    
    override val children: MutableList<out ListElementPanel> = mutableListOf()
    
    var scroll: Int = 0
    
}
