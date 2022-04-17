package znick_.msql;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import znick_.msql.storage.StorageUnit;

public class WorldData extends WorldSavedData {

	private final Map<EntityPlayer, Set<StorageUnit>> playerData = new HashMap<>();
	
	public WorldData(String key) {
		super(key);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
	
	}
	
	public void addStorageUnit(EntityPlayer player, StorageUnit unit) {
		this.playerData.get(player).add(unit);
		this.markDirty();
	}
	
	public static WorldData forWorld(World world) {
		WorldData data = (WorldData) world.mapStorage.loadData(WorldData.class, "M-SQL");
		if (data == null) {
			data = new WorldData("M-SQL");
			world.mapStorage.setData("M-SQL", data);
		}
		return data;
	}
	
	public EntityPlayer[] getPlayers() {
		return this.playerData.keySet().toArray(new EntityPlayer[0]);
	}

	public void registerPlayer(EntityPlayer player) {
		this.playerData.put(player, new HashSet<StorageUnit>());
	}
	
	public boolean isPlayerRegistered(EntityPlayer player) {
		return this.playerData.containsKey(player);
	}
}
