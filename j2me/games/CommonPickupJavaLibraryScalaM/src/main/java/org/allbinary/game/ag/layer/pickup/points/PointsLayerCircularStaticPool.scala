/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.points

import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerCircularPool
import _root_.org.allbinary.layer.AllBinaryLayerFactoryInterface

class PointsLayerCircularStaticPool(param_allbinaryLayerFactoryInterface : AllBinaryLayerFactoryInterface, param_total : Int) extends AllBinaryLayerCircularPool {

    //Constructor
    {
        val allbinaryLayerFactoryInterface : AllBinaryLayerFactoryInterface = param_allbinaryLayerFactoryInterface
        val total : Int = param_total
        super.initAllBinaryLayerCircularPool(allbinaryLayerFactoryInterface, total)
    }

    def visit(sourceLayerInterface : AllBinaryLayer) : Unit = {
        var pointsLayer : PointsLayer = this.getNextInstance().asInstanceOf[PointsLayer]
        var scoreableInterface : ScoreableInterface = sourceLayerInterface.asInstanceOf[ScoreableInterface]
        pointsLayer.visit(scoreableInterface)
    }

}


