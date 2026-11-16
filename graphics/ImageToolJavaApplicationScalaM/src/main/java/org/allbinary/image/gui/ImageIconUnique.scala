/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.java.awt.image.BufferedImage
import _root_.javax.swing.*

class ImageIconUnique(param_bufferedImage : BufferedImage, param_index : Int) extends ImageIcon(param_bufferedImage) {

    private var id : Int = 0

    //Constructor
    {
        val bufferedImage : BufferedImage = param_bufferedImage
        val index : Int = param_index
        this.setId(index)
    }

    def getId() : Int = {
        return this.id
    }

    def setId(id : Int) : Unit = {
        this.id = id
    }

}


