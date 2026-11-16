/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.robot

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.javax.help.HelpSet
import _root_.org.allbinary.input.automation.PointHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class InputRobot(param_graphicsDevice : GraphicsDevice) extends InputRobotInterface {
    import _root_.org.allbinary.input.automation.robot.InputRobot.{NAME as _, *}
    def NAME : String = _root_.org.allbinary.input.automation.robot.InputRobot.NAME

    val logUtil : LogUtil = LogUtil.getInstance()

    private var robot : Robot = null

    //Constructor
    {
        val graphicsDevice : GraphicsDevice = param_graphicsDevice
        this.robot = new Robot(graphicsDevice)
    }

    def getName() : String = {
        return InputRobot.NAME
    }

    def getHelpSet() : HelpSet = {
        return null
    }

    def getMousePoint() : Point = {
        val point : Point = MouseInfo.getPointerInfo().getLocation()
        return point
    }

    def mouseMoveToTarget(rectangle : Rectangle, x : Integer, y : Integer) : Unit = {
        val point : Point = PointHelper.getCenterPoint(rectangle)
        this.robot.mouseMove(point.x + x, point.y + y)
        val message : String = new StringMaker().append("Moved Mouse To: x: ").appendint(point.x).append(" y: ").appendint(point.y).append(" in the middle of: ").append(StringUtil.getInstance().toString(rectangle)).toString()
        this.logUtil.putF(message, this, "moveMouseToTarget")
    }

    def mouseMove(point : Point) : Unit = {
        this.mouseMove(point.x, point.y)
    }

    def mouseMove(x : Int, y : Int) : Unit = {
        this.robot.mouseMove(x, y)
        val message : String = new StringMaker().append("Moved Mouse To: x: ").appendint(x).append(" y: ").appendint(y).toString()
        this.logUtil.putF(message, this, "moveMouse")
    }

    def mouseMoveToTarget(rectangle : Rectangle) : Unit = {
        this.mouseMoveToTarget(rectangle, 0, 0)
    }

    def createScreenCapture(screenRect : Rectangle) : BufferedImage = {
        return this.robot.createScreenCapture(screenRect)
    }

    def delay(ms : Integer) : Unit = {
        this.robot.delay(ms)
    }

    def getAutoDelay() : Integer = {
        return this.robot.getAutoDelay()
    }

    def getPixelColor(x : Integer, y : Integer) : Color = {
        return this.robot.getPixelColor(x, y)
    }

    def isAutoWaitForIdle() : Boolean = {
        return this.robot.isAutoWaitForIdle()
    }

    def keyPress(keycode : Integer) : Unit = {
        this.robot.keyPress(keycode)
    }

    def keyRelease(keycode : Integer) : Unit = {
        this.robot.keyRelease(keycode)
    }

    def mouseMove(x : Integer, y : Integer) : Unit = {
        this.robot.mouseMove(x, y)
    }

    def mousePress(buttons : Integer) : Unit = {
        this.robot.mousePress(buttons)
    }

    def mouseRelease(buttons : Integer) : Unit = {
        this.robot.mouseRelease(buttons)
    }

    def mouseWheel(wheelAmt : Integer) : Unit = {
        this.robot.mouseWheel(wheelAmt)
    }

    def setAutoDelay(ms : Integer) : Unit = {
        this.robot.setAutoDelay(ms)
    }

    def setAutoWaitForIdle(isOn : Boolean) : Unit = {
        this.robot.setAutoWaitForIdle(isOn)
    }

    override def toString() : String = {
        return this.robot.toString()
    }

    def waitForIdle() : Unit = {
        this.robot.waitForIdle()
    }

    def on() : Unit = {
    }

    def off() : Unit = {
    }

}

object InputRobot {
    val NAME : String = "Java Robot"

}


