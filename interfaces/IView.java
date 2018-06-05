package contract;

/**
 * The Interface IView.
 *
 * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
 */
public interface IView {

	/**
	 * @param controller
     * Initialize the controller
     * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
	 */
	void setController(IController controller);

    /**
     * In the loop, refresh the view for animation, movement, and update made on the map
     * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
     */
    void repaint();

    /**
     * @return height of the window
     */
    int getHeight();

    /**
     * @return width of the window
     */
    int getWidth();

    /**
     * text area for the user name at the beginning of the game
     * @return pseudo
     * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
     */
    String getPseudo();

	/**
	 * @param message
     * POPUP to show a message like a println but not in the console
     * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
	 */
	void printMessage(final String message);
}
