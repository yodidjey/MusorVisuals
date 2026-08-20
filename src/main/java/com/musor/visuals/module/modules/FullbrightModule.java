package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class FullbrightModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private float originalGamma = 1.0f;

    public FullbrightModule() {
        super("Fullbright", "Максимальная яркость без темноты");
    }

    @Override
    protected void initSettings() {
        settings.put("gamma", 16.0f);
        settings.put("blockBrightness", 1.0f);
    }

    @Override
    public void onEnable() {
        if (client.options != null) {
            originalGamma = client.options.gamma().get().floatValue();
            client.options.gamma().set(getSettingAsFloat("gamma", 16.0f));
        }
    }

    @Override
    public void onDisable() {
        if (client.options != null) {
            client.options.gamma().set(originalGamma);
        }
    }

    @Override
    public void onTick() {
        if (!enabled || client.options == null) return;
        float gamma = getSettingAsFloat("gamma", 16.0f);
        client.options.gamma().set(gamma);
    }
}
