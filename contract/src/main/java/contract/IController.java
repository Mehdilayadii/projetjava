package contract;

import java.awt.Point;

/**
 * The Interface IController.
 *
 * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
 */
public interface IController {

	/**
	 * Start the main gameloop.
     *
	 */
	void start();

	/**
	 * Order perform.
	 * @param controllerOrder
	 * Method use in every mobile object, and also when load map, to execute the predefined order contain in the ControllerOrder list
	 * 
	 */
	void orderPerform(ControllerOrder controllerOrder);

	/**
     * Dynamically resize the window view according to the map size
	 * @return tileMap
     * 
	 */
	IElement[][] getTileMap();

	/**
     * Get the score made at the end of the game (win or loose) for POPUP
	 * @return Score
     * 
	 */
	int getScore();

    /**
     * @param direction
     * @param currentPos
     * @return
     */
    Point computeNextPos(MobileOrder direction, Point currentPos);

	/**
     * Get the level according to the number of the map played for the draw string at the bottom of the window
	 * @return Level
     * 
	 */
	int getLevel();

    /**
     * @param tilemap String representing map with binding of letter with Element
     * @return 2-dimensional array representing game (map + mobile)
     * 
     */
    IElement[][] parser(String tilemap);

	String[][] getScores();
}
