package benedek.paint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    /**
     * Starts to draw the line when the mouse is pressed on the PaintCanvas
     * or erases, depending on if eraser is checked
     * @param event
     */
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

    /**
     * Draws the line as the mouse is dragged over the PaintCanvas
     * or erases, depending on if eraser is checked
     * @param event
     */
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

    /**
     * Finishes drawing the line as the mouse is released
     * or erases, depending on if eraser is checked
     * @param event
     */
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

    /**
     * Changes the stroke color to the color the user selects from the ColorPicker
     * @param event
     */
    public void changeColor(ActionEvent event)
    {
        paintCanvas.changeStroke(event, colorPicker);
    }
}
