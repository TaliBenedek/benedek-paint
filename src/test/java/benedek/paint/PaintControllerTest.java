package benedek.paint;

import benedek.paint.PaintCanvas;
import benedek.paint.PaintController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PaintControllerTest
{
    PaintController controller;
    @FXML
    PaintCanvas paintCanvas;
    @FXML
    ColorPicker colorPicker;
    @FXML
    CheckBox eraser;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void initialize()
    {
        //given
        givenPaintController();

        //when
        controller.initialize();

        //then
        verify(colorPicker).setValue(Color.BLACK);
    }

    @Test
    public void onMousePress_EraserChecked()
    {
        //given
        givenPaintController();

        //when
        doReturn(true).when(eraser).isSelected();
        MouseEvent event = mock(MouseEvent.class);
        controller.onMousePress(event);

        //then
        verify(paintCanvas).erase(event);
    }

    @Test
    public void onMousePress_EraserUnchecked()
    {
        //given
        givenPaintController();
        MouseEvent event = mock(MouseEvent.class);

        //when
        doReturn(false).when(eraser).isSelected();
        controller.onMousePress(event);

        //then
        verify(paintCanvas).startDraw(event);
    }

    @Test
    public void onMouseDrag_EraserChecked()
    {
        //given
        givenPaintController();
        MouseEvent event = mock(MouseEvent.class);

        //when
        doReturn(true).when(eraser).isSelected();
        controller.onMouseDrag(event);

        //then
        verify(paintCanvas).erase(event);
    }

    @Test
    public void onMouseDrag_EraserUnchecked()
    {
        //given
        givenPaintController();
        MouseEvent event = mock(MouseEvent.class);

        //when
        doReturn(false).when(eraser).isSelected();
        controller.onMouseDrag(event);

        //then
        verify(paintCanvas).duringDraw(event);
    }

    @Test
    public void onMouseRelease_EraserChecked()
    {
        //given
        givenPaintController();
        MouseEvent event = mock(MouseEvent.class);

        //when
        doReturn(true).when(eraser).isSelected();
        controller.onMouseRelease(event);

        //then
        verify(paintCanvas).erase(event);
    }

    @Test
    public void onMouseRelease_EraserUnchecked()
    {
        //given
        givenPaintController();
        MouseEvent event = mock(MouseEvent.class);

        //when
        doReturn(false).when(eraser).isSelected();
        controller.onMouseRelease(event);

        //then
        verify(paintCanvas).endDraw(event);
    }

    @Test
    public void changeColor()
    {
        //given
        givenPaintController();
        ActionEvent event = mock(ActionEvent.class);

        //when
        controller.changeColor(event);

        //then
        verify(paintCanvas).changeStroke(event, colorPicker);
    }

    private void givenPaintController()
    {
        paintCanvas = mock(PaintCanvas.class);
        colorPicker = mock(ColorPicker.class);
        eraser = mock(CheckBox.class);
        controller = new PaintController();
        controller.paintCanvas = paintCanvas;
        controller.colorPicker = colorPicker;
        controller.eraser = eraser;
    }
}
