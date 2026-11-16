/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventListenerInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.util.BasicArrayList

class PlayerGameInput(param_gameKeyEventList : BasicArrayList, param_removalGameKeyEventList : BasicArrayList, param_playerInputId : Int) extends GameInput(param_gameKeyEventList, param_removalGameKeyEventList) with GameKeyEventListenerInterface {

    val gameInputStrings : GameInputStrings = GameInputStrings.getInstance()

    private var playerInputId : Int = 0

    //Constructor
    {
        val gameKeyEventList : BasicArrayList = param_gameKeyEventList
        val removalGameKeyEventList : BasicArrayList = param_removalGameKeyEventList
        val playerInputId : Int = param_playerInputId
        this.playerInputId = playerInputId
    }

    /*    public synchronized void add(GameKeyEvent gameKeyEvent)    {        this.logUtil.putF(this.commonStrings.START_LABEL).append(gameKeyEvent.getSource()).append(" ").append(((GameKeyEventSourceInterface)gameKeyEvent.getSource()).getId(), this, this.commonStrings.ADD);        super.add(gameKeyEvent);    }    */
    override def onPressGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        //PreLogUtil.put(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(gameKeyEvent.toString()).toString(), this, gameInputStrings.ON_PRESS_GAME_KEY);
        this.add(gameKeyEvent)
        this.addForRemoval(gameKeyEvent)
    }

    override def onDownGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        //PreLogUtil.put(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(gameKeyEvent.toString()).toString(), this, gameInputStrings.ON_DOWN_GAME_KEY);
        this.add(gameKeyEvent)
    }

    def onDownKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        //PreLogUtil.put(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(gameKeyEvent.toString()).toString(), this, gameInputStrings.ON_DOWN_GAME_KEY);
        this.add(gameKeyEvent)
        this.addForRemoval(gameKeyEvent)
    }

    def onDownKey(gameKeyEvent : Integer) : Unit = this.synchronized {
        PreLogUtil.put(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(gameKeyEvent.toString()).toString(), this, this.gameInputStrings.ON_DOWN_GAME_KEY)
    }

    override def onUpGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        //PreLogUtil.put(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(gameKeyEvent.toString()).toString(), this, gameInputStrings.ON_UP_GAME_KEY);
        this.addForRemoval(gameKeyEvent)
    }

    def onUpKeyEvent(gameKeyEvent : Integer) : Unit = this.synchronized {
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    /**      * @return the playerInputId      */
    def getPlayerInputId() : Int = {
        return this.playerInputId
    }

}


