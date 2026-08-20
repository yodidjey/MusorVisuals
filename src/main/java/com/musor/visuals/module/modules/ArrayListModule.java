package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import java.util.List;

/**
 * Модуль для отображения списка активных модулей.
 */
public class ArrayListModule extends Module {
    public ArrayListModule() {
        super("ArrayList", "Список активных модулей на экране");
    }

    @Override
    protected void initSettings() {
        settings.put("arrayX", 5.0f);
        settings.put("arrayY", 20.0f);
        settings.put("sortByLength", false);
        settings.put("textColor", 0xFFFFFFFF);
        settings.put("textScale", 1.0f);
        settings.put("backgroundColor", 0x80000000);
    }

    @Override
    public void onTick() {
        // Рендеринг списка модулей
    }
}
