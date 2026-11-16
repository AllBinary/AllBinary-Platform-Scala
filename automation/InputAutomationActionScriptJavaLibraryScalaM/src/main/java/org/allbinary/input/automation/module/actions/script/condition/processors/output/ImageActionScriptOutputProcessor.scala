/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.actions.script.condition.processors.output

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.media.image.InputImageIOInterfaceFactory
import _root_.org.allbinary.input.media.image.InputImageType
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.image.io.ImageIOInterface
import _root_.org.allbinary.string.CommonStrings

class ImageActionScriptOutputProcessor private() {
    import _root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.ImageActionScriptOutputProcessor.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object ImageActionScriptOutputProcessor {
    def process(imageActionScriptOutputInterface : ImageActionScriptOutputInterface, frame : _root_.java.lang.Long) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        logUtil.putF("Start - Processing at: " + imageActionScriptOutputInterface.toString(), "ImageActionScriptOutputProcessor", commonStrings.PROCESS)
        val imageTypes : ImageTypes = imageActionScriptOutputInterface.getImageTypes()
        val vector : BasicArrayList = imageTypes.getVector()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var imageType : InputImageType = vector.get(index).asInstanceOf[InputImageType]
                var imageIOInterface : ImageIOInterface = InputImageIOInterfaceFactory.getInstance(imageType)
                imageIOInterface.save(frame)
                index += 1
            }
        }
    }

}


