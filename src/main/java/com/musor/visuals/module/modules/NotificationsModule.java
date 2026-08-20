package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Модуль для отображения кастомных уведомлений.
 */
public class NotificationsModule extends Module {
    private Queue<String> notifications = new LinkedList<>();

    public NotificationsModule() {
        super("Notifications", "Кастомные всплывающие уведомления");
    }

    @Override
    protected void initSettings() {
        settings.put("notificationX", 10.0f);
        settings.put("notificationY", 100.0f);
        settings.put("notificationDuration", 3000.0f);
        settings.put("backgroundColor", 0x80000000);
        settings.put("textColor", 0xFFFFFFFF);
    }

    @Override
    public void onTick() {
        // Рендеринг уведомлений
    }

    public void addNotification(String message) {
        notifications.offer(message);
    }
}
