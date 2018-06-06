package contract;


import java.awt.*;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
 */
public interface IModel {

	/**
	 * Gets the observable.
	 * @return the observable
	 */
	Observable getObservable();

	/**
	 * Gets the map content.
	 * Load the text file of the map needed as it appear in the DataBase
	 * @return GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
	 */
	String getMap();

	/**
	 * Load the map using the key in the table map of the database
	 * @param key Id in the DB
	 * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
	 */
	void loadMap(String key);

	/**
	 * @param c c for character on the text file
	 * @param pos
	 * Use the parser to locate, on the map, the position for the mobile elements, and the door, in order to make them move when needed
	 * @return map
	 */
	IElement element(char c, Point pos);

    /**
     * Get the Highscore from the DB made by the five best users. Use a SQL routine
     * @return an array, in the first column the nickname, and the second the highscore
     *
     */
    String[][] getHighScore();

    /**
     * @param score int made by user
     * @param nickname string typed
     * At win or loose POPUP the actual score made is load in the DataBase
     * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
     */
    void upNameAndScore(final int score, final String nickname);
}
