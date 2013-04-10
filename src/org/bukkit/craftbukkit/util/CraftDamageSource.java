package org.bukkit.craftbukkit.util;


// Util class to create custom DamageSources.
public final class CraftDamageSource extends net.minecraft.util.DamageSource {
    public static net.minecraft.util.DamageSource copyOf(final net.minecraft.util.DamageSource original) {
        CraftDamageSource newSource = new CraftDamageSource(original.field_76373_n);

        // Check ignoresArmor
        if (original.func_76363_c()) {
            newSource.func_76348_h();
        }

        // Check magic
        if (original.func_82725_o()) {
            newSource.func_82726_p();
        }

        // Check fire
        if (original.func_94541_c()) {
            newSource.func_76361_j();
        }

        return newSource;
    }

    private CraftDamageSource(String identifier) {
        super(identifier);
    }
}
