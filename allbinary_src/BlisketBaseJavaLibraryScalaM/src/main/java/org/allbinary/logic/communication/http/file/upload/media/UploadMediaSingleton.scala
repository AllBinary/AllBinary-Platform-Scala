/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.file.upload.media

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.media.MediaData
import _root_.org.allbinary.logic.visual.media.MediaIOUtil
import _root_.org.allbinary.logic.visual.media.MediaTypeData
import _root_.org.allbinary.string.CommonStrings

class UploadMediaSingleton private() {
    import _root_.org.allbinary.logic.communication.http.file.upload.media.UploadMediaSingleton.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var readerFileTypesHashMap : HashMap[Object, Object] = null

    private var writerFileTypesHashMap : HashMap[Object, Object] = null

    //Constructor
    {
        this.readerFileTypesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.writerFileTypesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val hashMap : HashMap[Object, Object] = MediaData.toHashMap().asInstanceOf[HashMap[Object, Object]]
        val set : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        val mediaDataNameArray : Array[Object] = set.toArray()
        val size : Int = mediaDataNameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var mediaDataName : String = mediaDataNameArray(index).asInstanceOf[String]
                var mediaData : MediaData = hashMap.get(mediaDataName).asInstanceOf[MediaData]
                this.readerFileTypesHashMap.put(mediaData.getName(), mediaData.getType())
                index += 1
            }
        }
        var mediaIOUtil : MediaIOUtil = MediaIOUtil.getInstance()
        val RESIZABLE_MEDIA : String = MediaTypeData.getInstance().RESIZABLE_MEDIA
        var readerFileTypes : Array[String] = mediaIOUtil.getReaderFormatNames()
        //StringMaker readerFileTypesBuffer = new StringMaker();

        {
            var index : Int = 0
            while (index < readerFileTypes.length) {
                this.readerFileTypesHashMap.put(readerFileTypes(index), RESIZABLE_MEDIA)
                index += 1
            }
        }
        var writerFileTypes : Array[String] = mediaIOUtil.getWriterFormatNames()
        //StringMaker writerFileTypesBuffer = new StringMaker();

        {
            var index : Int = 0
            while (index < writerFileTypes.length) {
                this.writerFileTypesHashMap.put(writerFileTypes(index), RESIZABLE_MEDIA)
                index += 1
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Supported Media Readers: ")
            stringBuffer.append(this.readerFileTypesHashMap.toString())
            stringBuffer.append(" Writers: ")
            stringBuffer.append(this.writerFileTypesHashMap.toString())
            this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def isReaderSupported(mediaFileType : String) : Boolean = {
        return this.readerFileTypesHashMap.containsKey(mediaFileType)
    }

    def isWriterSupported(mediaFileType : String) : Boolean = {
        return this.readerFileTypesHashMap.containsKey(mediaFileType)
    }

    def isSupported(mediaFileType : String) : Boolean = {
        return this.isReaderSupported(mediaFileType) && this.isWriterSupported(mediaFileType)
    }

    def isMedia(mediaFileType : String, aMediaType : String) : Boolean = {
        return this.isReaderMedia(mediaFileType, aMediaType) && this.isWriterMedia(mediaFileType, aMediaType)
    }

    def isReaderMedia(mediaFileType : String, aMediaType : String) : Boolean = {
        return this.isMedia(mediaFileType, aMediaType, this.readerFileTypesHashMap)
    }

    def isWriterMedia(mediaFileType : String, aMediaType : String) : Boolean = {
        return this.isMedia(mediaFileType, aMediaType, this.writerFileTypesHashMap)
    }

    private def isMedia(mediaFileType : String, aMediaType : String, hashMap : HashMap[Object, Object]) : Boolean = {
        if (hashMap.containsKey(mediaFileType)) {
            var mediaType : String = hashMap.get(mediaFileType).asInstanceOf[String]
            if (mediaType.compareTo(aMediaType) == 0) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}

object UploadMediaSingleton {
    private var uploadMedia : UploadMediaSingleton = null

    def getInstance() : UploadMediaSingleton = this.synchronized {
        if (UploadMediaSingleton.uploadMedia == null) {
            UploadMediaSingleton.uploadMedia = new UploadMediaSingleton()
        }
        return UploadMediaSingleton.uploadMedia
    }

}


