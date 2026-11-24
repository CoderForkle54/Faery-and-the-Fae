package com.sword_sparks.faerie_realm;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FaerieRealm.MODID)
public class FaerieRealm {

    public static final String MODID = "faerie_realm";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // "faerie_realm:sacred_stone" - drops only with the correct tool
    public static final RegistryObject<Block> SACRED_STONE = BLOCKS.register("sacred_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .strength(5.0f, 6.0f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> SACRED_STONE_ITEM = ITEMS.register("sacred_stone",
            () -> new BlockItem(SACRED_STONE.get(), new Item.Properties()));

    public static final RegistryObject<Block> SACRED_COBBLESTONE = BLOCKS.register("sacred_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .strength(3.0f, 4.0f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> SACRED_COBBLESTONE_ITEM = ITEMS.register("sacred_cobblestone",
            () -> new BlockItem(SACRED_COBBLESTONE.get(), new Item.Properties()));

    // "faerie_realm:faery_dust"
    public static final RegistryObject<Item> FAERY_DUST = ITEMS.register("faery_dust",
            () -> new Item(new Item.Properties()));

    // "faerie_realm:faerie_realm_blocks" - placed after the combat tab, icons and entries from our own content
    public static final RegistryObject<CreativeModeTab> FAERIE_REALM_ITEMS = CREATIVE_MODE_TABS.register("faerie_realm_items",
            () -> CreativeModeTab.builder()
                    .icon(() -> FAERY_DUST.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(FAERY_DUST.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> FAERIE_REALM_BLOCKS = CREATIVE_MODE_TABS.register("faerie_realm_blocks",
            () -> CreativeModeTab.builder()
		    .icon(() -> SACRED_STONE_ITEM.get().getDefaultInstance())
		    .displayItems((parameters, output) -> {
		    output.accept(SACRED_STONE_ITEM.get());
                    output.accept(SACRED_COBBLESTONE_ITEM.get());
		})
           .build()); 
    public FaerieRealm(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("[Faerie Realm] Server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("[Faerie Realm] Client setup complete");
        }
    }
}