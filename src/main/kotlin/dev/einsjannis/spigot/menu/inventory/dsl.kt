package dev.einsjannis.spigot.menu.inventory

import dev.einsjannis.spigot.menu.inventory.list.*
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.ItemStack

@DslMarker
annotation class PanelDsl

interface PanelBuilder {

    val panel: Panel

}

interface ParentPanelBuilder : PanelBuilder {

    override val panel: ParentPanel

}

interface IContainerPanelBuilder : ParentPanelBuilder {

    @Suppress("UNCHECKED_CAST")
    operator fun Panel.unaryPlus() {
        (panel.children as MutableList<Panel>) += this
    }

    fun item(x: Int, y: Int, item: ItemStack) {
        +ItemPanel(x, y, panel, item)
    }

    fun icon(x: Int, y: Int, item: ItemStack) {
        +IconPanel(x, y, panel, item)
    }

    fun button(
        x: Int,
        y: Int,
        item: ItemStack,
        onClick: InventoryMenuContext.(isRightClick: Boolean, isShiftClick: Boolean) -> Unit
    ) {
        +ButtonPanel(x, y, panel, item, onClick)
    }

    fun list(
        x: Int,
        y: Int,
        width: Int,
        height: Int,
        horizontal: Boolean = false,
        builder: ListPanelBuilder.() -> Unit
    ) {
        +ListPanelBuilder(x, y, width, height, panel, horizontal).also(builder).panel
    }

    fun container(x: Int, y: Int, width: Int, height: Int, builder: ContainerPanelBuilder.() -> Unit) {
        +ContainerPanelBuilder(x, y, width, height, panel).also(builder).panel
    }

}

@PanelDsl
class ContainerPanelBuilder(x: Int, y: Int, width: Int, height: Int, parent: ParentPanel) : IContainerPanelBuilder {

    override val panel = ContainerPanel(x, y, width, height, parent)

}

@PanelDsl
class ListPanelBuilder(x: Int, y: Int, width: Int, height: Int, parent: ParentPanel, val horizontal: Boolean) :
    ParentPanelBuilder {

    override val panel: ListPanel = if (horizontal)
        HorizontalListPanel(x, y, width, height, parent) else VerticalListPanel(x, y, width, height, parent)

    @Suppress("UNCHECKED_CAST")
    operator fun ListElementPanel.unaryPlus() {
        (panel.children as MutableList<ListElementPanel>) += this
    }

    fun item(item: ItemStack) = if (horizontal)
        +HorizontalListItemPanel(
            panel as HorizontalListPanel,
            item
        ) else +VerticalListItemPanel(panel as VerticalListPanel, item)

    fun icon(item: ItemStack) = if (horizontal)
        +HorizontalListIconPanel(
            panel as HorizontalListPanel,
            item
        ) else +VerticalListIconPanel(panel as VerticalListPanel, item)

    fun button(item: ItemStack, onClick: InventoryMenuContext.(isRightClick: Boolean, isShiftClick: Boolean) -> Unit) =
        if (horizontal)
            +HorizontalListButtonPanel(
                panel as HorizontalListPanel,
                item,
                onClick
            ) else +VerticalListButtonPanel(panel as VerticalListPanel, item, onClick)

}

@PanelDsl
class RootPanelBuilder(inventoryType: InventoryType, size: Int? = null) : IContainerPanelBuilder {

    override val panel: RootPanel = RootPanel(inventoryType, size)

}
