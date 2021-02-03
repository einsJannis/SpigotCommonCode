package dev.einsjannis.spigot.menu

import org.bukkit.entity.Player

interface MenuContext {
    
    val menu: Menu
    
    val player: Player
    
}