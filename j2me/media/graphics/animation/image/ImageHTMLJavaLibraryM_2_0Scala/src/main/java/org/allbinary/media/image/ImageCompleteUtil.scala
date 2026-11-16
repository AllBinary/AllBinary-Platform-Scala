/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.microemu.device.playn.PlaynImage
import _root_.playn.core.CoreImage

class ImageCompleteUtil {
    import _root_.org.allbinary.media.image.ImageCompleteUtil.{*}

    val ISREADY : String = "isReady"

    //    }
    private val COMPLETE : String = "Image loading complete for: "

    def waitForImage(image : Image, name : String) : Unit = {
    }

    def isReady(image : Image, name : String, timeDelayHelper : TimeDelayHelper) : Boolean = {
        val playnImage : PlaynImage = image.asInstanceOf[PlaynImage]
        val playnCoreImage : CoreImage = playnImage.getImage().asInstanceOf[CoreImage]
        //if(!playnCoreImage.isReady()) PreLogUtil.put("core Image Ready: " + image.getName() + CommonSeps.getInstance().SPACE + playnCoreImage.width() + playnCoreImage.height(), this, this.ISREADY);
        if (!playnCoreImage.isReady() || ((playnCoreImage.width() + playnCoreImage.height()) <= 0)) {
            /*             try             {                 PreLogUtil.put("Waiting for Image: " + image.getName(), this, this.ISREADY);                 Thread.sleep(120);             }             catch(Exception e)             {                 final CommonStrings commonStrings = CommonStrings.getInstance();                 PreLogUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e);             }              */
            this.handleTimeout(name)
            return false
        }
        if (!image.isReady()) {
            image.init(image.getImage())
            if (!image.isReady()) {
                PreLogUtil.put("Waiting for Not Ready Image: " + image.getName(), this, this.ISREADY)
            }
        }
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        PreLogUtil.put(this.COMPLETE + image.getName(), this, commonStrings.SUCCESS)
        return true
    }

    def handleTimeout(name : String) : Unit = {
    }

    def waitForAll() : Unit = {
    }

}

object ImageCompleteUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageCompleteUtil = new ImageCompleteUtil()

    /**      * @return the instance      */
    def getInstance() : ImageCompleteUtil = {
        return ImageCompleteUtil.instance
    }

}


