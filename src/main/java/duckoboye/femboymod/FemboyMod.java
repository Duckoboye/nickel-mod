package duckoboye.femboymod;

import duckoboye.femboymod.lists.ItemList;
import duckoboye.femboymod.lists.ToolMaterialList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// This is the mod id. It must be the same as the one in mods.toml.
@Mod("femboymod")
public class FemboyMod {
    public static FemboyMod INSTANCE;
    public static final String MODID = "femboymod";
    private static final Logger LOGGER = LogManager.getLogger(MODID);

    public FemboyMod() {
        INSTANCE = this;
        // We need to call these two functions to make sure that setup and clientRegistries are called
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        // It tells to Forge that this mod exists!
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Hello from commonSetup!");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Hello from clientSetup!");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    ItemList.nickel = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("nickel")),
                    ItemList.femboy_sword = new SwordItem(ToolMaterialList.femboy_sword, 4, -3, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("femboy_sword"))
            );
        }

        private static ResourceLocation location(String name) {
            return new ResourceLocation(MODID, name);
        }
    }
}