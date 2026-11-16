/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

/**  *  * @author user  */
class AnimationEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.animation.AnimationEventHandler.{*}

}

object AnimationEventHandler {
    private val eventHandler : AnimationEventHandler = new AnimationEventHandler()

    def getInstance() : AnimationEventHandler = this.synchronized {
        return AnimationEventHandler.eventHandler
    }

}


