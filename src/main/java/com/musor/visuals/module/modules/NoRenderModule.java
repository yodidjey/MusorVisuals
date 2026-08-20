package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class NoRenderModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public NoRenderModule() {
        super("NoRender", "Отключение элементов: огонь, слепота, тотемы, взрывы");
    }

    @Override
    protected void initSettings() {
        settings.put("noFire", true);
        settings.put("noBlindness", true);
        settings.put("noTotem", true);
        settings.put("noExplosion", false);
        settings.put("noWitherSkulls", false);
    }

    @Override
    public void onTick() {
        if (!enabled) return;

        boolean noFire = getSettingAsBoolean("noFire", true);
        boolean noBlindness = getSettingAsBoolean("noBlindness", true);
        boolean noTotem = getSettingAsBoolean("noTotem", true);

        // Отключение эффектов рендеринга
        if (noFire && client.player != null) {
            client.player.setRemainingFireTicks(0);
        }

        if (noBlindness && client.player != null) {
            client.player.removeEffect(net.minecraft.world.effect.MobEffects.BLINDNESS);
        }
    }
}
