/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.org.allbinary.animation.VectorRotationGenerator
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author user  */
class PointsUtil {
    import _root_.org.allbinary.graphics.j2me.workarea.tools.PointsUtil.{*}

    def doTransforms(pointVector : BasicArrayList, angle : _root_.java.lang.Double, fulcrumPoint : GPoint) : BasicArrayList = {
        return VectorRotationGenerator.getInstance().getListAtAngle(fulcrumPoint.getX(), fulcrumPoint.getY(), pointVector, AngleFactory.getInstance().getAt(angle.intValue()))
    }

}

object PointsUtil {
    private val instance : PointsUtil = new PointsUtil()

    /**      * @return the instance      */
    def getInstance() : PointsUtil = {
        return PointsUtil.instance
    }

}


