package net.swordsparkgames.faeryrealm.init;

import net.swordsparkgames.faeryrealm.item.FaeryRealmItem;
import net.swordsparkgames.faeryrealm.item.FaerieDustItem;
import net.swordsparkgames.faeryrealm.FaeryRealmMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class FaeryRealmModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(FaeryRealmMod.MODID);
	public static final DeferredItem<Item> FAERY_REALM;
	public static final DeferredItem<Item> FAERIE_DUST;
	public static final DeferredItem<Item> SACRED_STONE;
	public static final DeferredItem<Item> ANCIENT_SOIL;
	public static final DeferredItem<Item> SACRED_COBBLESTONE;
	static {
		FAERY_REALM = REGISTRY.register("faery_realm", FaeryRealmItem::new);
		FAERIE_DUST = REGISTRY.register("faerie_dust", FaerieDustItem::new);
		SACRED_STONE = block(FaeryRealmModBlocks.SACRED_STONE, new Item.Properties().rarity(Rarity.UNCOMMON));
		ANCIENT_SOIL = block(FaeryRealmModBlocks.ANCIENT_SOIL);
		SACRED_COBBLESTONE = block(FaeryRealmModBlocks.SACRED_COBBLESTONE);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}