package znick_.msql.gui;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	
	private static final Map<Integer, Class<? extends Gui>> CLIENT_GUIS = new HashMap<>();
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		try {
			return CLIENT_GUIS.get(ID).newInstance();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int getNextFreeID(Class<? extends Gui> guiClass) {
		int id = CLIENT_GUIS.size();
		CLIENT_GUIS.put(id, guiClass);
		return id;
	}

}
