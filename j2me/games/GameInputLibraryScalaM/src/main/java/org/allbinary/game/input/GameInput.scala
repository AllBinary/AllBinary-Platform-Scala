/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class GameInput(param_gameKeyEventList : BasicArrayList, param_removalGameKeyEventList : BasicArrayList) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var gameKeyEventList : BasicArrayList = null

    private var removalGameKeyEventList : BasicArrayList = null

    var isRemoveDuplicateKeyPresses : Boolean = false

    //Constructor
    {
        val gameKeyEventList : BasicArrayList = param_gameKeyEventList
        val removalGameKeyEventList : BasicArrayList = param_removalGameKeyEventList
        this.gameKeyEventList = gameKeyEventList
        this.removalGameKeyEventList = removalGameKeyEventList
        this.isRemoveDuplicateKeyPresses = Features.getInstance().isFeature(InputFeatureFactory.getInstance().REMOVE_DUPLICATE_KEY_PRESSES)
    }

    def add(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        //TODO TWB - fix all null and duplicate issue for better performance
        if (this.isRemoveDuplicateKeyPresses && this.gameKeyEventList.contains(gameKeyEvent)) {
            //this.logUtil.putF("Danger Danger Danger: Duplicate GameKeyEvent", this, this.commonStrings.ADD);
            return
        }
        if (gameKeyEvent != null) {
            this.gameKeyEventList.add(gameKeyEvent)
        } else {
            this.logUtil.putF("Danger Passed Null GameKeyEvent", this, this.commonStrings.ADD)
        }
    }

    def addForRemoval(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        this.removalGameKeyEventList.add(gameKeyEvent)
    }

    def isForRemoval(gameKeyEvent : GameKeyEvent) : Boolean = this.synchronized {
        return this.removalGameKeyEventList.contains(gameKeyEvent)
    }

    def clear() : Unit = this.synchronized {
        this.gameKeyEventList.clear()
    }

    def removeNonAIInputGameKeyEvents() : Unit = this.synchronized {
        var list : BasicArrayList = this.gameKeyEventList
        //System.out.println("List Size Before: " + list.size());
        var gameKeyEvent : GameKeyEvent = null

        {
            var index : Int = list.size()
            while ({ index -= 1; index } >= 0) {
                gameKeyEvent = list.objectArray(index).asInstanceOf[GameKeyEvent]
                //if (((GameKeyEventSourceInterface) gameKeyEvent.getSource()).getSourceId() != 1) {
                if (gameKeyEvent.getSourceId() != 1) {
                    list.removeAt(index)
                }
            }
        }
    }

    /*    public synchronized void removeDuplicates(GameKeyEvent gameKeyEvent) {       BasicArrayList list = this.gameKeyEventList;       Object object = gameKeyEvent;       final int size = list.size();       for (int index = 0; index < size; index++) {          if (list.get(index) == object) {             list.remove(index);          }       }    }    */
    def update() : Unit = this.synchronized {
        var removeList : BasicArrayList = this.removalGameKeyEventList
        var list : BasicArrayList = this.gameKeyEventList
        var size : Int = removeList.size()

        {
            var index : Int = 0
            while (index < size) {
                var anyType : Object = removeList.objectArray(index)

                {
                    var index2 : Int = list.size()
                    while ({ index2 -= 1; index2 } >= 0) {
                        if (list.objectArray(index2) eq anyType) {
                            list.removeAt(index2)
                        }
                    }
                }
                index += 1
            }
        }
        //this.gameKeyEventList.remove();
        removeList.clear()
    }

    /**      * @return the gameKeyEventList      */
    def getRemovalGameKeyEventList() : BasicArrayList = {
        return this.removalGameKeyEventList
    }

    /**      * @return the gameKeyEventList      */
    def getGameKeyEventList() : BasicArrayList = {
        return this.gameKeyEventList
    }

}


