/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.swordsparkgames.faeryrealm.init;

import net.swordsparkgames.faeryrealm.FaeryRealmMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class FaeryRealmModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FaeryRealmMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FAERY_REALM_ITEMS = REGISTRY.register("faery_realm_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.faery_realm.faery_realm_items")).icon(() -> new ItemStack(FaeryRealmModItems.FAERY_REALM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(FaeryRealmModItems.FAERY_REALM.get());
				tabData.accept(FaeryRealmModItems.FAERIE_DUST.get());
			}).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FAERY_REALM_BLOCKS = REGISTRY.register("faery_realm_blocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.faery_realm.faery_realm_blocks")).icon(() -> new ItemStack(FaeryRealmModBlocks.SACRED_STONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(FaeryRealmModBlocks.SACRED_STONE.get().asItem());
			}).withTabsBefore(FAERY_REALM_ITEMS.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(FaeryRealmModItems.FAERY_REALM.get());
			tabData.accept(FaeryRealmModItems.FAERIE_DUST.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(FaeryRealmModItems.FAERIE_DUST.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(FaeryRealmModBlocks.SACRED_STONE.get().asItem());
		}
	}
}