/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.points

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.view.ViewPosition

class PointsLayer(param_points : Int) extends AllBinaryLayer(StringUtil.getInstance().EMPTY_STRING, new Rectangle(PointFactory.getInstance().ZERO_ZERO, 0, 0), ViewPosition.getInstanceD()) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var points : Int = 0

    //Constructor
    {
        val points : Int = param_points
        this.points = points
    }

    override def paint(graphics : Graphics) : Unit = {
    }

    def visit(scoreableInterface : ScoreableInterface) : Unit = {
        //PreLogUtil.put("Add Points: " + points, this, "visit");
        scoreableInterface.addPoints(this.points)
    }

}


