package org.bukkit.craftbukkit.entity;


import org.apache.commons.lang.Validate;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fish;
import org.bukkit.entity.LivingEntity;

public class CraftFish extends AbstractProjectile implements Fish {
    private double biteChance = -1;

    public CraftFish(CraftServer server, net.minecraft.entity.projectile.EntityFishHook entity) {
        super(server, entity);
    }

    public LivingEntity getShooter() {
        if (getHandle().field_70204_b != null) {
            return getHandle().field_70204_b.getBukkitEntity();
        }

        return null;
    }

    public void setShooter(LivingEntity shooter) {
        if (shooter instanceof CraftHumanEntity) {
            getHandle().field_70204_b = (net.minecraft.entity.player.EntityPlayer) ((CraftHumanEntity) shooter).entity;
        }
    }

    @Override
    public net.minecraft.entity.projectile.EntityFishHook getHandle() {
        return (net.minecraft.entity.projectile.EntityFishHook) entity;
    }

    @Override
    public String toString() {
        return "CraftFish";
    }

    public EntityType getType() {
        return EntityType.FISHING_HOOK;
    }

    public double getBiteChance() {
        net.minecraft.entity.projectile.EntityFishHook hook = getHandle();

        if (this.biteChance == -1) {
            if (hook.field_70170_p.func_72951_B(net.minecraft.util.MathHelper.func_76128_c(hook.field_70165_t), net.minecraft.util.MathHelper.func_76128_c(hook.field_70163_u) + 1, net.minecraft.util.MathHelper.func_76128_c(hook.field_70161_v))) {
                return 1/300.0;
            }
            return 1/500.0;
        }
        return this.biteChance;
    }

    public void setBiteChance(double chance) {
        Validate.isTrue(chance >= 0 && chance <= 1, "The bite chance must be between 0 and 1.");
        this.biteChance = chance;
    }
}
