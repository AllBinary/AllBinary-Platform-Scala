/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image

class PreResourceImageUtil {
    import _root_.org.allbinary.image.PreResourceImageUtil.{*}

    def encapsulate(image : Image) : Image = {
        return image
    }

    def updateGL(gl : GL, image : Image) : Unit = {
    }

    def update(graphics : Graphics, image : Image) : Unit = {
    }

}

object PreResourceImageUtil {
    private val instance : PreResourceImageUtil = new PreResourceImageUtil()

    /**      * @return the instance      */
    def getInstance() : PreResourceImageUtil = {
        return PreResourceImageUtil.instance
    }

}


