package org.bukkit.craftbukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.inventory.CraftInventoryBrewer;
import org.bukkit.inventory.BrewerInventory;

public class CraftBrewingStand extends CraftBlockState implements BrewingStand {
    private final net.minecraft.tileentity.TileEntityBrewingStand brewingStand;

    public CraftBrewingStand(Block block) {
        super(block);

        brewingStand = (net.minecraft.tileentity.TileEntityBrewingStand) ((CraftWorld) block.getWorld()).getTileEntityAt(getX(), getY(), getZ());
    }

    public BrewerInventory getInventory() {
        return new CraftInventoryBrewer(brewingStand);
    }

    @Override
    public boolean update(boolean force) {
        boolean result = super.update(force);

        if (result) {
            brewingStand.func_70296_d();
        }

        return result;
    }

    public int getBrewingTime() {
        return brewingStand.field_70357_b;
    }

    public void setBrewingTime(int brewTime) {
        brewingStand.field_70357_b = brewTime;
    }
}
