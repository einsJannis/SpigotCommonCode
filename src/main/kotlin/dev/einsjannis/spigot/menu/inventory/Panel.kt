package dev.einsjannis.spigot.menu.inventory

import org.bukkit.inventory.ItemStack

interface Panel {
    
    val originX: Int get() = 0
    
    val originY: Int get() = 0
    
    var x: Int
    
    var y: Int
    
    val width: Int get() = 1
    
    val height: Int get() = 1
    
    val parent: ParentPanel?
    
    val children: List<Panel> get() = emptyList()
    
    fun InventoryMenuContext.onClick(localX: Int, localY: Int, isRightClick: Boolean, isShiftClick: Boolean): Boolean
    
    fun InventoryMenuContext.drawIcon(localX: Int, localY: Int, itemStack: ItemStack): Unit =
        parent?.run { this@drawIcon.drawIcon(localX + x + originX, localY + y + originY, itemStack) } ?: Unit
    
    fun InventoryMenuContext.draw(): Unit =
        children.forEach { it.run { draw() } }
    
}
