package controller;

import contract.*;
import model.Model;
import view.View;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.*;

public class ControllerTest {
    private IModel model;
    private IView view;
    private IController controller;
    private IElement[][] expectedMap;

    /**
     * Sets the up.
     *
     * @throws Exception
     *           the exception
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model();
        this.view = new View(this.model);
        this.controller = new Controller(this.view, this.model);
        this.view.setController(controller);

        this.expectedMap = new IElement[][]{
                {model.element('B', new Point()), model.element('V', new Point()), model.element('H', new Point()), model.element('P', new Point()), model.element('L', new Point())},
                {model.element('1', new Point()), model.element('2', new Point()), model.element('3', new Point()), model.element('4', new Point()), model.element(' ', new Point())},
                {model.element('C', new Point()), model.element('O', new Point()), model.element(' ', new Point()), model.element(' ', new Point()), model.element(' ', new Point())}
        };
    }

    @Test
    public void TestOrderPerformMAP1() throws Exception {
        this.controller.orderPerform(ControllerOrder.MAP1);
        assertEquals(1, this.controller.getLevel());
        assertEquals("BHHHHHHHHHHHHHHHHHHB\n" +
                "V    V             V\n" +
                "V    V             V\n" +
                "V    V     P       V\n" +
                "V  P BHHHHHB       V\n" +
                "V P P1     K  L   CV\n" +
                "V  P BHHHHHB       V\n" +
                "V    V     P       V\n" +
                "V    V             V\n" +
                "V    V             V\n" +
                "V    V             V\n" +
                "BHHHHHHHHHHHHHHHHHHB",
                this.model.getMap());
    }