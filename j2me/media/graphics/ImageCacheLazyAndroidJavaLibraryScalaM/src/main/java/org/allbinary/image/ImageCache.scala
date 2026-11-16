/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.game.gd.resource.GDResources
import _root_.org.allbinary.logic.ABSystemWrapper
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.system.Memory

class ImageCache() extends ImageCacheBase {
    import _root_.org.allbinary.image.ImageCache.{NULL_IMAGE_CACHE as _, *}
    def NULL_IMAGE_CACHE : ImageCache = _root_.org.allbinary.image.ImageCache.NULL_IMAGE_CACHE

    val logUtil_ImageCache : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val systemWrapper : ABSystemWrapper = ABSystemWrapper.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    override def get(caller : String, width : Int, height : Int) : Image = {
        var foundIndex : Int = this.getIndexWH(width, height)
        var image : Image = this.getFromAvailable(foundIndex, width, height)
        if (image eq NullImage.NULL_IMAGE) {
            this.volume += width * height
            if (this.volume > 32000) {
                //this.logUtil.putF(new StringMaker().append("Image for: ").append(caller).toString(), this, this.commonStrings.GET);
                this.tsUtil.gc()
                //System.gc();
                this.volume = 0
            }
            image = this.createImage(caller, width, height)
            //this.logUtil.putF(new StringMaker().append("Image: ").append(image).toString(), this, this.commonStrings.GET);
            if (foundIndex == -1) {
                foundIndex = this.nextIndex
                this.widths(this.nextIndex) = width
                this.heights(this.nextIndex) = height
                this.nextIndex += 1
            }
            this.listOfList(foundIndex).add(image)
        }
        return image
    }

    def get(key : Object) : Image = {
        val resourceUtil : ResourceUtil = ResourceUtil.getInstance()
        val resourceId : Integer = resourceUtil.getResourceId(key.asInstanceOf[String])
        var image : Image = this.getImage(resourceId)
        if (image eq NullImage.NULL_IMAGE) {
            //final InputStream inputStream = resourceUtil.getResourceAsStream((String) key);
            val inputStream : InputStream = null
            try {
                this.logUtil_ImageCache.putF(Memory.getInfo(), this, this.commonStrings.GET)
                image = this.createImage(key, inputStream)
            } catch {
                case e : Exception => {
                    this.logUtil_ImageCache.put("Exception: Trying Again After GC", this, this.commonStrings.GET, e)
                    this.logUtil_ImageCache.putF(new StringMaker().append("InputStream: ").append(inputStream.toString()).toString(), this, this.commonStrings.GET)
                    this.tsUtil.gc()
                    this.tsUtil.gc()
                    this.logUtil_ImageCache.putF(Memory.getInfo(), this, this.commonStrings.GET)
                    Thread.sleep(100)
                    image = this.createImage(key, inputStream)
                }
            }
            //            }
            this.hashtable.put(resourceId, image)
        }
        return image
    }

    def getIndex(key : Object) : Int = {
        val gdResources : GDResources = GDResources.getInstance()
        val resourceStringArray : Array[String] = gdResources.resourceStringArray
        val size : Int = resourceStringArray.length

        {
            var index : Int = 0
            while (index < size) {
                if (resourceStringArray(index) eq key) {
                    return index
                }
                index += 1
            }
        }
        this.logUtil_ImageCache.putF(new StringMaker().append("unable to find key: ").append(StringUtil.getInstance().toString(key)).toString(), this, this.commonStrings.RUN)
        throw new RuntimeException()
    }

    def createImage(key : Object, inputStream : InputStream) : Image = {
        return Image.createImageLater(key.asInstanceOf[String], -1, -1)
    }

    def isLazy() : Boolean = {
        //This impl is not used
        throw new RuntimeException()
    }

}

object ImageCache {
    val NULL_IMAGE_CACHE : ImageCache = new ImageCache()

}


