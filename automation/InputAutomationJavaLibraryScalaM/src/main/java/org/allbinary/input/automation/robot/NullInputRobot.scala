/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.robot

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.javax.help.HelpSet
import _root_.org.allbinary.input.automation.AbstractInputRobot
import _root_.org.allbinary.input.automation.PointFactory
import _root_.org.allbinary.logic.communication.log.LogUtil

class NullInputRobot() extends AbstractInputRobot(null) with InputRobotInterface {
    import _root_.org.allbinary.input.automation.robot.NullInputRobot.{LIBRARY_NAME as _, NAME as _, *}
    def LIBRARY_NAME : String = _root_.org.allbinary.input.automation.robot.NullInputRobot.LIBRARY_NAME
    def NAME : String = _root_.org.allbinary.input.automation.robot.NullInputRobot.NAME

    val logUtil_NullInputRobot : LogUtil = LogUtil.getInstance()

    def getName() : String = {
        return NullInputRobot.NAME
    }

    override def getHelpSet() : HelpSet = {
        return null
    }

    def getMousePoint() : Point = {
        return PointFactory.getInstance(0, 0)
    }

    def keyPress(keycode : Integer) : Unit = {
        this.logUtil_NullInputRobot.putF("KeyCode: " + keycode, this, "keyPress")
    }

    def keyRelease(keycode : Integer) : Unit = {
        this.logUtil_NullInputRobot.putF("KeyCode: " + keycode, this, "keyRelease")
    }

    override def mouseMove(x : Integer, y : Integer) : Unit = {
        this.logUtil_NullInputRobot.putF((("X: " + x) + " Y: ") + y, this, "mouseMove")
    }

    def mousePress(buttons : Integer) : Unit = {
        this.logUtil_NullInputRobot.putF("Buttons: " + buttons, this, "mousePress")
    }

    def mouseRelease(buttons : Integer) : Unit = {
        this.logUtil_NullInputRobot.putF("Buttons: " + buttons, this, "mouseRelease")
    }

    def createScreenCapture(screenRect : Rectangle) : BufferedImage = {
        return null
    }

    def delay(ms : Integer) : Unit = {
    }

    def getAutoDelay() : Integer = {
        return -1
    }

    def getPixelColor(x : Integer, y : Integer) : Color = {
        return null
    }

    def isAutoWaitForIdle() : Boolean = {
        return false
    }

    def mouseWheel(wheelAmt : Integer) : Unit = {
    }

    def setAutoDelay(ms : Integer) : Unit = {
    }

    def setAutoWaitForIdle(isOn : Boolean) : Unit = {
    }

    override def toString() : String = {
        return "DirectXWindowsInputRobot"
    }

    def waitForIdle() : Unit = {
    }

    //Needed for polyglot do not remove
    override def mouseMove(point : Point) : Unit = {
        super.mouseMove(point)
    }

    //Needed for polyglot do not remove
    override def mouseMoveToTarget(rectangle : Rectangle) : Unit = {
        super.mouseMoveToTarget(rectangle)
    }

    //Needed for polyglot do not remove
    override def mouseMoveToTarget(rectangle : Rectangle, x : Integer, y : Integer) : Unit = {
        super.mouseMoveToTarget(rectangle, x, y)
    }

}

object NullInputRobot {
    val LIBRARY_NAME : String = "null"

    val NAME : String = "NULL"

}


