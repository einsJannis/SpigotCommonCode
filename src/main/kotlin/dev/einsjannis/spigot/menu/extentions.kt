package dev.einsjannis.spigot.menu

import org.bukkit.entity.Player

fun Player.openMenu(menu: Menu) = menu.open(this)

fun Player.closeMenu(menu: Menu) = menu.close(this)

fun Player.menuContext(menu: Menu) = menu.context(this)
