/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfile
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfileDataWorkerType
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.SavedCaptureGenericProfileDataWorkerType
import _root_.org.allbinary.input.media.image.capture.CaptureWorkerInterface
import _root_.org.allbinary.input.media.image.capture.ScreenCaptureImagesWorker

class GenericProfileCaptureWorkerFactory private() {
    import _root_.org.allbinary.input.automation.module.generic.GenericProfileCaptureWorkerFactory.{*}

}

object GenericProfileCaptureWorkerFactory {
    def getInstance(genericProfile : GenericProfile) : CaptureWorkerInterface = {
        val vector : BasicArrayList = genericProfile.getGenericProfileDataWorkerTypeVector()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var genericProfileDataWorkerType : GenericProfileDataWorkerType = vector.get(index).asInstanceOf[GenericProfileDataWorkerType]
                //this.logUtil.putF("Possible Capture Type: " + genericProfileDataWorkerType, "GenericProfileCaptureWorkerFactory", commonStrings.GET_INSTANCE);
                if (genericProfileDataWorkerType eq GenericProfileDataWorkerType.SCREEN_CAPTURE) {
                    return new ScreenCaptureImagesWorker()
                } else if (genericProfileDataWorkerType eq GenericProfileDataWorkerType.SAVED_CAPTURE) {
                    return new SavedCaptureImagesWorker(genericProfileDataWorkerType.asInstanceOf[SavedCaptureGenericProfileDataWorkerType])
                }
                index += 1
            }
        }
        throw new Exception("No CaptureWorkerInterface specified in GenericProfile")
    }

}


