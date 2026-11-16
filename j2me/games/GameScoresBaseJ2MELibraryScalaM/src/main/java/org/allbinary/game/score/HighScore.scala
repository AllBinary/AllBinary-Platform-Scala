/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.DataOutputStream
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class HighScore(param_id : Int, param_name : String, param_gameInfo : GameInfo, param_score : Long) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var id : Int = 0

    private var name : String = null

    private var gameInfo : GameInfo = null

    private var score : Long = 0L

    private var scoreString : String = null

    //Constructor
    {
        val id : Int = param_id
        val name : String = param_name
        val gameInfo : GameInfo = param_gameInfo
        val score : Long = param_score
        this.id = id
        this.name = name
        this.gameInfo = gameInfo
        this.score = score
        this.scoreString = _root_.java.lang.Long.toString(this.score)
    }

    def getId() : Int = {
        return this.id
    }

    def getName() : String = {
        return this.name
    }

    def getScore() : Long = {
        return this.score
    }

    def getAsBytes() : Array[Byte] = {
        val byteArrayOutputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
        val outputStream : DataOutputStream = new DataOutputStream(byteArrayOutputStream)
        outputStream.writeUTF(this.getName())
        outputStream.writeLong(this.getScore())
        return byteArrayOutputStream.toByteArray()
    }

    def getGameInfo() : GameInfo = {
        return this.gameInfo
    }

    def getScoreString() : String = {
        return this.scoreString
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    override def toString() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        return new StringMaker().append(this.name).append(commonSeps.COLON).appendlong(this.score).append(commonSeps.FORWARD_SLASH).append(this.scoreString).toString()
    }

}


