package fox.obeliskmod.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import fox.obeliskmod.ObeliskMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config 
{
	private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec server_config;
	
	private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec client_config;

	public static final String CATEGORY_GENERAL = "general";
	
	static 
	{
		ChatColorConfig.init(server_builder, client_builder);

		server_config = server_builder.build();
		client_config = client_builder.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path) 
	{
		ObeliskMod.logger.info("Loading Config" + path);

		final CommentedFileConfig file = CommentedFileConfig.builder(path)
				.sync()
				.autosave()
				.writingMode(WritingMode.REPLACE)
				.build();

		ObeliskMod.logger.info("Built Config" + path);
		file.load();
		ObeliskMod.logger.info("Loaded Config" + path);
		config.setConfig(file);
	}
}
