/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.GameFeatureImageCacheFactory
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.HashtableUtil
import _root_.org.microemu.device.playn.PlaynImage

class ImageCompleteUtil {
    import _root_.org.allbinary.media.image.ImageCompleteUtil.{*}

    //private final String METHOD_NAME = "waitForLoad";
    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(18000)

    private val allTimeDelayHelper : TimeDelayHelper = new TimeDelayHelper(120000)

    def waitForImage(image : Image, name : String) : Unit = {
        this.timeDelayHelper.setStartTime()
        this.waitForATime(image, name, this.timeDelayHelper)
    }

    def isReady(image : Image, name : String, timeDelayHelper : TimeDelayHelper) : Boolean = {
        var playnImage : PlaynImage = image.asInstanceOf[PlaynImage]
        if (!playnImage.getImage().isReady() && ((playnImage.getImage().width() + playnImage.getImage().height()) == 0)) {
            /*             try             {                 Thread.sleep(120);                 PreLogUtil.put(image.toString(), this, METHOD_NAME);             }             catch(Exception e)             {                 final CommonStrings commonStrings = CommonStrings.getInstance();                 PreLogUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e);             }             */
            if (timeDelayHelper.isTime()) {
                throw new Exception("isReady: Timeout Waiting or GameHtmlHasLoadedResourcesProcessor does not have this Image: " + name)
            }
            return false
        }
        //PreLogUtil.put("Image loading complete for: " + name, this, this.commonStrings.SUCCESS);
        return true
    }

    private def waitForATime(image : Image, name : String, timeDelayHelper : TimeDelayHelper) : Unit = {
        var playnImage : PlaynImage = image.asInstanceOf[PlaynImage]

        {
            while (!playnImage.getImage().isReady() && ((playnImage.getImage().width() + playnImage.getImage().height()) == 0)) {
                /*             try             {                 Thread.sleep(120);                 PreLogUtil.put(image.toString(), this, METHOD_NAME);             }             catch(Exception e)             {                 final CommonStrings commonStrings = CommonStrings.getInstance();                 PreLogUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e);             }             */
                if (timeDelayHelper.isTime()) {
                    throw new Exception("waitFor: Timeout Waiting or GameHtmlHasLoadedResourcesProcessor does not have this Image: " + name)
                }
            }
        }
    }

    def waitForAll() : Unit = {
        this.allTimeDelayHelper.setStartTime()
        var hashtable : Hashtable = GameFeatureImageCacheFactory.getInstance().getHashtable()
        var objectArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(hashtable)
        var size : Int = objectArray.length
        PreLogUtil.put("Total: " + size, this, "waitForAll")

        {
            var index : Int = 0
            while (index < size) {
                this.waitForATime(hashtable.get(objectArray(index)).asInstanceOf[Image], objectArray(index).asInstanceOf[String], this.allTimeDelayHelper)
                index += 1
            }
        }
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


