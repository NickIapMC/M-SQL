package znick_.msql;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import znick_.msql.gui.GuiHandler;

@Mod(
	modid = MSQL.MOD_ID,
	name = MSQL.MOD_NAME, 
	version = MSQL.VERSION
)
public class MSQL {
	
	@Instance
	public static MSQL instance;
	
	public static final String MOD_ID = "msql";
	public static final String MOD_NAME = "M-SQL";
	public static final String VERSION = "0.001";
	
	public static final KeyBinding KEY_BIND = new KeyBinding("key.msql.desc", Keyboard.KEY_COLON, "key.msql.cateogry");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MSQLEventHandler events = new MSQLEventHandler();
		MinecraftForge.EVENT_BUS.register(events);
		FMLCommonHandler.instance().bus().register(events);
		ClientRegistry.registerKeyBinding(KEY_BIND);
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}