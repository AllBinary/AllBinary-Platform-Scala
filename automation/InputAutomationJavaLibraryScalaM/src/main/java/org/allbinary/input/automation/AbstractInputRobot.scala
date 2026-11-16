/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation

import _root_.java.awt.*
import _root_.javax.help.HelpSet
import _root_.org.allbinary.logic.communication.log.LogUtil

class AbstractInputRobot(param_helpSet : HelpSet) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var helpSet : HelpSet = null

    //Constructor
    {
        val helpSet : HelpSet = param_helpSet
        this.setHelpSet(helpSet)
    }

    def getHelpSet() : HelpSet = {
        return this.helpSet
    }

    def mouseMove(point : Point) : Unit = {
        this.mouseMove(point.x, point.y)
        this.logUtil.putF((("Moved Mouse To: x: " + point.x) + " y: ") + point.y, this, "moveMouse")
    }

    def mouseMoveToTarget(rectangle : Rectangle, x : Integer, y : Integer) : Unit = {
        var point : Point = PointHelper.getCenterPoint(rectangle)
        this.mouseMove(point.x + x, point.y + y)
        this.logUtil.putF((((("Moved Mouse To: x: " + point.x) + " y: ") + point.y) + " in the middle of: ") + rectangle, this, "moveMouseToTarget")
    }

    def mouseMoveToTarget(rectangle : Rectangle) : Unit = {
        this.mouseMoveToTarget(rectangle, 0, 0)
    }

    def mouseMove(x : Integer, y : Integer) : Unit = {
        throw new RuntimeException()
    }

    private def setHelpSet(helpSet : HelpSet) : Unit = {
        this.helpSet = helpSet
    }

}


