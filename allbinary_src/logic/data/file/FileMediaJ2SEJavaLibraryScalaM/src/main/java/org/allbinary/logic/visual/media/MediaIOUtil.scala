/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.media

import _root_.javax.imageio.ImageIO

/**  *  * @author user  */
class MediaIOUtil {
    import _root_.org.allbinary.logic.visual.media.MediaIOUtil.{*}

    def getReaderFormatNames() : Array[String] = {
        return ImageIO.getReaderFormatNames()
    }

    def getWriterFormatNames() : Array[String] = {
        return ImageIO.getWriterFormatNames()
    }

}

object MediaIOUtil {
    private val instance : MediaIOUtil = new MediaIOUtil()

    /**      * @return the instance      */
    def getInstance() : MediaIOUtil = {
        return MediaIOUtil.instance
    }

}


