/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.automation.module.AbstractInputAutomationWorker
import _root_.org.allbinary.input.automation.module.InputAutomationActionInterface
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfile
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfileDataWorkerType
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileAction
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.script.GenericProfileActionScript
import _root_.org.allbinary.input.media.image.capture.CapturedBufferedImagesCacheSingleton
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.cache.J2SECacheInterface
import _root_.org.allbinary.media.image.comparison.ImageComparatorConstraintsInterface
import _root_.org.allbinary.media.image.comparison.ImageComparisonWorker
import _root_.org.allbinary.media.image.comparison.motion.MotionRectangleConstraintsInterface
import _root_.org.allbinary.media.image.comparison.motion.MotionRectanglesWorker

class GenericInputAutomationWorker(param_inputAutomationActionInterface : InputAutomationActionInterface, param_genericProfile : GenericProfile, param_motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface, param_imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface) extends AbstractInputAutomationWorker(param_inputAutomationActionInterface) {

    val logUtil_GenericInputAutomationWorker : LogUtil = LogUtil.getInstance()

    val PROCESS_DATA_WORKER_RESULTS : String = "processDataWorkerResults"

    //private TimeHelper timeHelper;
    private var lastFrame : _root_.java.lang.Long = new _root_.java.lang.Long(-1)

    private var frame : _root_.java.lang.Long = null

    private var genericProfile : GenericProfile = null

    //Constructor
    {
        val inputAutomationActionInterface : InputAutomationActionInterface = param_inputAutomationActionInterface
        val genericProfile : GenericProfile = param_genericProfile
        val motionRectangleConstraintsInterface : MotionRectangleConstraintsInterface = param_motionRectangleConstraintsInterface
        val imageComparatorConstraintsInterface : ImageComparatorConstraintsInterface = param_imageComparatorConstraintsInterface
        this.logUtil_GenericInputAutomationWorker.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.setCaptureWorker(GenericProfileCaptureWorkerFactory.getInstance(genericProfile))
        this.setInputAutomationActionInterface(inputAutomationActionInterface)
        this.setImageComparisonWorker(new ImageComparisonWorker(imageComparatorConstraintsInterface))
        this.setMotionRectanglesWorker(new MotionRectanglesWorker(motionRectangleConstraintsInterface))
        //this.getCaptureWorker().addListener(this);
        this.setGenericProfile(genericProfile)
        val vector : BasicArrayList = this.getGenericProfile().getGenericProfileDataWorkerTypeVector()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                val genericProfileDataWorkerType : GenericProfileDataWorkerType = vector.get(index).asInstanceOf[GenericProfileDataWorkerType]
                this.logUtil_GenericInputAutomationWorker.putF("Adding Listener: " + genericProfileDataWorkerType, this, this.commonStrings.CONSTRUCTOR)
                if (genericProfileDataWorkerType eq GenericProfileDataWorkerType.COMPARISON) {
                    this.getCaptureWorker().addListenerInterface(this.getImageComparisonWorker())
                } else if (genericProfileDataWorkerType eq GenericProfileDataWorkerType.MOTION) {
                    this.getImageComparisonWorker().addListenerInterface(this.getMotionRectanglesWorker())
                }
                index += 1
            }
        }
    }

    def processDataWorkerResults() : Unit = {
        this.logUtil_GenericInputAutomationWorker.putF(this.commonStrings.START, this, this.PROCESS_DATA_WORKER_RESULTS)
        this.waitForDataWorkers()
        val cacheInterface : J2SECacheInterface = CapturedBufferedImagesCacheSingleton.getInstance().asInstanceOf[J2SECacheInterface]
        val keyArray : Array[Object] = cacheInterface.keySet().toArray()
        if (keyArray.length > 0) {
            this.logUtil_GenericInputAutomationWorker.putF("Image Available", this, this.PROCESS_DATA_WORKER_RESULTS)
            this.setFrame(keyArray(keyArray.length - 1).asInstanceOf[_root_.java.lang.Long])
            if (getFrame() > this.lastFrame) {
                this.logUtil_GenericInputAutomationWorker.putF("Processing new frame: " + getFrame(), this, this.PROCESS_DATA_WORKER_RESULTS)
                val hashMap : HashMap[Object, Object] = this.getGenericProfile().getGenericProfileActions().getHashMap().asInstanceOf[HashMap[Object, Object]]
                val set : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
                this.logUtil_GenericInputAutomationWorker.putF(("Processing " + set.size()) + "Actions", this, this.PROCESS_DATA_WORKER_RESULTS)
                val actionNameArray : Array[Object] = set.toArray()
                val size : Int = actionNameArray.length

                {
                    var index : Int = 0
                    while (index < size) {
                        var actionNameString : String = actionNameArray(index).asInstanceOf[String]
                        this.logUtil_GenericInputAutomationWorker.putF("Processing Action: " + actionNameString, this, this.PROCESS_DATA_WORKER_RESULTS)
                        val genericProfileAction : GenericProfileAction = hashMap.get(actionNameString).asInstanceOf[GenericProfileAction]
                        val genericProfileActionScript : GenericProfileActionScript = genericProfileAction.getGenericProfileActionScript()
                        val vector : BasicArrayList = genericProfileActionScript.getProfileActionConditionInterfaceVector()
                        CaptureWorkerUtil.processProfileActionConditions(vector, getFrame())
                        index += 1
                    }
                }
                this.lastFrame = this.getFrame()
            }
        } else {
            this.logUtil_GenericInputAutomationWorker.putF("Image Not Available", this, this.PROCESS_DATA_WORKER_RESULTS)
        }
    }

    override def process() : Unit = {
        this.logUtil_GenericInputAutomationWorker.putF(this.commonStrings.START, this, this.commonStrings.PROCESS)
        this.startDataWorkers()
        this.processDataWorkerResults()
    }

    def getGenericProfile() : GenericProfile = {
        return this.genericProfile
    }

    def setGenericProfile(genericProfile : GenericProfile) : Unit = {
        this.genericProfile = genericProfile
    }

    def getFrame() : _root_.java.lang.Long = {
        return this.frame
    }

    def setFrame(frame : _root_.java.lang.Long) : Unit = {
        this.frame = frame
    }

}


