package net.santana.bean_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.santana.bean_mod.block.ModBlocks;
import net.santana.bean_mod.item.ModCreativeModeTab;
import net.santana.bean_mod.item.ModItems;
import org.slf4j.Logger;

@Mod(Bean_Mod.MOD_ID)
public class Bean_Mod {
    public static final String MOD_ID = "bean_mod";
    private static final Logger LOGGER = LogUtils.getLogger();



    public Bean_Mod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTab.BEANS_TAB){
            event.accept(ModItems.BLACK_EYED_PEAS);
            event.accept(ModItems.COOKED_BLACK_EYED_PEAS);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_EYED_PEAS_CROP.get(), RenderType.cutout());

        }
    }
}
