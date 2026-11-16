/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.java.awt.Rectangle
import _root_.java.awt.event.InputEvent
import _root_.java.awt.event.KeyEvent
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.automation.robot.InputRobotFactory
import _root_.org.allbinary.input.automation.robot.InputRobotInterface
import _root_.org.allbinary.input.automation.robot.TempInputRobotNames
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.ABHashtable

class TestInputForMotionRectanglesResultsWorker() extends MotionRectanglesResultsListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var index : Long = 0L

    private var running : Boolean = false

    private var motionRectanglesVector : BasicArrayList = null

    //Constructor
    {
        this.motionRectanglesVector = new BasicArrayListD()
    }

    def getMotionRectanglesVector() : BasicArrayList = {
        return this.motionRectanglesVector
    }

    def onMotionRectanglesImageComparisonResultsEvent(motionRectanglesImageComparisonResultsEvent : MotionRectanglesResultsEvent) : Unit = {
        this.getMotionRectanglesVector().add(motionRectanglesImageComparisonResultsEvent.getMotionRectangles())
        this.run()
    }

    def onEvent(allBinaryEventObject : AllBinaryEventObject) : Unit = {
        this.onMotionRectanglesImageComparisonResultsEvent(allBinaryEventObject.asInstanceOf[MotionRectanglesResultsEvent])
    }

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)
            timeHelper.setStartTimeTNT()
            var motionRectangles : MotionRectangles = this.getMotionRectanglesVector().get(0).asInstanceOf[MotionRectangles]
            var motionRectangleVector : BasicArrayList = motionRectangles.getVector()
            if (motionRectangleVector.size() > 0) {
                val rectangle : Rectangle = motionRectangleVector.get(0).asInstanceOf[Rectangle]
                val robotHashtable : ABHashtable[Object, Object] = InputRobotFactory.getInstance().get()
                val inputTypeNameArray : Array[Object] = robotHashtable.keySet().toArray()
                val size : Int = inputTypeNameArray.length

                {
                    var index : Int = 0
                    while (index < size) {
                        var inputTypeNameString : String = inputTypeNameArray(index).asInstanceOf[String]
                        var inputRobotInterface : InputRobotInterface = robotHashtable.get(inputTypeNameString).asInstanceOf[InputRobotInterface]
                        inputRobotInterface.mouseMoveToTarget(rectangle)
                        if (inputRobotInterface.getName().compareTo(TempInputRobotNames.DX_NAME) == 0) {
                            inputRobotInterface.mousePress(InputEvent.BUTTON1_MASK)
                            Thread.sleep(300)
                            inputRobotInterface.mouseRelease(InputEvent.BUTTON1_MASK)
                            inputRobotInterface.mousePress(InputEvent.BUTTON2_MASK)
                            Thread.sleep(300)
                            inputRobotInterface.mouseRelease(InputEvent.BUTTON2_MASK)
                            inputRobotInterface.mousePress(InputEvent.BUTTON3_MASK)
                            Thread.sleep(300)
                            inputRobotInterface.mouseRelease(InputEvent.BUTTON3_MASK)
                            inputRobotInterface.keyPress(KeyEvent.VK_1)
                            Thread.sleep(300)
                            inputRobotInterface.keyRelease(KeyEvent.VK_1)
                            inputRobotInterface.keyPress(KeyEvent.VK_2)
                            Thread.sleep(300)
                            inputRobotInterface.keyRelease(KeyEvent.VK_2)
                            inputRobotInterface.keyPress(KeyEvent.VK_3)
                            Thread.sleep(300)
                            inputRobotInterface.keyRelease(KeyEvent.VK_3)
                            inputRobotInterface.keyPress(KeyEvent.VK_4)
                            Thread.sleep(300)
                            inputRobotInterface.keyRelease(KeyEvent.VK_4)
                            inputRobotInterface.keyPress(KeyEvent.VK_F1)
                            Thread.sleep(300)
                            inputRobotInterface.keyRelease(KeyEvent.VK_F1)
                        }
                        index += 1
                    }
                }
            }
            this.index += 1
            this.getMotionRectanglesVector().remove(motionRectangles)
            this.logUtil.putF(CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT(), this, this.commonStrings.RUN)
            this.logUtil.putF(this.commonStrings.END, this, this.commonStrings.RUN)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

}


