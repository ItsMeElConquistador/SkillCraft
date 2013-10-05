package elcon.mods.skillcraft;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import elcon.mods.core.IElConSaveHandler;
import elcon.mods.skillcraft.skills.PlayerSkill;
import elcon.mods.skillcraft.skills.SkillServer;

public class SCSaveHandler implements IElConSaveHandler {

	@Override
	public String[] getSaveFiles() {
		return new String[]{"skills"};
	}

	@Override
	public SaveFileType getSaveFileType(String fileName) {
		return SaveFileType.OBJECT;
	}

	@Override
	public void load(String fileName, File file, ObjectInputStream in) {
		try {
			SkillServer.players.clear();
			HashMap<String, HashMap<String, PlayerSkill>> players = (HashMap<String, HashMap<String, PlayerSkill>>) in.readObject();
			SkillServer.players.putAll(players);
			SCLog.info("Loaded skills");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(String fileName, File file, ObjectOutputStream out) {
		try {
			out.writeObject(SkillServer.players);
			SCLog.info("Saved skills");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadNBT(String fileName, File file, NBTTagCompound nbt) {
		
	}

	@Override
	public void saveNBT(String fileName, File file, NBTTagCompound nbt) {
		
	}

}
