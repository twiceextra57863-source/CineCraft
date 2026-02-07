package com.yourname.cinecraft.ui.widgets;

import com.yourname.cinecraft.timeline.Timeline;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class TimelineBar extends ClickableWidget {

    private final Timeline timeline;
    private boolean dragging = false;

    public TimelineBar(int x, int y, int width, int height, Timeline timeline) {
        super(x, y, width, height, Text.empty());
        this.timeline = timeline;
    }

    @Override
    protected void renderWidget(DrawContext ctx, int mouseX, int mouseY, float delta) {
        // background
        ctx.fill(getX(), getY(), getX() + width, getY() + height, 0xFF1B1B1B);

        // time ruler (every second)
        int seconds = (int) timeline.getDuration();
        for (int i = 0; i <= seconds; i++) {
            int px = getX() + (int) ((i / timeline.getDuration()) * width);
            ctx.fill(px, getY(), px + 1, getY() + height, 0xFF333333);
        }

        // playhead
        int playX = getX() + (int) (timeline.getNormalizedTime() * width);
        ctx.fill(playX - 1, getY(), playX + 1, getY() + height, 0xFFFF4444);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        seek(mouseX);
        dragging = true;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy) {
        if (dragging) {
            seek(mouseX);
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        dragging = false;
        return true;
    }

    private void seek(double mouseX) {
        double t = (mouseX - getX()) / width;
        timeline.seekNormalized(MathHelper.clamp(t, 0.0, 1.0));
    }
}
