// This class provides mod infrastructure and 
// defines two new recipes to craft the 43:6 
// double-halfslab block. 
// Author: dvanclev

package com.untamedears.MoreCraftableBlocks;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ShapelessRecipe;


public class MoreCraftableBlocks extends JavaPlugin {

    public static Logger log;
    public static String pluginName = "MoreCraftableBlocks";
    public static String version = "0.1.2";
    
    public void onEnable() {
		log = this.getLogger();
        getServer().getPluginManager().registerEvents(new ItemCraftListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(this), this);
        
        ItemStack result = new ItemStack(Material.BOOK_AND_QUILL);

        addShapelessRecipe(result, new Material[] {
                Material.WRITTEN_BOOK,
                Material.BOOK_AND_QUILL
        });
        
		ShapedRecipe stoneToDoubleSlab = new ShapedRecipe(new ItemStack(43, 6, (short) 0, (byte) 6));
		stoneToDoubleSlab.shape("sss", "sss").setIngredient('s', Material.STONE);
		Bukkit.addRecipe(stoneToDoubleSlab);
		
		ShapedRecipe slabToDoubleSlab = new ShapedRecipe(new ItemStack(43, 1, (short) 0, (byte) 6));
		slabToDoubleSlab.shape("s", "s").setIngredient('s', Material.getMaterial(44));
		Bukkit.addRecipe(slabToDoubleSlab);
		
		log.info(pluginName+" v"+version+" enabled!");
	}
	
	public void onDisable() {
		log.info(pluginName+" v"+version+" disabled!");
	}
	
    private void addShapelessRecipe(ItemStack result, Material[] materials) {
        ShapelessRecipe recipe = new ShapelessRecipe(result);
        for (Material material : materials)
            recipe.addIngredient(material);
        getServer().addRecipe(recipe);
    }
    
}
