package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.items;

import java.util.Optional;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.cscorelib2.chat.ChatColors;
import io.github.thebusybiscuit.cscorelib2.math.DoubleHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;

public class Multimeter extends SimpleSlimefunItem<ItemUseHandler> {

	public Multimeter(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
	}

    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
        	Optional<Block> block = e.getClickedBlock();
    		
    		if (block.isPresent()) {
    			Block b = block.get();
    			if (ChargableBlock.isChargable(b)) {
    				e.cancel();
    				
    				Player p = e.getPlayer();
    				p.sendMessage("");
    				p.sendMessage(ChatColors.color("&bStored Energy: &3" + DoubleHandler.getFancyDouble(ChargableBlock.getCharge(b)) + " J"));
    				p.sendMessage(ChatColors.color("&bCapacity: &3" + DoubleHandler.getFancyDouble(ChargableBlock.getMaxCharge(b)) + " J"));
    				p.sendMessage("");
    			}
    		}
        };
    }
}
