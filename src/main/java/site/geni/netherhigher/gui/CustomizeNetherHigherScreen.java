package site.geni.netherhigher.gui;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.gui.ClothConfigScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import site.geni.netherhigher.NetherHigher;

public class CustomizeNetherHigherScreen {
	/**
	 * Creates the mod's {@link ClothConfigScreen}
	 *
	 * @param parent The parent {@link Screen}
	 * @return The mod's {@link ClothConfigScreen}
	 * @author geni
	 */
	public static Screen createConfigScreen(Screen parent) {
		final ConfigBuilder builder = ConfigBuilder.create()
			.setParentScreen(parent)
			.setTitle(new TranslatableText("config.netherhigher.title"))
			.setSavingRunnable(NetherHigher::saveConfig);

		Categories.General.createCategory(builder.getOrCreateCategory(new TranslatableText("config.netherhigher.category.general")));

		return builder.build();
	}

	/**
	 * Creates and opens the mod's {@link ClothConfigScreen}
	 *
	 * @param parent The parent {@link Screen}
	 * @author geni
	 */
	public static void createAndOpenConfigScreen(Screen parent) {
		MinecraftClient.getInstance().openScreen(createConfigScreen(parent));
	}
}
