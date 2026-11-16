/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.GameFeatureImageCacheFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.HashtableUtil
import _root_.org.microemu.device.playn.PlaynImage

/**  *  * @author User  */
class ImageWaitCompleteUtil() extends ImageCompleteUtil {

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final String METHOD_NAME = "waitForLoad";
    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(18000)

    private val allTimeDelayHelper : TimeDelayHelper = new TimeDelayHelper(120000)

    override def waitForImage(image : Image, name : String) : Unit = {
        this.timeDelayHelper.setStartTimeTNT()
        this.waitForATime(image, name, this.timeDelayHelper)
    }

    override def handleTimeout(name : String) : Unit = {
        if (this.timeDelayHelper.isTimeTNT()) {
            throw new Exception("isReady: Timeout Waiting or GameHtmlHasLoadedResourcesProcessor does not have this Image: " + name)
        }
    }

    private def waitForATime(image : Image, name : String, timeDelayHelper : TimeDelayHelper) : Unit = {
        val playnImage : PlaynImage = image.asInstanceOf[PlaynImage]
        val playnCoreImage : _root_.playn.core.Image = playnImage.getImage().asInstanceOf[_root_.playn.core.Image]
        //if(!playnCoreImage.isReady()) PreLogUtil.put("core Image Ready: " + image.getName() + " " + playnCoreImage.width() + playnCoreImage.height(), this, ISREADY);

        {
            while (!playnCoreImage.isReady() || ((playnCoreImage.width() + playnCoreImage.height()) <= 0)) {
                /*             try             {                 PreLogUtil.put("Waiting for Image Ready: " + image.toString(), this, this.METHOD_NAME);                 Thread.sleep(120);             }             catch(Exception e)             {                 final CommonStrings commonStrings = CommonStrings.getInstance();                 PreLogUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e);             }             */
                if (timeDelayHelper.isTimeTNT()) {
                    throw new Exception("waitFor: Timeout Waiting or GameHtmlHasLoadedResourcesProcessor does not have this Image: " + name)
                }
            }
        }
        if (!image.isReady()) {
            image.init(image.getImage())
        }
    }

    override def waitForAll() : Unit = {
        this.allTimeDelayHelper.setStartTimeTNT()
        val hashtable : ABHashtable[Object, Object] = GameFeatureImageCacheFactory.getInstance().getHashtableP()
        val objectArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(hashtable)
        val size : Int = objectArray.length
        PreLogUtil.put("Image Total: " + size, this, "waitForAll")

        {
            var index : Int = 0
            while (index < size) {
                this.waitForATime(hashtable.get(objectArray(index)).asInstanceOf[Image], objectArray(index).asInstanceOf[String], this.allTimeDelayHelper)
                index += 1
            }
        }
    }

}


