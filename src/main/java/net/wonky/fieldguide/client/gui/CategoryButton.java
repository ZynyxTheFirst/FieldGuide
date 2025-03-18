package net.wonky.fieldguide.client.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class CategoryButton extends Button {
    protected CategoryButton(int x, int y, int width, int height, Component message, OnPress onPress, CreateNarration createNarration) {
        super(x, y, width, height, message, onPress, createNarration);
    }
}
