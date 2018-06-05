package model.motionless;

import model.Element;

/**
 * GR 1-MehdiLayadi-SissaouiIslam-AmineDergal-BougandouraYoucef
 */

/** Class used to create a motionless element */
public abstract class Motionless extends Element {
    /** Instantiate a motionless object
     * @param imagePath contains the path to the image file
     * @param permeability tells if the hero can pass through this object or not
     */
    public Motionless(String imagePath, final boolean permeability) {
        super(imagePath, permeability);
    }
}
