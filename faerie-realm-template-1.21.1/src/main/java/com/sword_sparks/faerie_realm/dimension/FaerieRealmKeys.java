package com.sword_sparks.faerie_realm.FaerieRealmKeys;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public final class FaerieKeys {
    public static final ResourceKey<Level> FAERIE_DIMENSION =
            ResourceKey.create(Registries.DIMENSION, new ResourceLocation("faerie_realm", "faerie_dimension"));

    private FaerieKeys() {}
}