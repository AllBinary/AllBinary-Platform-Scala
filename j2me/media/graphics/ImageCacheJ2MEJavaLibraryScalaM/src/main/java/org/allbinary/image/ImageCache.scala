/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.game.gd.resource.GDResources
import _root_.org.allbinary.logic.ABSystemWrapper
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.system.Memory

class ImageCache() extends ImageCacheBase {
    import _root_.org.allbinary.image.ImageCache.{NULL_IMAGE_CACHE as _, *}
    def NULL_IMAGE_CACHE : ImageCache = _root_.org.allbinary.image.ImageCache.NULL_IMAGE_CACHE

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    //private final ABSystemWrapper systemWrapper = ABSystemWrapper.getInstance();
    private val tsUtil : TsUtil = TsUtil.getInstance()

    //AllBinaryRendererBase3
    def addListener(renderer : Object) : Unit = {
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
        this.logUtil.putF(new StringMaker().append("unable to find key: ").append(StringUtil.getInstance().toString(key)).toString(), this, this.commonStrings.RUN)
        throw new RuntimeException()
    }

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
            val widths : Array[Int] = this.widths
            if (this.nextIndex > (widths.length - 1)) {
                if (foundIndex == -1) {
                    foundIndex = this.nextIndex
                    widths(this.nextIndex) = width
                    this.heights(this.nextIndex) = height
                    this.nextIndex += 1
                }
                this.listOfList(foundIndex).add(image)
            }
        }
        return image
    }

    override def getWithKey(key : Object) : Image = {
        var image : Image = this.getImage(key)
        if (image eq NullImage.NULL_IMAGE) {
            val resourceUtil : ResourceUtil = ResourceUtil.getInstance()
            val resourceInputStream : InputStream = resourceUtil.getResourceAsStream(key.asInstanceOf[String])
            if (resourceInputStream == null) {
                throw new RuntimeException(new StringMaker().append("Image resource is not available for key: ").append(StringUtil.getInstance().toString(key)).toString())
            }
            try {
                //this.logUtil.putF(Memory.getInfo(), this, this.commonStrings.GET);
                image = this.createImageFromInputStream(key, resourceInputStream)
            } catch {
                case e : Exception => {
                    this.logUtil.put("Exception: Trying Again After GC", this, this.commonStrings.GET, e)
                    this.logUtil.putF(new StringMaker().append("InputStream: ").append(StringUtil.getInstance().toString(resourceInputStream)).toString(), this, this.commonStrings.GET)
                    this.tsUtil.gc()
                    this.tsUtil.gc()
                    this.logUtil.putF(Memory.getInfo(), this, this.commonStrings.GET)
                    Thread.sleep(100)
                    image = this.createImageFromInputStream(key, resourceInputStream)
                }
            }
            if (J2MEUtil.isHTML()) {
            } else {
                resourceInputStream.close()
            }
            //            }
            this.hashtable.put(key, image)
        }
        //        this.logUtil.putF(key + " = " + image.toString(), this, this.commonStrings.CONSTRUCTOR);
        return image
    }

    def loadImageForAnimation() : Unit = {
    }

    def progressEnded() : Unit = {
    }

    def runTask() : Unit = {
    }

    def isLazy() : Boolean = {
        return false
    }

}

object ImageCache {
    val NULL_IMAGE_CACHE : ImageCache = new ImageCache()

}


