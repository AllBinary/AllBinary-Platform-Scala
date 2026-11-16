/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.special

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.layer.AllBinaryLayerManager

trait SpecialGameInputInterface extends PaintableInterface {

    def up() : Unit

    def down() : Unit

    def right() : Unit

    def left() : Unit

    def strafeLeft() : Unit

    def strafeRight() : Unit

    def fire(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit

    def special1(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit

    def special2(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit

    def special3(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit

    def special4(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit

    def special5(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit

}


