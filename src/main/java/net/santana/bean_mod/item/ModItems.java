package net.santana.bean_mod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.santana.bean_mod.Bean_Mod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Bean_Mod.MOD_ID);

    public static final RegistryObject<Item> BLACK_EYED_PEAS = ITEMS.register("black_eyed_peas",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(1).fast().build())));
    public static final RegistryObject<Item> COOKED_BLACK_EYED_PEAS = ITEMS.register("cooked_black_eyed_peas",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(2).fast().build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
