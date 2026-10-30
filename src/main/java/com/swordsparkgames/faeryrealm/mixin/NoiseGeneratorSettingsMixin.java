package net.swordsparkgames.faeryrealm.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.swordsparkgames.faeryrealm.init.FaeryRealmModBiomes;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements FaeryRealmModBiomes.FaeryRealmModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> faery_realm_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.faery_realm_dimensionTypeReference != null) {
			retval = FaeryRealmModBiomes.adaptSurfaceRule(retval, this.faery_realm_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setfaery_realmDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.faery_realm_dimensionTypeReference = dimensionType;
	}
}