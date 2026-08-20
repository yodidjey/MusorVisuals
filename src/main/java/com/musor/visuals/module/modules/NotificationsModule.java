package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;
import java.util.Queue;
import java.util.LinkedList;

public class NotificationsModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private Queue<NotificationData> notifications = new LinkedList<>();

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
        if (!enabled) return;
        // Рендеринг уведомлений
    }

    public void addNotification(String message) {
        notifications.offer(new NotificationData(message, System.currentTimeMillis()));
    }

    private static class NotificationData {
        String message;
        long createdTime;

        NotificationData(String message, long createdTime) {
            this.message = message;
            this.createdTime = createdTime;
        }
    }
}
