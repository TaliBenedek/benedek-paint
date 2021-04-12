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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaintControllerTest
{
    private PaintController controller;
    @FXML
    private PaintCanvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private CheckBox eraser;

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
        controller.onMousePress(mock(MouseEvent.class));
        eraser.isSelected();

        //then
        verify(canvas).erase(mock(MouseEvent.class));
    }

    @Test
    public void onMousePress_EraserUnchecked()
    {
        //given
        givenPaintController();

        //when
        controller.onMousePress(mock(MouseEvent.class));

        //then
        verify(canvas).startDraw(mock(MouseEvent.class));
    }

    @Test
    public void onMouseDrag_EraserChecked()
    {
        //given
        givenPaintController();

        //when
        controller.onMouseDrag(mock(MouseEvent.class));

        //then
        verify(canvas).erase(mock(MouseEvent.class));
    }

    @Test
    public void onMouseDrag_EraserUnchecked()
    {
        //given
        givenPaintController();

        //when
        controller.onMouseDrag(mock(MouseEvent.class));

        //then
        verify(canvas).duringDraw(mock(MouseEvent.class));
    }

    @Test
    public void onMouseRelease_EraserChecked()
    {
        //given
        givenPaintController();

        //when
        controller.onMouseRelease(mock(MouseEvent.class));

        //then
        verify(canvas).erase(mock(MouseEvent.class));
    }

    @Test
    public void onMouseRelease_EraserUnchecked()
    {
        //given
        givenPaintController();

        //when
        controller.onMouseRelease(mock(MouseEvent.class));

        //then
        verify(canvas).endDraw(mock(MouseEvent.class));
    }

    @Test
    public void changeColor()
    {
        //given
        givenPaintController();

        //when
        controller.changeColor(mock(ActionEvent.class));

        //then
        verify(canvas).changeStroke(mock(ActionEvent.class), colorPicker);
    }

    private void givenPaintController()
    {
        canvas = mock(PaintCanvas.class);
        colorPicker = mock(ColorPicker.class);
        controller = new PaintController();
        eraser = mock(CheckBox.class);
    }
}
