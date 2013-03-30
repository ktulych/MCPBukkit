package org.bukkit.craftbukkit.block;


import org.bukkit.block.Block;
import org.bukkit.block.Beacon;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.inventory.CraftInventory;
import org.bukkit.inventory.Inventory;

public class CraftBeacon extends CraftBlockState implements Beacon {
    private final CraftWorld world;
    private final net.minecraft.tileentity.TileEntityBeacon beacon;

    public CraftBeacon(final Block block) {
        super(block);

        world = (CraftWorld) block.getWorld();
        beacon = (net.minecraft.tileentity.TileEntityBeacon) world.getTileEntityAt(getX(), getY(), getZ());
    }

    public Inventory getInventory() {
        return new CraftInventory(beacon);
    }

    @Override
    public boolean update(boolean force) {
        boolean result = super.update(force);

        if (result) {
            beacon.func_70296_d();
        }

        return result;
    }
}

