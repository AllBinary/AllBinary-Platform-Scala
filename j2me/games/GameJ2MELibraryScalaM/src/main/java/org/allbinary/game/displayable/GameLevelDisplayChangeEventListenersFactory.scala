/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable

import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventHandler
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEventListener
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GameLevelDisplayChangeEventListenersFactory {
    import _root_.org.allbinary.game.displayable.GameLevelDisplayChangeEventListenersFactory.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    final def add(displayChangeEventListener : DisplayChangeEventListener) : Unit = {
        //PreLogUtil.put(commonStrings.START_LABEL).append(displayChangeEventListener, this, "add");
        this.list.add(displayChangeEventListener)
        DisplayChangeEventHandler.getInstance().addListenerInterface(displayChangeEventListener)
    }

    final def clear() : Unit = {
        var displayChangeEventHandler : BasicEventHandler = DisplayChangeEventHandler.getInstance()
        var displayChangeEventListener : DisplayChangeEventListener = null

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                displayChangeEventListener = this.list.objectArray(index).asInstanceOf[DisplayChangeEventListener]
                displayChangeEventHandler.removeListener(displayChangeEventListener)
            }
        }
        this.list.clear()
    }

}

object GameLevelDisplayChangeEventListenersFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : GameLevelDisplayChangeEventListenersFactory = new GameLevelDisplayChangeEventListenersFactory()

    def getInstance() : GameLevelDisplayChangeEventListenersFactory = {
        return GameLevelDisplayChangeEventListenersFactory.instance
    }

}


