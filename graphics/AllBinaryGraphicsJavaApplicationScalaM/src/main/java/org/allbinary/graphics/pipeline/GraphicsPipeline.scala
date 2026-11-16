/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.pipeline

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GraphicsPipeline(param_points : BasicArrayList) extends BasicGraphicsPipeline(param_points) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    //Constructor
    {
        val points : BasicArrayList = param_points
    }

    //graphicsPipe.rotate(rotate.doubleValue());   
    def rotateTheta(aTheta : Double) : Unit = {
        var newVector : BasicArrayList = new BasicArrayListD()
        var size : Int = this.pointBasicArrayList.size()

        {
            var index : Int = 0
            while (index < size) {
                var secondPoint : GPoint = pointBasicArrayList.get(index).asInstanceOf[GPoint]
                var secondX : Double = (secondPoint.getX() * Math.cos(aTheta)) - (secondPoint.getY() * Math.sin(aTheta))
                var secondY : Double = (secondPoint.getX() * Math.sin(aTheta)) + (secondPoint.getY() * Math.cos(aTheta))
                //LogUtil.put("Calculated: X: " + secondX + " Y: " + secondY, this, "rotate");
                var point : GPoint = PointFactory.getInstance().createXY((secondX.toInt), (secondY.toInt))
                newVector.add(point)
                index += 1
            }
        }
        this.pointBasicArrayList = newVector
    }

}


