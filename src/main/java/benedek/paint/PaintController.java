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

    public void onMousePress(MouseEvent event)
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

    public void onMouseDrag(MouseEvent event)
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


    public void onMouseRelease(MouseEvent event)
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
        paintCanvas.changeStroke(event, colorPicker);
    }
}
