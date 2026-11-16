/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class GameKeyEvent(param_anyType : Object, param_sourceId : Int, param_originalKey : Int, param_gameActionKey : Int, param_key : Int, param_repeated : Boolean) extends AllBinaryEventObject(param_anyType) {
    import _root_.org.allbinary.game.input.event.GameKeyEvent.{NONE as _, *}
    def NONE : GameKeyEvent = _root_.org.allbinary.game.input.event.GameKeyEvent.NONE

    private var sourceId : Int = 0

    //input info
    private var repeated : Boolean = false

    private var key : Int = 0

    private var gameActionKey : Int = 0

    private var originalKey : Int = 0

    //Constructor
    {
        val anyType : Object = param_anyType
        val sourceId : Int = param_sourceId
        val originalKey : Int = param_originalKey
        val gameActionKey : Int = param_gameActionKey
        val key : Int = param_key
        val repeated : Boolean = param_repeated
        this.sourceId = sourceId
        this.setOriginalKey(originalKey)
        this.key = key
        this.setGameActionKey(gameActionKey)
        this.setRepeatEvents(repeated)
    }

    def init(anyType : Object) : Unit = {
        this.setSource(anyType)
    }

    /*    public void init(Object object, int key)    {       //this.setOriginalKey(NO_KEY);       //this.setGameActionKey(NO_KEY);       this.setSource(object);       this.setKey(key);    }    */
    private def setRepeatEvents(repeated : Boolean) : Unit = {
        this.repeated = repeated
    }

    def hasRepeatEvents() : Boolean = {
        return this.repeated
    }

    def getKey() : Int = {
        return this.key
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        /*       stringBuffer.append("GameKeyEvent: ");       stringBuffer.append("\nOriginal Key: ");       stringBuffer.append(this.getOriginalKey());       stringBuffer.append("\nGame Action Key: ");       stringBuffer.append(this.getGameActionKey());       stringBuffer.append("\nMapped Key: ");       */
        stringBuffer.append("\nKey: ")
        stringBuffer.appendint(this.getKey())
        //stringBuffer.append("Fix Me");
        return stringBuffer.toString()
    }

    def getOriginalKey() : Int = {
        return this.originalKey
    }

    def setOriginalKey(originalKey : Int) : Unit = {
        this.originalKey = originalKey
    }

    def getGameActionKey() : Int = {
        return this.gameActionKey
    }

    def setGameActionKey(gameActionKey : Int) : Unit = {
        this.gameActionKey = gameActionKey
    }

    def getSourceId() : Int = {
        return this.sourceId
    }

}

object GameKeyEvent {
    def createEvent(anyType : Object, sourceId : Int, key : Int) : GameKeyEvent = {
        return new GameKeyEvent(anyType, sourceId, 0, 0, key, false)
    }

    val NONE : GameKeyEvent = new GameKeyEvent(NullUtil.getInstance().NULL_OBJECT, -1, -1, -1, -1, false)

}


