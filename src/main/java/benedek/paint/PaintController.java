package benedek.paint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

public class PaintController
{
    @FXML
    PaintCanvas paintCanvas;

    @FXML
    ColorPicker colorPicker;

    public void press(MouseEvent event)
    {
        GraphicsContext context = paintCanvas.getGraphicsContext2D();
        context.beginPath();
        context.moveTo(event.getX(), event.getY());
        context.stroke();
    }

    public void draw(MouseEvent event)
    {
        GraphicsContext context = paintCanvas.getGraphicsContext2D();
        context.lineTo(event.getX(), event.getY());
        context.stroke();
        context.closePath();
        context.beginPath();
        context.moveTo(event.getX(), event.getY());
    }


    public void release(MouseEvent event)
    {
        GraphicsContext context = paintCanvas.getGraphicsContext2D();
        context.lineTo(event.getX(), event.getY());
        context.stroke();
        context.closePath();
    }

    public void changeColor(ActionEvent actionEvent)
    {
        GraphicsContext context = paintCanvas.getGraphicsContext2D();
        context.setStroke(colorPicker.getValue());
    }
}
