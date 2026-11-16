/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.media.image.capture

import _root_.java.awt.Dimension
import _root_.java.awt.Rectangle
import _root_.java.awt.Toolkit
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.input.automation.robot.InputRobotFactory
import _root_.org.allbinary.input.automation.robot.InputRobotInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable

class ScreenScavangerRobot() {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def getScreenAsBufferedImages() : Array[BufferedImage] = {
        this.logUtil.putF(this.commonStrings.START, this, "getScreenAsBufferedImages")
        val dimScreenSize : Dimension = Toolkit.getDefaultToolkit().getScreenSize()
        val rectScreenSize : Rectangle = new Rectangle(dimScreenSize)
        val robotHashtable : ABHashtable[Object, Object] = InputRobotFactory.getInstance().get()
        var bufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](1)
        var index : Int = 0
        val inputRobotInterface : InputRobotInterface = robotHashtable.get("Java Robot").asInstanceOf[InputRobotInterface]
        bufferedImageArray(index) = inputRobotInterface.createScreenCapture(rectScreenSize)
        this.logUtil.putF("Finish", this, "getScreenAsBufferedImages")
        return bufferedImageArray
    }

}


