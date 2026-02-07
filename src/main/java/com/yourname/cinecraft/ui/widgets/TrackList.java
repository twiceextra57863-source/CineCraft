package com.yourname.cinecraft.ui.widgets;

import com.yourname.cinecraft.timeline.Track;
import com.yourname.cinecraft.timeline.Timeline;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;

public class TrackList extends ClickableWidget {

    private final Timeline timeline;
    private int scrollOffset = 0;

    public TrackList(int x, int y, int width, int height, Timeline timeline) {
        super(x, y, width, height, Text.empty());
        this.timeline = timeline;
    }

    @Override
    protected void renderWidget(DrawContext ctx, int mouseX, int mouseY, float delta) {
        ctx.fill(getX(), getY(), getX() + width, getY() + height, 0xFF121212);

        int yOffset = getY() + 6 - scrollOffset;

        for (Track track : timeline.getTracks()) {
            ctx.fill(getX(), yOffset, getX() + width, yOffset + 18, 0xFF1E1E1E);

            ctx.drawText(
                    client.textRenderer,
                    track.getName(),
                    getX() + 6,
                    yOffset + 5,
                    0xFFFFFF,
                    false
            );

            yOffset += 20;
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        scrollOffset -= amount * 10;
        if (scrollOffset < 0) scrollOffset = 0;
        return true;
    }
}
