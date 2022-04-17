package znick_.msql.storage;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StorageUnit {
	
	private final EntityPlayer player;
	private final World world;
	private final Block block;
	
	private final int x;
	private final int y;
	private final int z;
	
	public StorageUnit(World world, EntityPlayer player, Block block, int x, int y, int z) {
		this.world = world;
		this.player = player;
		this.block = block;
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void showGui() {
		this.block.onBlockActivated(this.world, this.x, this.y, this.z, this.player, 0, 0, 0, 0);
	}
}
