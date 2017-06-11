package com.example.chory.snakes.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.chory.snakes.enums.TileType;

/**
 * Created by chory on 6/10/2017.
 */

public class SnakeView extends View{
    private Paint mPaint = new Paint();
    private TileType snakeViewMap[][];

    public SnakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSnakeViewMap( TileType[][] map){this.snakeViewMap = map;}

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (snakeViewMap != null){
            float tileSizeX = canvas.getWidth()/snakeViewMap.length;
            float tileSizeY = canvas.getHeight()/snakeViewMap[0].length;

            float circleSize = Math.min(tileSizeX, tileSizeY) / 2;

            for (int x = 0; x < snakeViewMap.length; x ++) {
                for (int y = 0; y < snakeViewMap[x].length; y++) {
                    switch (snakeViewMap[x][y]) {
                        case Nothing:
                            mPaint.setColor(Color.WHITE);
                            break;
                        case Wall:
                            mPaint.setColor(Color.RED);
                            break;
                        case Snakehead:
                            mPaint.setColor(Color.RED);
                            break;
                        case Snake:
                            mPaint.setColor(Color.GREEN);
                            break;
                        case Apple:
                            mPaint.setColor(Color.RED);
                            break;
                    }

                    canvas.drawCircle(x * tileSizeX + tileSizeX / 2f + circleSize / 2,
                            y * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
                }
            }
        }
    }
}
