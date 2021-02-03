package dev.einsjannis.spigot.menu.inventory

interface ParentPanel : Panel {
    
    override val children: MutableList<out Panel>
    
    override fun InventoryMenuContext.onClick(
        localX: Int,
        localY: Int,
        isRightClick: Boolean,
        isShiftClick: Boolean
    ): Boolean {
        var result = true
        children.find {
            if (it is ParentPanel) it.contains(localX, localY) else false
        }?.let {
            val x = localX - it.x
            val y = localY - it.y
            result = if (!it.run { onClick(x, y, isRightClick, isShiftClick) }) false else result
        }
        return result
    }
    
}