package controller;

import contract.*;

import java.awt.*;
import java.util.*;

/**
 * The Class Controller.
 */
public class Controller implements IController, Observer {

    /** The view. */
    private IView view;

    /**
     * tileMap
     */
    private IElement[][] tileMap;

    /** The model. */
    private IModel model;

    /**
     * Hero
     */
    private IHero hero;

    /**
     * Pseudo
     */
    private String pseudo;

    /**
     * Level
     */
    private int level = 1;

    /**
     * Score
     */
    private int score = 0;

    /**
     * Scores
     */
    private String[][] scores = null;

    /**
     * Position of Door
     */
    private Point posDoor = null;

    /**
     * List of monster alive
     */
    private HashMap<String, IMonster> monsters = new HashMap<String, IMonster>();

    /**
     * Fireball
     */
    private IFireball fireBall;

    /**
     * Boolean representing hero
     */
    private boolean dead = false;

    /**
     * Parser
     */
    private boolean parser = false;

    /**
     * @return return tileMap
     */
    public IElement[][] getTileMap() {
        return tileMap;
    }

    /**
     * @return Level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return Score
     */
    public int getScore() {
        return score;
    }

    /**
     * Instantiates a new controller.
     *
     * @param view
     *          the view
     * @param model
     *          the model
     */
    public Controller(final IView view, final IModel model) {
        model.getObservable().addObserver(this);
        this.setView(view);
        this.setModel(model);

        this.hero = (IHero) model.element('L', new Point());
    }

    /**
     * Entry point of Controller
     * Launch GameLoop
     *
     * @see contract.IController#start()
     */
    public void start() {
        this.orderPerform(ControllerOrder.MENU);
        this.pseudo = this.view.getPseudo();
        System.out.println(this.pseudo);

        // Game Loop
        while (true) {
            if(this.fireBall != null && !this.parser) {
                this.moveFireBall();
            }

            if(this.dead) {
                this.model.loadMap("MAP1");
                this.view.printMessage(String.format("YOU DIED! You made a score of : %d\nPress OK to restart the game", this.score));
                this.model.upNameAndScore(this.score, this.pseudo);
                this.level = 1;
                this.score = 0;
            }

            if(!this.parser) {
                for (Object o : this.monsters.entrySet()) {
                    Map.Entry pair = (Map.Entry) o;
                    IMonster monster = (IMonster) pair.getValue();
                    this.moveMonster(monster);
                }
            }

            this.view.repaint();

            try {
                Thread.sleep(200);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Sets the view.
     *
     * @param view
     *          the new view
     */
    private void setView(final IView view) {
        this.view = view;
    }

    /**
     * Sets the model.
     *
     * @param model
     *          the new model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }


    public String[][] getScores() {
        return scores;
    }