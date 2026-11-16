/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.game.test

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.automation.module.AbstractInputAutomationWorker
import _root_.org.allbinary.input.automation.module.InputAutomationActionInterface
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileAction
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActions
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.script.GenericProfileActionScript
import _root_.org.allbinary.input.media.image.capture.CapturedBufferedImagesCacheSingleton
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.cache.J2SECacheInterface
import _root_.org.allbinary.media.image.comparison.ImageComparatorConstraintsInterface
import _root_.org.allbinary.media.image.comparison.motion.MotionRectangleConstraintsInterface

class TestInputAutomationCaptureWorker(param_inputAutomationActionInterface : InputAutomationActionInterface, param_genericProfileActions : GenericProfileActions, param_imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface, param_motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface) extends AbstractInputAutomationWorker(param_inputAutomationActionInterface) {

    val logUtil_TestInputAutomationCaptureWorker : LogUtil = LogUtil.getInstance()

    //private TimeHelper timeHelper;
    private var genericProfileActions : GenericProfileActions = null

    private val MESSAGE : String = "GenericInputAutomationCaptureWorker"

    private val PROCESS_DATA_WORKER_RESULTS : String = "processDataWorkerResults"

    private val IMAGE_AVAILABLE_SO_PROCESSING : String = "Image Available so processing"

    private val IMAGE_NOT_AVAILABLE : String = "Image Not Available"

    //Constructor
    {
        val inputAutomationActionInterface : InputAutomationActionInterface = param_inputAutomationActionInterface
        val genericProfileActions : GenericProfileActions = param_genericProfileActions
        val imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface = param_imageComparatorConstraintsInterface
        val motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface = param_motionRectangleConstraintsInterface
        this.logUtil_TestInputAutomationCaptureWorker.putF(this.MESSAGE, this, this.commonStrings.CONSTRUCTOR)
        this.setGenericProfileActions(genericProfileActions)
    }

    def processDataWorkerResults() : Unit = {
        val cacheInterface : J2SECacheInterface = CapturedBufferedImagesCacheSingleton.getInstance().asInstanceOf[J2SECacheInterface]
        if (cacheInterface.keySet().size() > 0) {
            this.logUtil_TestInputAutomationCaptureWorker.putF(this.IMAGE_AVAILABLE_SO_PROCESSING, this, this.PROCESS_DATA_WORKER_RESULTS)
            var anyType : Object = cacheInterface.keySet().toArray()(0)
            //(BufferedImageFrameCacheable) cacheInterface.get(object);
            var hashMap : HashMap[Object, Object] = this.getGenericProfileActions().getHashMap().asInstanceOf[HashMap[Object, Object]]
            var set : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
            val actionNameArray : Array[Object] = set.toArray()
            val size : Int = actionNameArray.length

            {
                var index : Int = 0
                while (index < size) {
                    var actionNameString : String = actionNameArray(index).asInstanceOf[String]
                    var genericProfileAction : GenericProfileAction = hashMap.get(actionNameString).asInstanceOf[GenericProfileAction]
                    var genericProfileActionScript : GenericProfileActionScript = genericProfileAction.getGenericProfileActionScript()
                    var vector : BasicArrayList = genericProfileActionScript.getProfileActionConditionInterfaceVector()
                    index += 1
                }
            }
            //was remove before
            cacheInterface.get(anyType)
        } else {
            this.logUtil_TestInputAutomationCaptureWorker.putF(this.IMAGE_NOT_AVAILABLE, this, this.PROCESS_DATA_WORKER_RESULTS)
        }
    }

    override def process() : Unit = {
        this.logUtil_TestInputAutomationCaptureWorker.putF(this.commonStrings.START, this, this.commonStrings.PROCESS)
        this.startDataWorkers()
        this.processDataWorkerResults()
    }

    def getGenericProfileActions() : GenericProfileActions = {
        return this.genericProfileActions
    }

    def setGenericProfileActions(genericProfileActions : GenericProfileActions) : Unit = {
        this.genericProfileActions = genericProfileActions
    }

}


