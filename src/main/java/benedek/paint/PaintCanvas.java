package benedek.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;


public class PaintCanvas extends Canvas
{
    GraphicsContext context = getGraphicsContext2D();
    public void startDraw(MouseEvent event)
    {
        context.beginPath();
        context.moveTo(event.getX(), event.getY());
        context.stroke();
    }

    public void duringDraw(MouseEvent event)
    {
        context.lineTo(event.getX(), event.getY());
        context.stroke();
        context.closePath();
        context.beginPath();
        context.moveTo(event.getX(), event.getY());
    }

    public void endDraw(MouseEvent event)
    {
        context.lineTo(event.getX(), event.getY());
        context.stroke();
        context.closePath();
    }

    public void erase(MouseEvent event)
    {
        context.clearRect(event.getX(), event.getY(), 5,5);
    }

    @Override
    public double minHeight(double width)
    {
        return 64;
    }

    @Override
    public double maxHeight(double width)
    {
        return 1000;
    }

    @Override
    public double prefHeight(double width)
    {
        return minHeight(width);
    }

    @Override
    public double minWidth(double height)
    {
        return 0;
    }

    @Override
    public double maxWidth(double height)
    {
        return 10000;
    }

    @Override
    public boolean isResizable()
    {
        return true;
    }

    @Override
    public void resize(double width, double height)
    {
        super.setWidth(width);
        super.setHeight(height);
    }
}
