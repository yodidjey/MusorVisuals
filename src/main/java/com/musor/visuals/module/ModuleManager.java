package com.musor.visuals.module;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.musor.visuals.module.modules.*;

/**
 * Менеджер модулей визуальных эффектов.
 * Управляет регистрацией, включением/выключением и обновлением всех модулей.
 */
public class ModuleManager {
    private Map<String, Module> modules = new HashMap<>();
    private List<Module> moduleList = new ArrayList<>();

    public ModuleManager() {
    }

    /**
     * Регистрирует все доступные модули.
     */
    public void registerAllModules() {
        // Окружение и Атмосфера
        registerModule(new AmbienceModule());
        registerModule(new WeatherModifierModule());
        registerModule(new CustomFogModule());
        registerModule(new CustomSkyModule());
        registerModule(new WorldTintModule());
        registerModule(new MotionBlurModule());

        // Отображение Сущностей и Игроков
        registerModule(new EntityESPModule());
        registerModule(new ChamsModule());
        registerModule(new TracerModule());
        registerModule(new TargetESPModule());
        registerModule(new SkeletonESPModule());
        registerModule(new GlowESPModule());
        registerModule(new NameTagsModule());
        registerModule(new OffscreenArrowsModule());

        // Частицы и Спецэффекты
        registerModule(new ChinaHatModule());
        registerModule(new BreadcrumbsModule());
        registerModule(new JumpCirclesModule());
        registerModule(new WingsModule());
        registerModule(new ParticlesModule());
        registerModule(new TargetParticlesModule());

        // HUD и Интерфейс
        registerModule(new TargetHUDModule());
        registerModule(new WatermarkModule());
        registerModule(new ArrayListModule());
        registerModule(new ArmorHUDModule());
        registerModule(new RadarModule());
        registerModule(new ScoreboardCustomizerModule());
        registerModule(new CooldownBarModule());
        registerModule(new NotificationsModule());

        // Камера и Экранные Эффекты
        registerModule(new FreecamModule());
        registerModule(new AspectRatioModule());
        registerModule(new ItemPhysicsModule());
        registerModule(new HandModifierModule());
        registerModule(new SwingAnimationModule());
        registerModule(new CrosshairModule());
        registerModule(new HitmarkersModule());
        registerModule(new FullbrightModule());
        registerModule(new NoRenderModule());
    }

    /**
     * Регистрирует модуль в системе.
     */
    public void registerModule(Module module) {
        modules.put(module.getName(), module);
        moduleList.add(module);
    }

    /**
     * Получает модуль по имени.
     */
    public Module getModule(String name) {
        return modules.get(name);
    }

    /**
     * Получает все зарегистрированные модули.
     */
    public List<Module> getModules() {
        return new ArrayList<>(moduleList);
    }

    /**
     * Получает список активных модулей.
     */
    public List<Module> getEnabledModules() {
        return moduleList.stream()
            .filter(Module::isEnabled)
            .toList();
    }

    /**
     * Вызывается каждый тик.
     */
    public void onTick() {
        for (Module module : moduleList) {
            if (module.isEnabled()) {
                module.onTick();
            }
        }
    }

    /**
     * Вызывается при загрузке конфигурации.
     */
    public void loadConfig() {
        for (Module module : moduleList) {
            module.loadConfig();
        }
    }

    /**
     * Вызывается при сохранении конфигурации.
     */
    public void saveConfig() {
        for (Module module : moduleList) {
            module.saveConfig();
        }
    }
}
