package com.islamic.demoathkar;
import android.graphics.Color;
import android.view.Gravity;
import com.siddharthks.bubbles.FloatingBubbleConfig;
import com.siddharthks.bubbles.FloatingBubbleService;

public class FloatingService extends FloatingBubbleService {


    @Override
    protected FloatingBubbleConfig getConfig() {
        return new FloatingBubbleConfig.Builder()
                // Set the drawable for the bubble
                .bubbleIcon(getDrawable(R.drawable.float_icon))

                // Set the drawable for the remove bubble
                .removeBubbleIcon(getDrawable(R.drawable.cross))

                // Set the size of the bubble in dp
                .bubbleIconDp(80)

                .expandableView(getInflater().inflate(R.layout.floating_view_tab,null))

                // Set the size of the remove bubble in dp
                .removeBubbleIconDp(80)

                // Set the padding of the view from the boundary
                .paddingDp(4)

                // Set the radius of the border of the expandable view
                .borderRadiusDp(4)

                // Does the bubble attract towards the walls
                .physicsEnabled(true)

                // The color of background of the layout
                .expandableColor(Color.WHITE)

                // The color of the triangular layout
                .triangleColor(Color.WHITE)

                // Horizontal gravity of the bubble when expanded
                .gravity(Gravity.END)

                // Set the alpha value for the remove bubble icon
                .removeBubbleAlpha(0.75f)

                // Building
                .build();
    }
}
