package elcon.mods.skillcraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import elcon.mods.skillcraft.skills.SkillPlayer;
import elcon.mods.skillcraft.skills.SkillServer;

import net.minecraft.world.World;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.storage.ISaveHandler;

public class SCSaveHandler {

	public ISaveHandler saveHandler;
	public World world;
	
	public SCSaveHandler(ISaveHandler saveHandler, World world) {
		this.saveHandler = saveHandler;
		this.world = world;
	}

	public void loadSkills() {
		if(world.provider.dimensionId == 0) {
			try {
				File file = getSaveFile(saveHandler, world, "skills.dat", false);
				if(file != null){
					try {
						loadSkills(file);
					} catch(Exception e) {
						e.printStackTrace();
						File file2 = getSaveFile(saveHandler, world, "skills.dat", true);
						if(file2.exists()) {
							loadSkills(file2);
						} else {
							file.createNewFile();
							saveSkills();
						}
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadSkills(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		GZIPInputStream gzis = new GZIPInputStream(fis);
		ObjectInputStream in = new ObjectInputStream(gzis);
		SkillServer.players.clear();
		HashMap<String, SkillPlayer> players = (HashMap<String, SkillPlayer>) in.readObject();
		SkillServer.players.putAll(players);
		in.close();
		gzis.close();
		fis.close();
	}

	public void saveSkills() {
		if(world.provider.dimensionId == 0) {
			try {
				FileOutputStream fos = new FileOutputStream(getSaveFile(saveHandler, world, "skills.dat", false).getAbsolutePath());
				GZIPOutputStream gzos = new GZIPOutputStream(fos);
				ObjectOutputStream out = new ObjectOutputStream(gzos);
				out.writeObject(SkillServer.players);
				out.flush();
				out.close();
				gzos.close();
				fos.close();
				copyFile(getSaveFile(saveHandler, world, "skills.dat", false), getSaveFile(saveHandler, world, "skills.dat", true));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private File getSaveFile(ISaveHandler saveHandler, World world, String name, boolean backup) {
		File worldDir = new File(saveHandler.getWorldDirectoryName());
		IChunkLoader loader = saveHandler.getChunkLoader(world.provider);
		if(loader instanceof AnvilChunkLoader) {
			worldDir = ((AnvilChunkLoader) loader).chunkSaveLocation;
		}
		return new File(worldDir, new StringBuilder().append(name).append(backup ? ".bak" : "").toString());
	}
	
	private void copyFile(File sourceFile, File destFile) throws IOException {
		if(!destFile.exists()) {
			destFile.createNewFile();
		}
		
		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0L, source.size());
		} finally {
			if(source != null) {
				source.close();
			}
			if(destination != null) {
				destination.close();
			}
		}
	}
}
