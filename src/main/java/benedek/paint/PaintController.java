package benedek.paint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;


public class PaintController
{
    @FXML
    PaintCanvas paintCanvas;

    @FXML
    ColorPicker colorPicker;

    @FXML
    CheckBox eraser;

    @FXML
    public void initialize()
    {
        colorPicker.setValue(Color.BLACK);
    }

    public void press(MouseEvent event)
    {
        if(!eraser.isSelected())
        {
            paintCanvas.startDraw(event);
        }
        else
        {
            paintCanvas.erase(event);
        }
    }

    public void drag(MouseEvent event)
    {
        if(!eraser.isSelected())
        {
            paintCanvas.duringDraw(event);
        }
        else
        {
            paintCanvas.erase(event);
        }
    }


    public void release(MouseEvent event)
    {
        if(!eraser.isSelected())
        {
            paintCanvas.endDraw(event);
        }
        else
        {
            paintCanvas.erase(event);
        }
    }

    public void changeColor(ActionEvent event)
    {
        GraphicsContext context = paintCanvas.getGraphicsContext2D();
        context.setStroke(colorPicker.getValue());
    }

}
