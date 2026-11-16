/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.layer.AllBinaryLayerManager

class GameInputProcessor() {
    import _root_.org.allbinary.game.input.GameInputProcessor.{*}

    def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
    }

    def processReleasedEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
    }

    def processAnalog(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent, analogValue : Int) : Unit = {
    }

    def process(allbinaryLayerManager : AllBinaryLayerManager, keyAsInteger : Integer) : Unit = {
    }

    def processReleased(allbinaryLayerManager : AllBinaryLayerManager, keyAsInteger : Integer) : Unit = {
    }

}

object GameInputProcessor {
    private val instance : GameInputProcessor = new GameInputProcessor()

    def getInstance() : GameInputProcessor = {
        return GameInputProcessor.instance
    }

}


