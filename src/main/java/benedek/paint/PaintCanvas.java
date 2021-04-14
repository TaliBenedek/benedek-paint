package benedek.paint;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;


public class PaintCanvas extends Canvas
{
    private GraphicsContext context = getGraphicsContext2D();

    /**
     * Starts the drawing process after the mouse click
     * @param event
     */
    public void startDraw(MouseEvent event)
    {
        context.beginPath();
        context.moveTo(event.getX(), event.getY());
        context.stroke();
    }

    /**
     * Draws the line as the mouse is dragged over the PaintCanvas
     * @param event
     */
    public void duringDraw(MouseEvent event)
    {
        context.lineTo(event.getX(), event.getY());
        context.stroke();
        context.closePath();
        context.beginPath();
        context.moveTo(event.getX(), event.getY());
    }

    /**
     * Finishes the drawing when the mouse is released
     * @param event
     */
    public void endDraw(MouseEvent event)
    {
        context.lineTo(event.getX(), event.getY());
        context.stroke();
        context.closePath();
    }

    /**
     * Erases strokes on the PaintCanvas
     * @param event
     */
    public void erase(MouseEvent event)
    {
        context.clearRect(event.getX(), event.getY(), 5,5);
    }

    /**
     * Changes the stroke color to the color selected in ColorPicker
     * @param event
     * @param colorPicker
     */
    public void changeStroke(ActionEvent event, ColorPicker colorPicker)
    {
        context.setStroke(colorPicker.getValue());
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
