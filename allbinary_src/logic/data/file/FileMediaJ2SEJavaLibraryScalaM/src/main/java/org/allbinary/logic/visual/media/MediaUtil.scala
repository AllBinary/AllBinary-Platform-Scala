/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.media

import _root_.java.awt.image.BufferedImage
import _root_.java.awt.image.RenderedImage
import _root_.java.util.HashMap
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.image.ImageUtil
import _root_.org.allbinary.string.CommonLabels

//import com.sun.imageio.plugins.common.ImageUtil;
class MediaUtil private() {
    import _root_.org.allbinary.logic.visual.media.MediaUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def saveImageFile(originalImageFile : AbFile, newImageFileName : String, category : String, mediaData : MediaData, newWidth : Int, newHeight : Int) : Unit = {
        if ((originalImageFile == null) || !originalImageFile.isFile()) {
            throw new Exception("Original Image File Does Not Exist.")
        }
        var bufferedImage : BufferedImage = ImageIOUtil.read(originalImageFile)
        if (bufferedImage == null) {
            throw new Exception("Unable to find ImageReader for this file.")
        }
        if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().VIEW)) {
            var hashMap : HashMap[Object, Object] = _root_.org.allbinary.logic.visual.media.MediaUtil.getImageBufferPropertyHashMap(bufferedImage).asInstanceOf[HashMap[Object, Object]]
            this.logUtil.putF("Image Properties: " + hashMap.toString(), this, "saveImageFile()")
        }
        val imageFile : AbFile = AbFile.createAbFile(category + newImageFileName)
        imageFile.createNewFile()
        val imageUtil : ImageUtil = ImageUtil.getInstance()
        var newBufferedImage : BufferedImage = imageUtil.createBufferedImageForSave(bufferedImage, newWidth, newHeight)
        var isWritten : Boolean = ImageIOUtil.write(newBufferedImage.asInstanceOf[RenderedImage], mediaData.getName(), imageFile)
        if (!isWritten) {
            throw new Exception("Unable to write.")
        }
        if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().VIEW)) {
            val commonLabels : CommonLabels = CommonLabels.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Get Path: ")
            stringBuffer.append(originalImageFile.getPath())
            stringBuffer.append("\nNewImageFileName: ")
            stringBuffer.append(newImageFileName)
            stringBuffer.append("\nCategory: ")
            stringBuffer.append(category)
            stringBuffer.append("\nSave File Type: ")
            stringBuffer.append(mediaData.getName())
            //CommonSeps.getInstance().NEW_LINE + commonLabels + height +
            stringBuffer.append("\nNew").append(commonLabels.WIDTH_LABEL)
            stringBuffer.appendint(newWidth)
            stringBuffer.append("\nNew").append(commonLabels.HEIGHT_LABEL)
            stringBuffer.appendint(newHeight)
            //"\ncommonLabels Ratio: " + heightRatio +
            stringBuffer.append("\nFile Length: ")
            stringBuffer.appendlong(originalImageFile.length())
            stringBuffer.append("\nNew File Length: ")
            stringBuffer.appendlong(imageFile.length())
            this.logUtil.putF(stringBuffer.toString(), this, "saveImageFile()")
        }
    }

}

object MediaUtil {
    private val instance : MediaUtil = new MediaUtil()

    def getInstance() : MediaUtil = {
        return MediaUtil.instance
    }

    private def getImageBufferPropertyHashMap(bufferedImage : BufferedImage) : HashMap[Object, Object] = {
        val hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val propertyStringArray : Array[String] = bufferedImage.getPropertyNames()
        if (propertyStringArray != null) {

            {
                var index : Int = 0
                while (index < propertyStringArray.length) {
                    //String propertyString =
                    var propertyObject : Object = bufferedImage.getProperty(propertyStringArray(index))
                    hashMap.put(propertyStringArray(index), propertyObject.toString())
                    index += 1
                }
            }
        }
        return hashMap
    }

}


