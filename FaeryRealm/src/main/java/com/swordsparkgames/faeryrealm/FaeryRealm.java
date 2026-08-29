package com.swordsparkgames.faeryrealm;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(FaeryRealm.MOD_ID)
public class FaeryRealm {
    public static final String MOD_ID = "faeryrealm";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<Item> FAERY_DUST = ITEMS.register("faery_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> FAERY_REALM_TAB = CREATIVE_MODE_TABS.register("faery_realm_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.faeryrealm.faery_realm_tab"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .icon(() -> FAERY_DUST.get().getDefaultInstance())
                    .displayItems((parameters, output) -> output.accept(FAERY_DUST.get()))
                    .build());

    public FaeryRealm(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}