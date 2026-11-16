/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.input.media.image.capture

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.input.automation.ImageOutputData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.number.LongUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface
import _root_.org.allbinary.logic.visual.media.MediaDataFactory
import _root_.org.allbinary.media.image.ImagePersistanceUtil
import _root_.org.allbinary.media.image.ImageUtil
import _root_.org.allbinary.media.image.cache.BufferedImageFrameCacheable
import _root_.org.allbinary.media.image.io.ImageIOInterface
import _root_.org.allbinary.string.CommonStrings

class CapturedImageInputOutput extends ImageIOInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    def save(frame : _root_.java.lang.Long) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val capturedBufferedImageCacheable : BufferedImageFrameCacheable = ((CapturedBufferedImagesCacheSingleton.getInstance().asInstanceOf[AutomaticCacheInterface]).get(frame).asInstanceOf[BufferedImageFrameCacheable])
        this.logUtil.putF(("Saving: " + capturedBufferedImageCacheable.toString()), this, commonStrings.SAVE)
        this.save(capturedBufferedImageCacheable.getBufferedImage(), frame)
    }

    def save(bufferedImage : BufferedImage, frame : _root_.java.lang.Long) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val imageUtil : ImageUtil = ImageUtil.getInstance()
        val filePathStringBuffer : StringMaker = new StringMaker()
        filePathStringBuffer.append(ImageOutputData.SAVE_PATH)
        filePathStringBuffer.append(LongUtil.fillIn(frame.toString()))
        filePathStringBuffer.append(MediaDataFactory.getInstance().JPG.getExtension())
        var filePath : String = filePathStringBuffer.toString()
        this.logUtil.putF((("Image File Path: " + filePath) + imageUtil.toString(bufferedImage)), this, commonStrings.SAVE)
        val imagePersistanceUtil : ImagePersistanceUtil = ImagePersistanceUtil.getInstance()
        imagePersistanceUtil.saveWithImageIO(filePath, bufferedImage)
    }

}


