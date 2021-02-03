package dev.einsjannis.spigot.menu.inventory

fun ParentPanel.contains(x: Int, y: Int): Boolean =
    this.x <= x && this.y <= y && x < this.x + this.width && y <= this.y + this.height
