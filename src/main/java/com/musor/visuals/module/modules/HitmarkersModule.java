package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;
import java.util.LinkedList;
import java.util.Queue;

public class HitmarkersModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private Queue<Long> hitTimes = new LinkedList<>();

    public HitmarkersModule() {
        super("Hitmarkers", "Показатели урона и попаданий");
    }

    @Override
    protected void initSettings() {
        settings.put("hitmarkerType", "sound");
        settings.put("hitmarkerSize", 10.0f);
        settings.put("damageIndicator", true);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        // Отображение хитмаркеров при попадании
    }

    public void onHit() {
        hitTimes.offer(System.currentTimeMillis());
    }
}
