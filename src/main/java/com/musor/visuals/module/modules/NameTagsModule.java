package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

/**
 * Модуль для расширенных плашек имен (2D/3D).
 */
public class NameTagsModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public NameTagsModule() {
        super("NameTags", "Расширенные плашки имен с информацией");
    }

    @Override
    protected void initSettings() {
        settings.put("show2D", true);
        settings.put("showHealth", true);
        settings.put("showArmor", true);
        settings.put("showDistance", true);
        settings.put("backgroundColor", 0x80000000);
        settings.put("textScale", 1.0f);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        boolean showHealth = getSettingAsBoolean("showHealth", true);
        boolean showArmor = getSettingAsBoolean("showArmor", true);
        boolean showDistance = getSettingAsBoolean("showDistance", true);
        float textScale = getSettingAsFloat("textScale", 1.0f);

        for (Entity entity : client.level.entitiesForRendering()) {
            if (entity == client.player) continue;
            if (!(entity instanceof Player)) continue;

            Player player = (Player) entity;
            String nameTag = player.getName().getString();
            
            if (showDistance) {
                float distance = client.player.distanceTo(entity);
                nameTag += " [" + String.format("%.1f", distance) + "m]";
            }

            if (showHealth && player instanceof Player) {
                float health = ((Player) player).getHealth();
                nameTag += " HP: " + String.format("%.1f", health);
            }

            // Рендеринг NameTag над игроком
            renderNameTag(player, nameTag, textScale);
        }
    }

    private void renderNameTag(Player player, String text, float scale) {
        // NameTag будет рендериться через Screen рендер
    }
}
