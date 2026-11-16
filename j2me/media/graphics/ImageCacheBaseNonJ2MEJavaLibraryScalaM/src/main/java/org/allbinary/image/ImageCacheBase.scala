/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

class ImageCacheBase() {

    val logUtil : LogUtil = LogUtil.getInstance()

    val imageFactory : ImageFactory = ImageFactory.getInstance()

    val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    val SIZE : Int = 128

    val widths : Array[Int] = new Array[Int](this.SIZE)

    val heights : Array[Int] = new Array[Int](this.SIZE)

    val listOfList : Array[BasicArrayList] = new Array[BasicArrayList](this.SIZE)

    val availableListOfList : Array[BasicArrayList] = new Array[BasicArrayList](this.SIZE)

    var volume : Int = 0

    var nextIndex : Int = 0

    //protected
    //Constructor
    {
        // super(cacheableInterfaceFactoryInterface);

        {
            var index : Int = this.listOfList.length - 1
            while (index >= 0) {
                this.listOfList(index) = new BasicArrayListD()
                index -= 1
            }
        }

        {
            var index : Int = this.availableListOfList.length - 1
            while (index >= 0) {
                this.availableListOfList(index) = new BasicArrayListD()
                index -= 1
            }
        }
    }

    def getImage(resourceId : Object) : Image = {
        val imageCanBeNull : Object = this.hashtable.get(resourceId)
        if (imageCanBeNull == null) {
            return NullImage.NULL_IMAGE
        }
        return imageCanBeNull.asInstanceOf[Image]
    }

    def releaseAll() : Unit = {

        {
            var index : Int = this.listOfList.length - 1
            while (index >= 0) {
                this.availableListOfList(index).clear()
                this.availableListOfList(index).addAllList(this.listOfList(index))
                index -= 1
            }
        }
        this.logUtil.putF(new StringMaker().append("ImageCache: ").append(this.toString()).toString(), this, "releaseAll")
    }

    def getIndexWH(width : Int, height : Int) : Int = {
        var foundIndex : Int = -1
        var size : Int = this.widths.length

        {
            var index : Int = 0
            while (index < size) {
                if ((this.widths(index) == width) && (this.heights(index) == height)) {
                    foundIndex = index
                    return foundIndex
                }
                index += 1
            }
        }
        return foundIndex
    }

    def getFromAvailable(foundIndex : Int, width : Int, height : Int) : Image = {
        if (foundIndex != -1) {
            if (this.availableListOfList(foundIndex).size() > 0) {
                //.log("Returning Image From Cache");
                var list : BasicArrayList = this.availableListOfList(foundIndex)
                return list.removeAt(list.size() - 1).asInstanceOf[Image]
            }
        }
        return NullImage.NULL_IMAGE
    }

    //    }
    def get(caller : String, width : Int, height : Int) : Image = {
        throw new RuntimeException()
    }

    def getWithKey(key : Object) : Image = {
        throw new RuntimeException()
    }

    def createImage(caller : String, width : Int, height : Int) : Image = {
        return this.imageFactory.createImage(caller, width, height)
    }

    def createImageFromInputStream(key : Object, inputStream : InputStream) : Image = {
        return this.imageFactory.createImageFromInputStream(key, inputStream)
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()

        {
            var index : Int = this.nextIndex - 1
            while (index >= 0) {
                val width : Int = this.widths(index)
                val height : Int = this.heights(index)
                val total : Int = this.listOfList(index).size()
                val totalAvailable : Int = this.availableListOfList(index).size()
                stringBuffer.append(" w: ")
                stringBuffer.appendint(width)
                stringBuffer.append(" h: ")
                stringBuffer.appendint(height)
                stringBuffer.append(CommonSeps.getInstance().SPACE)
                stringBuffer.append(CommonLabels.getInstance().TOTAL_LABEL)
                stringBuffer.appendint(total)
                stringBuffer.append(" available: ")
                stringBuffer.appendint(totalAvailable)
                index -= 1
            }
        }
        return stringBuffer.toString()
    }

    def getHashtableP() : ABHashtable[Object, Object] = {
        return this.hashtable
    }

    //OpenGL
    def init(image : Image) : Unit = {
    }

    def initProgress() : Unit = {
    }

}


