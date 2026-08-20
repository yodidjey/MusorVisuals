package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для физики выпадающих предметов.
 */
public class ItemPhysicsModule extends Module {
    public ItemPhysicsModule() {
        super("Item Physics", "3D физика выпадающих предметов");
    }

    @Override
    protected void initSettings() {
        settings.put("itemScale", 1.0f);
        settings.put("rotationSpeed", 1.0f);
        settings.put("itemGlow", true);
    }

    @Override
    public void onTick() {
        // Модификация физики предметов
    }
}
