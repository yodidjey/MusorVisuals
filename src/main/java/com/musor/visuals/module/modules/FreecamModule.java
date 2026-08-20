package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class FreecamModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private double freecamX, freecamY, freecamZ;
    private float freecamYaw, freecamPitch;

    public FreecamModule() {
        super("Freecam", "Свободная камера для наблюдения");
    }

    @Override
    protected void initSettings() {
        settings.put("freecamSpeed", 0.5f);
        settings.put("freecamBoostMultiplier", 2.0f);
    }

    @Override
    public void onEnable() {
        if (client.player != null) {
            freecamX = client.player.getX();
            freecamY = client.player.getY();
            freecamZ = client.player.getZ();
            freecamYaw = client.player.getYRot();
            freecamPitch = client.player.getXRot();
        }
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null) return;

        float speed = getSettingAsFloat("freecamSpeed", 0.5f);
        float boost = getSettingAsFloat("freecamBoostMultiplier", 2.0f);

        if (client.options.sprintKey.isDown()) speed *= boost;

        if (client.options.keyUp.isDown()) freecamZ -= speed;
        if (client.options.keyDown.isDown()) freecamZ += speed;
        if (client.options.keyLeft.isDown()) freecamX -= speed;
        if (client.options.keyRight.isDown()) freecamX += speed;
        if (client.options.keyJump.isDown()) freecamY += speed;
        if (client.options.keyShift.isDown()) freecamY -= speed;
    }
}
