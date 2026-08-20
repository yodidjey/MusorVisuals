# MusorVisuals Development

## Архитектура проекта

```
MusorVisuals/
├── src/main/java/com/musor/visuals/
│   ├── MusorVisualsMod.java                # Главная точка входа
│   ├── module/
│   │   ├── Module.java                     # Базовый класс модуля
│   │   ├── ModuleManager.java              # Менеджер всех модулей
│   │   └── modules/                        # Все визуальные модули
│   ├── render/
│   │   ├── RenderManager.java              # Менеджер рендеринга
│   │   ├── RenderBatcher.java              # Батчинг для оптимизации
│   │   └── ShaderManager.java              # Управление шейдерами
│   ├── ui/
│   │   ├── gui/
│   │   │   ├── ClickGUI.java               # Главное меню
│   │   │   └── GuiModule.java              # Элемент меню модуля
│   │   ├── font/
│   │   │   └── FontRenderer.java           # Кастомный шрифт
│   │   └── components/
│   │       ├── Button.java                 # Кнопка
│   │       └── Slider.java                 # Слайдер
│   ├── util/
│   │   ├── animation/
│   │   │   └── AnimationUtils.java         # Easing функции
│   │   ├── color/
│   │   │   └── ColorUtils.java             # Работа с цветами
│   │   └── render/
│   │       ├── MathUtils.java              # Математика для рендера
│   │       ├── RenderUtils2D.java          # 2D рендеринг
│   │       └── RenderUtils3D.java          # 3D рендеринг
│   ├── config/
│   │   └── ConfigManager.java              # Управление конфигом
│   └── mixin/
│       └── Mixin*.java                     # Fabric миксины
│
└── src/main/resources/
    ├── fabric.mod.json                     # Манифест мода
    ├── musorvisuals.mixins.json            # Конфиг миксинов
    └── assets/                             # Текстуры и ассеты
```

## Основные компоненты

### 1. ModuleManager
Управляет всеми модулями, их включением/выключением, загрузкой конфига.

### 2. RenderManager
Координирует все операции рендеринга, батчинга и применения эффектов.

### 3. ShaderManager
Управляет кастомными шейдерами для продвинутых эффектов.

### 4. ClickGUI
Визуальный интерфейс в фиолетовом стиле с карточками модулей.

### 5. Модули (Modules)

#### Окружение (World & Atmosphere)
- AmbienceModule - изменение времени суток
- WeatherModifierModule - отключение осадков
- CustomFogModule - настройка тумана
- CustomSkyModule - кастомизация неба
- WorldTintModule - тонирование мира
- MotionBlurModule - эффект размытия

#### ESP (Entities & Players)
- EntityESPModule - боксы вокруг игроков
- ChamsModule - модели сквозь стены
- TracerModule - линии к сущностям
- TargetESPModule - указатель на цель
- SkeletonESPModule - скелет игрока
- GlowESPModule - свечение контуров
- NameTagsModule - расширенные плашки имен
- OffscreenArrowsModule - стрелки на края экрана

#### Частицы (Particles & Effects)
- ChinaHatModule - конус над головой
- BreadcrumbsModule - след за игроком
- JumpCirclesModule - круги при прыжке
- WingsModule - крылья за спиной
- ParticlesModule - кастомные частицы
- TargetParticlesModule - частицы вокруг цели

#### HUD (Interface & Overlays)
- TargetHUDModule - панель с инфо о цели
- WatermarkModule - логотип мода
- ArrayListModule - список активных модулей
- ArmorHUDModule - показ брони
- RadarModule - миникарта
- ScoreboardCustomizerModule - стилизация табло
- CooldownBarModule - индикатор атаки
- NotificationsModule - уведомления

#### Камера (Camera & Screen)
- FreecamModule - свободная камера
- AspectRatioModule - соотношение сторон
- ItemPhysicsModule - физика предметов
- HandModifierModule - положение рук
- SwingAnimationModule - анимации удара
- CrosshairModule - кастомный прицел
- HitmarkersModule - показатели урона
- FullbrightModule - максимальная яркость
- NoRenderModule - отключение элементов

## Стиль ClickGUI

- **Основной цвет**: #7700FF (Фиолетовый)
- **Цвет фона**: #1a0033 (Темный фиолетовый)
- **Белый текст**: #FFFFFF
- **Стиль**: Карточки с анимацией
- **Шрифт**: EspressoDolce-подобный
- **Элементы**: Кнопки, слайдеры, переключатели

## Как добавить новый модуль

1. Создайте класс, наследующий `Module`
2. Реализуйте методы `initSettings()`, `onTick()`
3. Добавьте его в `ModuleManager.registerAllModules()`
4. Создайте UI элемент в `GuiModule`

## Сборка

```bash
./gradlew build
```

JAR файл будет в `build/libs/`

## Специфические функции для серверов

### Funtime
- Улучшенный ESP для PvP
- Оптимизированный Fullbright
- Кастомная анимация атаки

### HolyWorld
- Безопасный FreeCam
- Radar для кланов
- Оптимизированный NameTags

### Reallyworld
- Advanced Target HUD
- Cooldown Bar
- Hitmarkers с звуком

---

**Статус**: ✅ В разработке
**Версия**: 1.0.0
**MC Версия**: 1.21.1
