package znick_.msql;

import java.io.File;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.PlayerEvent.LoadFromFile;
import net.minecraftforge.event.entity.player.PlayerEvent.SaveToFile;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import znick_.msql.gui.MSQLGui;
import znick_.msql.storage.StorageUnit;
import znick_.msql.util.ExistingFile;

public class MSQLEventHandler {

	@SubscribeEvent
	public void registerPlayer(EntityConstructing event) {
		WorldData data = WorldData.forWorld(event.entity.worldObj);
		if (event.entity instanceof EntityPlayer && !data.isPlayerRegistered((EntityPlayer) event.entity)) {
			data.registerPlayer((EntityPlayer) event.entity);
		}
	}
	
	@SubscribeEvent
	public void onBlockPlaced(PlaceEvent event) {
		if (event.block instanceof BlockContainer) {
			WorldData data = WorldData.forWorld(event.world);
			data.addStorageUnit(event.player, new StorageUnit(event.world, event.player, event.block, event.x, event.y, event.z));
		}
	}
	
	@SubscribeEvent
	public void onKeyPressed(KeyInputEvent event) {
		if (MSQL.KEY_BIND.isPressed()) {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			player.openGui(MSQL.MOD_ID, MSQLGui.GUI_ID, Minecraft.getMinecraft().theWorld, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
	}
	
	@SubscribeEvent
	public void OnPlayerSave(SaveToFile event) {
		File playerChests = new ExistingFile(event.playerDirectory, "chests", true);
	}
	
	@SubscribeEvent
	public void onPlayerLoad(LoadFromFile event) {
		File playerChests = new ExistingFile(event.playerDirectory, "chests", true);
		for (File file : playerChests.listFiles()) {
			
		}
	}
}
