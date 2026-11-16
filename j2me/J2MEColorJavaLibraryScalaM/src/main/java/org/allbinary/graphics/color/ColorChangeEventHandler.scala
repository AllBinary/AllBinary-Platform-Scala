/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class ColorChangeEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.graphics.color.ColorChangeEventHandler.{*}

}

object ColorChangeEventHandler {
    private val eventHandler : ColorChangeEventHandler = new ColorChangeEventHandler()

    def getInstance() : ColorChangeEventHandler = this.synchronized {
        return ColorChangeEventHandler.eventHandler
    }

}


