package dev.einsjannis.spigot.item

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

@DslMarker
annotation class ItemStackDsl

@ItemStackDsl
class ItemStackBuilder(material: Material) {

    val itemStack: ItemStack get() = _itemStack.also { it.itemMeta = itemMeta }

    private var _itemStack: ItemStack = ItemStack(material)
    private var itemMeta: ItemMeta = _itemStack.itemMeta ?: throw RuntimeException("missing item meta")

    var name: String
        get() = itemMeta.displayName
        set(value) = itemMeta.setDisplayName(value)

    var localName: String
        get() = itemMeta.localizedName
        set(value) = itemMeta.setLocalizedName(value)

    var amount: Int
        get() = _itemStack.amount
        set(value) {
            _itemStack.amount = value
        }

    fun lore(loreBuilder: LoreBuilder.() -> Unit) {
        itemMeta.lore = LoreBuilder().also(loreBuilder).list
    }

    fun enchantment(enchantment: Enchantment, level: Int) {
        _itemStack.addUnsafeEnchantment(enchantment, level)
    }

}

@ItemStackDsl
class LoreBuilder {

    internal val list: MutableList<String> = mutableListOf()

    operator fun String.unaryPlus() {
        list += this
    }

}

@ItemStackDsl
fun itemStack(material: Material, builder: ItemStackBuilder.() -> Unit): ItemStack =
    ItemStackBuilder(material).also(builder).itemStack
