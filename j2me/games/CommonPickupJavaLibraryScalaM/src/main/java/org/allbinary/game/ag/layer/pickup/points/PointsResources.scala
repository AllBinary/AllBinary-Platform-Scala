/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.points


/**  *  * @author Berthelot, Travis  * @version 1.0  */
class PointsResources private() {
    import _root_.org.allbinary.game.ag.layer.pickup.points.PointsResources.{*}

    var RESOURCE : String = "points_drop_20_by_20.png"

    var RESOURCE_2 : String = "points_2_drop_20_by_20.png"

    var RESOURCE_3 : String = "points_3_drop_20_by_20.png"

    var RESOURCE_4 : String = "points_4_drop_20_by_20.png"

}

object PointsResources {
    private val SINGLETON : PointsResources = new PointsResources()

    def getInstance() : PointsResources = {
        return PointsResources.SINGLETON
    }

}


