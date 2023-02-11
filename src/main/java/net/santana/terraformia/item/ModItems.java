package net.santana.terraformia.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.santana.terraformia.Terraformia;
import net.santana.terraformia.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Terraformia.MOD_ID);

    public static final RegistryObject<Item> BLACK_EYED_PEAS = ITEMS.register("black_eyed_peas",
            () -> new ItemNameBlockItem(ModBlocks.BLACK_EYED_PEAS_CROP.get(),
                    new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(1).fast().build())));
    public static final RegistryObject<Item> COOKED_BLACK_EYED_PEAS = ITEMS.register("cooked_black_eyed_peas",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(1).fast().build())));
    public static final RegistryObject<Item> BLACK_EYED_PEAS_POD = ITEMS.register("black_eyed_peas_pod",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
