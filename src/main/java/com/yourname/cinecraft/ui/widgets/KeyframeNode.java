package com.yourname.cinecraft.ui.widgets;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;

public class KeyframeNode extends ClickableWidget {

    private boolean selected = false;

    public KeyframeNode(int x, int y) {
        super(x - 4, y - 4, 8, 8, Text.empty());
    }

    @Override
    protected void renderWidget(DrawContext ctx, int mouseX, int mouseY, float delta) {
        int color;

        if (selected) {
            color = 0xFFFFAA00; // selected
        } else if (isHovered()) {
            color = 0xFFFFFF00; // hover
        } else {
            color = 0xFFFFFFFF; // normal
        }

        ctx.fill(getX(), getY(), getX() + width, getY() + height, color);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        selected = !selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean value) {
        selected = value;
    }
}
