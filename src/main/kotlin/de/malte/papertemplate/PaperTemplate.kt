package de.malte.papertemplate

import org.bukkit.plugin.java.JavaPlugin

class PaperTemplate : JavaPlugin() {
    override fun onEnable() {
        plugin = this;
    }

    override fun onDisable() {

    }

    companion object {
        var plugin: PaperTemplate? = null;
        val instance: PaperTemplate
            get() {
                return plugin!!
            }
    }
}