/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.swordsparkgames.faeryrealm.init;

import net.swordsparkgames.faeryrealm.block.SacredStoneBlock;
import net.swordsparkgames.faeryrealm.block.SacredCobblestoneBlock;
import net.swordsparkgames.faeryrealm.block.FaeryRealmPortalBlock;
import net.swordsparkgames.faeryrealm.block.AncientSoilBlock;
import net.swordsparkgames.faeryrealm.FaeryRealmMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

public class FaeryRealmModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(FaeryRealmMod.MODID);
	public static final DeferredBlock<Block> FAERY_REALM_PORTAL;
	public static final DeferredBlock<Block> SACRED_STONE;
	public static final DeferredBlock<Block> ANCIENT_SOIL;
	public static final DeferredBlock<Block> SACRED_COBBLESTONE;
	static {
		FAERY_REALM_PORTAL = REGISTRY.register("faery_realm_portal", FaeryRealmPortalBlock::new);
		SACRED_STONE = REGISTRY.register("sacred_stone", SacredStoneBlock::new);
		ANCIENT_SOIL = REGISTRY.register("ancient_soil", AncientSoilBlock::new);
		SACRED_COBBLESTONE = REGISTRY.register("sacred_cobblestone", SacredCobblestoneBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}