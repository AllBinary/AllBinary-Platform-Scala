/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile

import _root_.org.allbinary.input.media.image.InputImageType

class SavedCaptureGenericProfileDataWorkerType(param_name : String, param_path : String, param_lastFrame : Int) extends GenericProfileDataWorkerType(param_name) {
    import _root_.org.allbinary.input.automation.module.generic.configuration.profile.SavedCaptureGenericProfileDataWorkerType.{*}

    private var path : String = null

    private var lastFrame : Int = 0

    //Constructor
    {
        val name : String = param_name
        val path : String = param_path
        val lastFrame : Int = param_lastFrame
        this.setPath(path)
        this.setLastFrame(lastFrame)
    }

    def getPath() : String = {
        return this.path
    }

    def setPath(path : String) : Unit = {
        this.path = path
    }

    def getLastFrame() : Int = {
        return this.lastFrame
    }

    def setLastFrame(lastFrame : Int) : Unit = {
        this.lastFrame = lastFrame
    }

}

object SavedCaptureGenericProfileDataWorkerType {
    var SAVED_CAPTURE : SavedCaptureGenericProfileDataWorkerType = new SavedCaptureGenericProfileDataWorkerType("Saved " + InputImageType.CAPTURE.getName(), "c:\\share\\captures\\2\\", 100)

}


