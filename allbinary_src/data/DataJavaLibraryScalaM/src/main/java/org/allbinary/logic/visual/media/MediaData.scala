/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.media

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.StdUtil

class MediaData(param_a_Name : String) {
    import _root_.org.allbinary.logic.visual.media.MediaData.{*}

    private var name : String = null

    private var `type` : String = null

    private var extension : String = null

    //Constructor
    {
        val a_Name : String = param_a_Name
        this.name = a_Name
        this.extension = "." + this.name
        this.`type` = MediaTypeData.getInstance().NOT_RESIZABLE_MEDIA
        MediaData.hashMap.put(a_Name, this)
    }

    def getName() : String = {
        return this.name
    }

    def getType() : String = {
        return this.`type`
    }

    def getExtension() : String = {
        return this.extension
    }

    def isConvertableTo(mediaData : MediaData) : Boolean = {
        if ((this eq MediaDataFactory.getInstance().GIF) && (mediaData eq MediaDataFactory.getInstance().JPG)) {
            return true
        }
        return false
    }

    override def toString() : String = {
        return this.getName()
    }

}

object MediaData {
    private var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    def get(a_Name : String) : MediaData = {
        var mediaData : MediaData = MediaData.hashMap.get(a_Name).asInstanceOf[MediaData]
        if (mediaData != null) {
            return mediaData
        } else {
            throw new Exception("No Such MediaData")
        }
        throw new IllegalStateException()
    }

    def getDefault() : MediaData = {
        return MediaDataFactory.getInstance().JPG
    }

    def toHashMap() : HashMap[Object, Object] = {
        return MediaData.hashMap
    }

}


