/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.points

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerFactoryInterface

/**  *  * @author user  */
class PointsLayerFactory(param_points : Int) extends AllBinaryLayerFactoryInterface {

    private var points : Int = 0

    //Constructor
    {
        val points : Int = param_points
        this.points = points
    }

    override def getInstance() : AllBinaryLayer = {
        return new PointsLayer(this.points)
    }

}


