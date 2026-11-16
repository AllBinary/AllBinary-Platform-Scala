/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.media

import _root_.java.awt.image.BufferedImage
import _root_.java.awt.image.RenderedImage
import _root_.javax.imageio.ImageIO
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil

/**  *  * @author user  */
class ImageIOUtil {
    import _root_.org.allbinary.logic.visual.media.ImageIOUtil.{*}

}

object ImageIOUtil {
    def read(file : AbFile) : BufferedImage = {
        return ImageIO.read(AbFileNativeUtil.get(file))
    }

    def write(renderedImage : RenderedImage, name : String, file : AbFile) : Boolean = {
        return ImageIO.write(renderedImage, name, AbFileNativeUtil.get(file))
    }

}


