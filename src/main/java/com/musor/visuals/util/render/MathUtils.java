package com.musor.visuals.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import org.joml.Matrix4f;
import org.joml.Vector4f;

/**
 * Утилиты для математических операций с координатами.
 * Включает проекции, расстояния и преобразования координат.
 */
public class MathUtils {
    private static final Minecraft client = Minecraft.getInstance();

    /**
     * Получает расстояние между двумя точками в мире.
     */
    public static double getDistance(Vec3 pos1, Vec3 pos2) {
        return Math.sqrt(
            Math.pow(pos1.x - pos2.x, 2) +
            Math.pow(pos1.y - pos2.y, 2) +
            Math.pow(pos1.z - pos2.z, 2)
        );
    }

    /**
     * Получает расстояние на экране между двумя сущностями.
     */
    public static double getScreenDistance(Entity entity1, Entity entity2) {
        Vec3 pos1 = entity1.position();
        Vec3 pos2 = entity2.position();
        return getDistance(pos1, pos2);
    }

    /**
     * Проверяет, видна ли сущность на экране.
     */
    public static boolean isEntityVisible(Entity entity) {
        if (client.player == null || client.level == null) return false;
        
        Vec3 playerPos = client.player.getEyePosition();
        Vec3 entityPos = entity.position().add(0, entity.getEyeHeight(), 0);
        
        return client.level.clip(new net.minecraft.world.phys.ClipContext(
            playerPos, entityPos,
            net.minecraft.world.phys.ClipContext.Block.COLLIDER,
            net.minecraft.world.phys.ClipContext.Fluid.NONE,
            client.player
        )).getType() == net.minecraft.world.phys.HitResult.Type.MISS;
    }

    /**
     * Интерполирует между двумя значениями.
     */
    public static float lerp(float start, float end, float t) {
        return start + (end - start) * t;
    }

    /**
     * Вычисляет угол между двумя точками.
     */
    public static float getAngle(Vec3 from, Vec3 to) {
        Vec3 delta = to.subtract(from);
        return (float) Math.atan2(delta.z, delta.x);
    }
}
