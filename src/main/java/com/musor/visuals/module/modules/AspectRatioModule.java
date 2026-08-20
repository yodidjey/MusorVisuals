package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class AspectRatioModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public AspectRatioModule() {
        super("Aspect Ratio", "Изменение соотношения сторон");
    }

    @Override
    protected void initSettings() {
        settings.put("aspectRatio", 16.0f / 9.0f);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        float ratio = getSettingAsFloat("aspectRatio", 16.0f / 9.0f);
        // Изменение FOV согласно соотношению
    }
}
