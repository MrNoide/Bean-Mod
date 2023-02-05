package net.santana.bean_mod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.santana.bean_mod.Bean_Mod;

@Mod.EventBusSubscriber(modid = Bean_Mod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab BEANS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        BEANS_TAB = event.registerCreativeModeTab(new ResourceLocation(Bean_Mod.MOD_ID, "beans_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.BLACK_EYED_PEAS.get()))
                        .title(Component.translatable("creativemodetab.beans_tab")));
    }
}
