package net.wonky.fieldguide.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import static net.wonky.fieldguide.FieldGuide.MODID;

public class FieldGuideButton extends ImageButton {

    public static final WidgetSprites FIELDGUIDE_BUTTON_TEXTURE = new WidgetSprites(ResourceLocation.fromNamespaceAndPath(MODID, "textures/gui/button.png"), ResourceLocation.fromNamespaceAndPath(MODID, "textures/gui/button_highlighted.png"));
    private final AbstractContainerScreen<?> parentGui;
    public FieldGuideButton(AbstractContainerScreen<?> parentGui, int xIn, int yIn, int widthIn, int heightIn, WidgetSprites sprites) {
        super(xIn, yIn, widthIn, heightIn, sprites, (button) -> {
            Minecraft minecraftInstance = Minecraft.getInstance();
                });
        this.parentGui = parentGui;
    }
}

