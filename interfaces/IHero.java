package contract;

/**
 * Interface Hero
 */
public interface IHero extends IMobile {
    /**
     * @author GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
     * @param order from the user
     * @param tileMap check elements permeability and size map
     * @param view
     * Override move method from mobile for Hero element
     */
    void move(MobileOrder order, IElement[][] , IView view);
}
