package dev.einsjannis.spigot.menu.inventory.list

import dev.einsjannis.spigot.menu.inventory.Panel

interface ListElementPanel : Panel {
    
    override val parent: ListPanel
    
}
