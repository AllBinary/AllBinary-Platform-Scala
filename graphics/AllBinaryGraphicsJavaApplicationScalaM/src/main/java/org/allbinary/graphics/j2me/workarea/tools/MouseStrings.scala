/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.org.allbinary.string.CommonSeps

/**  *  * @author user  */
class MouseStrings {
    import _root_.org.allbinary.graphics.j2me.workarea.tools.MouseStrings.{*}

    val MOUSE_PRESSED : String = "mousePressed"

    val MOUSE_RELEASED : String = "mouseReleased"

    val MOUSE_CLICKED : String = "mouseClicked"

    val MOUSE_DRAGGED : String = "mouseDragged"

    val MOUSE_MOVED : String = "mouseMoved"

    val MOUSE_PRESSED_LABEL : String = "MousePressed" + CommonSeps.getInstance().COLON_SEP

    val MOUSE_RELEASED_LABEL : String = "MouseReleased" + CommonSeps.getInstance().COLON_SEP

    val MOUSE_CLICKED_LABEL : String = "MouseClicked" + CommonSeps.getInstance().COLON_SEP

    val MOUSE_DRAGGED_LABEL : String = "MouseDragged" + CommonSeps.getInstance().COLON_SEP

    val MOUSE_MOVED_LABEL : String = "MouseMoved" + CommonSeps.getInstance().COLON_SEP

}

object MouseStrings {
    private val instance : MouseStrings = new MouseStrings()

    /**      * @return the instance      */
    def getInstance() : MouseStrings = {
        return MouseStrings.instance
    }

}


