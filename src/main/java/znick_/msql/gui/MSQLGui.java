package znick_.msql.gui;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import znick_.msql.WorldData;

public class MSQLGui extends GuiScreen {
	
	public static final int GUI_ID = GuiHandler.getNextFreeID(MSQLGui.class);
	
	private int nextButtonID;
	
	public MSQLGui() {
		
	}
	
	@Override
	public void initGui() {
		for (EntityPlayer player : WorldData.forWorld(Minecraft.getMinecraft().theWorld).getPlayers()) {
			this.buttonList.add(new GuiButton(this.nextButtonID++, 20, 30, 100, 20, player.getDisplayName()));
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTick) {
		this.drawDefaultBackground();
		this.drawCenteredString(
			Minecraft.getMinecraft().fontRenderer, 
			"Players (" + WorldData.forWorld(Minecraft.getMinecraft().theWorld).getPlayers().length + "):", 
			this.width/2, 
			25, 
			Color.WHITE.getRGB());
		super.drawScreen(mouseX, mouseY, partialTick);
	}
}
