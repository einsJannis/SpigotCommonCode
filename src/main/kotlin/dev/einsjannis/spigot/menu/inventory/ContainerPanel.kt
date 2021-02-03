package dev.einsjannis.spigot.menu.inventory

class ContainerPanel(
    override var x: Int,
    override var y: Int,
    override val width: Int,
    override val height: Int,
    override val parent: ParentPanel
) : ParentPanel {
    
    override val children: MutableList<out Panel> = mutableListOf()
    
    override var originX: Int = 0
    
    override var originY: Int = 0
    
}
