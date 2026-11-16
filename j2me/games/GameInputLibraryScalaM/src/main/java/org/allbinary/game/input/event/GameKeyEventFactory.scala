/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class GameKeyEventFactory private() {
    import _root_.org.allbinary.game.input.event.GameKeyEventFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val TOUCH_BUTTON_SOURCE_ID : Int = 2

    val MOTION_GESTURE_SOURCE_ID : Int = 3

    private val MAX_SOURCES : Int = 4

    //private final String SOURCE_ID = "sourceId";    
    private var ARRAY : Array[Array[GameKeyEvent]] = Array.ofDim[GameKeyEvent](this.MAX_SOURCES, InputFactory.getInstance().MAX)

    def init() : Unit = {
        //this.logUtil.putF(this.commonStrings.START, "GameKeyEventFactory", commonStrings.INIT);
        val nullUtil : NullUtil = NullUtil.getInstance()
        /*         for (int index2 = 0; index2 < MAX; index2++)         {             this.ARRAY[index2] = new GameKeyEvent(null, index2);         }         */
        val size : Int = InputFactory.getInstance().MAX

        {
            var index : Int = this.MAX_SOURCES
            while ({ index -= 1; index } >= 0) {

                {
                    var index2 : Int = size
                    while ({ index2 -= 1; index2 } >= 0) {
                        //this.logUtil.putF("TWB index2: " + index2 + " src: " + index, this, "getInstanceForKey");
                        this.ARRAY(index)(index2) = GameKeyEvent.createEvent(nullUtil.NULL_OBJECT, index, index2)
                    }
                }
            }
        }
    }

    def getInstanceForKey(anyType : GameKeyEventSourceInterface, key : Int) : GameKeyEvent = {
        //this.logUtil.putF(this.commonStrings.START, this, SOURCE_ID + object.getSourceId());
        val gameKeyEvent : GameKeyEvent = this.ARRAY(anyType.getSourceId())(key)
        //gameKeyEvent.init(object);
        return gameKeyEvent
    }

    def getInstanceForInput(anyType : GameKeyEventSourceInterface, input : Input) : GameKeyEvent = {
        //this.logUtil.putF(this.commonStrings.START_LABEL, this, SOURCE_ID + object.getSourceId());
        val gameKeyEvent : GameKeyEvent = this.ARRAY(anyType.getSourceId())(input.getId())
        //gameKeyEvent.init(object);
        return gameKeyEvent
    }

}

object GameKeyEventFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameKeyEventFactory = {
        if (GameKeyEventFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            GameKeyEventFactory.instance = new GameKeyEventFactory()
        }
        return GameKeyEventFactory.instance.asInstanceOf[GameKeyEventFactory]
    }

}


