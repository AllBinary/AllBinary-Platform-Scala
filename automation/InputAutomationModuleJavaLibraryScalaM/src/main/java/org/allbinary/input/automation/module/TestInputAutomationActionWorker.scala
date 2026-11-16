/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module

import _root_.java.util.Set
import _root_.org.allbinary.input.automation.robot.InputRobotFactory
import _root_.org.allbinary.input.automation.robot.InputRobotInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.image.comparison.ImageComparatorConstraintsInterface
import _root_.org.allbinary.media.image.comparison.motion.MotionRectangleConstraintsInterface
import _root_.org.allbinary.util.ABHashtable

class TestInputAutomationActionWorker(param_sleep : Int, param_inputAutomationActionInterface : InputAutomationActionInterface, param_imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface, param_motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface) extends AbstractInputAutomationWorker(param_inputAutomationActionInterface) {

    val logUtil_TestInputAutomationActionWorker : LogUtil = LogUtil.getInstance()

    private var sleep : Int = 0

    //Constructor
    {
        val sleep : Int = param_sleep
        val inputAutomationActionInterface : InputAutomationActionInterface = param_inputAutomationActionInterface
        val imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface = param_imageComparatorConstraintsInterface
        val motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface = param_motionRectangleConstraintsInterface
        this.logUtil_TestInputAutomationActionWorker.putF("BasicTestAttackWorder", this, this.commonStrings.CONSTRUCTOR)
        this.sleep = sleep
    }

    def processBetweenWorkers() : Unit = {
        Thread.sleep(2000)
    }

    override def process() : Unit = {
        this.logUtil_TestInputAutomationActionWorker.putF(this.commonStrings.START, this, this.commonStrings.PROCESS)
        //this.startCaptureWorkers();
        val hashtable : ABHashtable[Object, Object] = InputRobotFactory.getInstance().get()
        val set : Set[Object] = hashtable.keySet().asInstanceOf[Set[Object]]
        val inputTypeNameArray : Array[Object] = set.toArray()
        val size : Int = inputTypeNameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var inputTypeNameString : String = inputTypeNameArray(index).asInstanceOf[String]
                var robot : InputRobotInterface = hashtable.get(inputTypeNameString).asInstanceOf[InputRobotInterface]
                //this.getInputAutomationActionInterface().test();
                if (this.sleep > 0) {
                    Thread.sleep(this.sleep)
                }
                index += 1
            }
        }
    }

}


