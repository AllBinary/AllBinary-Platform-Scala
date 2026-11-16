/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.javax.microedition.lcdui.Graphics

class NullLayer private() extends Layer(0, 0) {
    import _root_.org.allbinary.layer.NullLayer.{*}

    override def paint(graphics : Graphics) : Unit = {
    }

}

object NullLayer {
    private val instance : NullLayer = new NullLayer()

    def getInstance() : NullLayer = {
        return NullLayer.instance
    }

}


