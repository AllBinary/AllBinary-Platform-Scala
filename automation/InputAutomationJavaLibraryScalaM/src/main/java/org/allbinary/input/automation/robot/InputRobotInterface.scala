/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.robot

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.javax.help.HelpSet

trait InputRobotInterface {

    def getName() : String

    def getHelpSet() : HelpSet

    def createScreenCapture(screenRect : Rectangle) : BufferedImage

    def delay(ms : Integer) : Unit

    def getAutoDelay() : Integer

    def getPixelColor(x : Integer, y : Integer) : Color

    def isAutoWaitForIdle() : Boolean

    def keyPress(keycode : Integer) : Unit

    def keyRelease(keycode : Integer) : Unit

    def getMousePoint() : Point

    def mouseMove(x : Integer, y : Integer) : Unit

    def mousePress(buttons : Integer) : Unit

    def mouseRelease(buttons : Integer) : Unit

    def mouseWheel(wheelAmt : Integer) : Unit

    def setAutoDelay(ms : Integer) : Unit

    def setAutoWaitForIdle(isOn : Boolean) : Unit

    override def toString() : String

    def waitForIdle() : Unit

    def mouseMove(point : Point) : Unit

    //Moves to the middle of the target
    def mouseMoveToTarget(rectangle : Rectangle) : Unit

    def mouseMoveToTarget(rectangle : Rectangle, x : Integer, y : Integer) : Unit

}


