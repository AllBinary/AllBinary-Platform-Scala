/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.DataInputStream
import _root_.java.io.EOFException
import _root_.java.io.IOException
import _root_.javax.microedition.rms.RecordComparator
import _root_.javax.microedition.rms.RecordEnumeration
import _root_.javax.microedition.rms.RecordStore
import _root_.javax.microedition.rms.RecordStoreException
import _root_.javax.microedition.rms.RecordStoreNotFoundException
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.configuration.persistance.NullRecordComparator
import _root_.org.allbinary.game.configuration.persistance.NullRecordFilter
import _root_.org.allbinary.game.configuration.persistance.NullRecordStore
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.persistance.PlatformRecordIdUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class RecordStoreHighScores private(param_abeClientInformation : AbeClientInformationInterface, param_gameInfo : GameInfo, param_name : String, param_heading : String, param_columnTwoHeading : String, param_recordComparatorInterface : RecordComparator) extends HighScores(param_name, param_heading, param_columnTwoHeading) {
    import _root_.org.allbinary.game.score.RecordStoreHighScores.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val platformRecordIdUtil : PlatformRecordIdUtil = PlatformRecordIdUtil.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    //_HighScores
    private val RECORD_ID : String = "_HS"

    private val MAXHIGHSCORES : Int = 100

    private var gameInfo : GameInfo = null

    private var abeClientInformation : AbeClientInformationInterface = null

    private var recordComparatorInterface : RecordComparator = null

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val gameInfo : GameInfo = param_gameInfo
        val name : String = param_name
        val heading : String = param_heading
        val columnTwoHeading : String = param_columnTwoHeading
        val recordComparatorInterface : RecordComparator = param_recordComparatorInterface
        //this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, this.commonStrings.CONSTRUCTOR);
        this.abeClientInformation = abeClientInformation
        this.gameInfo = gameInfo
        this.recordComparatorInterface = recordComparatorInterface
        this.load()
    }

    private def getRecordId(abeClientInformation : AbeClientInformationInterface) : String = {
        return this.platformRecordIdUtil.getRecordId(abeClientInformation, new StringMaker().append(CommonSeps.getInstance().UNDERSCORE).append(this.getName()).append(this.RECORD_ID).toString())
    }

    override def addHighScore(newHighScore : HighScore) : Unit = this.synchronized {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            this.logUtil.putF(new StringMaker().append("Adding HighScore: ").appendlong(newHighScore.getScore()).toString(), this, this.commonStrings.ADD)
            // remove score replacing
            if (this.isTooManyHighScores()) {
                this.logUtil.putF("Removing Lowest Score", this, this.commonStrings.ADD)
                this.removeLowestHighScore()
            }
            recordStore = RecordStore.openRecordStore(this.getRecordId(this.abeClientInformation), true)
            val highScoreBytes : Array[Byte] = newHighScore.getAsBytes()
            val recordId : Int = recordStore.addRecord(highScoreBytes, 0, highScoreBytes.length)
            //this.logUtil.putF("closeRecordStore", this, this.commonStrings.ADD);
            this.load()
        } catch {
            case e : RecordStoreException => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.ADD, e)
            }
            case e : IOException => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.ADD, e)
            }
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.ADD, e)
            }
        } finally {
            try {
                if (recordStore != null) {
                    PreLogUtil.put("Closing RecordStore", this, this.commonStrings.ADD)
                    recordStore.closeRecordStore()
                }
            } catch {
                case e : RecordStoreException => {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.ADD, e)
                }
            }
        }
    }

    private def removeLowestHighScore() : Unit = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            recordStore = RecordStore.openRecordStore(this.getRecordId(this.abeClientInformation), true)
            val recordEnum : RecordEnumeration = recordStore.enumerateRecords(NullRecordFilter.NULL_RECORD_FILTER, NullRecordComparator.NULL_RECORD_COMPARATOR, true)
            val scoreComparator : ScoreComparator = (this.recordComparatorInterface.asInstanceOf[ScoreComparator])
            var bestHighScore : HighScore = new HighScore(-1, "none", GameInfo.NONE, scoreComparator.getBestScore())
            var recordAsBytes : Array[Byte] = null
            var byteArrayInputStream : ByteArrayInputStream = null
            var inputStream : DataInputStream = null

            {
                while (recordEnum.hasNextElement()) {
                    val id : Int = recordEnum.nextRecordId()
                    recordAsBytes = this.tsUtil.getRecord(recordStore, id)
                    if (recordAsBytes != null) {
                        byteArrayInputStream = new ByteArrayInputStream(recordAsBytes)
                        inputStream = new DataInputStream(byteArrayInputStream)
                        val name : String = inputStream.readUTF()
                        val nextScore : Long = inputStream.readLong()
                        val nextCurrentHighScore : HighScore = new HighScore(id, name, GameInfo.NONE, nextScore)
                        if (this.recordComparatorInterface.compare(nextCurrentHighScore.getAsBytes(), bestHighScore.getAsBytes()) == RecordComparator.FOLLOWS) {
                            bestHighScore = nextCurrentHighScore
                        }
                    }
                }
            }
            if (bestHighScore.getId() != -1) {
                this.logUtil.putF(new StringMaker().append("Removing Lowest HighScore: ").appendlong(bestHighScore.getScore()).toString(), this, this.commonStrings.LOAD)
                recordStore.deleteRecord(bestHighScore.getId())
            }
        } catch {
            case e : RecordStoreException => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "removeLowestHighScore", e)
            }
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "removeLowestHighScore", e)
            }
        } finally {
            try {
                if (recordStore != null) {
                    PreLogUtil.put("Closing RecordStore", this, "removeLowestHighScore")
                    recordStore.closeRecordStore()
                }
            } catch {
                case e : RecordStoreException => {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "removeLowestHighScore", e)
                }
            }
        }
    }

    // should be in order of score
    private def load() : Unit = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            recordStore = RecordStore.openRecordStore(this.getRecordId(this.abeClientInformation), true)
            //this.logUtil.putF(recordStore.getName(), this, this.commonStrings.LOAD);
            this.setList(new BasicArrayListD())
            val recordEnum : RecordEnumeration = recordStore.enumerateRecords(NullRecordFilter.NULL_RECORD_FILTER, NullRecordComparator.NULL_RECORD_COMPARATOR, true)
            //this.logUtil.putF("first hasNextElement: " + recordEnum.hasNextElement(), this, this.commonStrings.LOAD);
            var recordAsBytes : Array[Byte] = null
            var byteArrayInputStream : ByteArrayInputStream = null
            var inputStream : DataInputStream = null

            {
                while (recordEnum.hasNextElement()) {
                    val id : Int = recordEnum.nextRecordId()
                    //this.logUtil.putF("id: " + id, this, this.commonStrings.LOAD);
                    recordAsBytes = this.tsUtil.getRecord(recordStore, id)
                    //this.logUtil.putF("recordAsBytes: " + recordAsBytes, this, this.commonStrings.LOAD);
                    if (recordAsBytes != null) {
                        byteArrayInputStream = new ByteArrayInputStream(recordAsBytes)
                        inputStream = new DataInputStream(byteArrayInputStream)
                        try {
                            val name : String = inputStream.readUTF()
                            val score : Long = inputStream.readLong()
                            val newHighScore : HighScore = new HighScore(id, name, GameInfo.NONE, score)
                            // Sadly this issue is common on many devices
                            val list : BasicArrayList = this.getList()
                            var size : Int = list.size()
                            var lastIndex : Int = size

                            {
                                var index : Int = 0
                                scala.util.boundary { (break_N77887 : scala.util.boundary.Label[Unit]) ?=>
                                    while (index < size) {
                                        val highScore : HighScore = list.objectArray(index).asInstanceOf[HighScore]
                                        // Found a spot then insert at that point
                                        if (this.recordComparatorInterface.compare(newHighScore.getAsBytes(), highScore.getAsBytes()) == RecordComparator.PRECEDES) {
                                            lastIndex = index
                                            scala.util.boundary.break()(using break_N77887)
                                        }
                                        index += 1
                                    }
                                }
                            }
                            //this.logUtil.putF(new StringMaker().append("Loading HighScore: ").append(newHighScore.getScore()).append(" for: ").append(this.getName()).toString(), this, this.commonStrings.LOAD);
                            list.addAt(lastIndex, newHighScore)
                        } catch {
                            case breakException: scala.util.boundary.Break[?] => throw breakException
                            case e : EOFException => {
                                this.logUtil.put("EOF", this, this.commonStrings.LOAD, e)
                                throw e
                            }
                        }
                    }
                }
            }
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : RecordStoreNotFoundException => {
                this.logUtil.put("No High Scores", this, this.commonStrings.LOAD, e)
            }
            case e : RecordStoreException => {
                this.logUtil.put(this.commonStrings.UNKNOWN, this, this.commonStrings.LOAD, e)
            }
            case e : IOException => {
                this.logUtil.put(this.commonStrings.UNKNOWN, this, this.commonStrings.LOAD, e)
            }
            case e : Exception => {
                this.logUtil.put(this.commonStrings.UNKNOWN, this, this.commonStrings.LOAD, e)
            }
        } finally {
            try {
                if (recordStore != null) {
                    PreLogUtil.put("Closing RecordStore", this, this.commonStrings.LOAD)
                    recordStore.closeRecordStore()
                }
            } catch {
                case e : RecordStoreException => {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.LOAD, e)
                }
            }
        }
    }

    private def isTooManyHighScores() : Boolean = {
        if ((this.getList() != null) && (this.getList().size() < this.MAXHIGHSCORES)) {
            return false
        } else {
            this.logUtil.putF(new StringMaker().append("HighScores RecordStore Max Reached: ").appendint(this.MAXHIGHSCORES).toString(), this, "isTooManyHighScores")
            return true
        }
        throw new IllegalStateException()
    }

    override def isBestScore(newHighScore : HighScore) : Boolean = this.synchronized {
        try {
            // search scores and validate if a high score has been acheived
            if (!this.isTooManyHighScores()) {
                this.logUtil.putF("Slot Available for a High Score", this, "isBestScore")
                return true
            } else {
                // Enumeration enumeration = this.highScoresHashTable.keys();
                val list : BasicArrayList = this.getList()
                val size : Int = list.size()

                {
                    var index : Int = 0
                    while (index < size) {
                        val highScore : HighScore = list.objectArray(index).asInstanceOf[HighScore]
                        if (this.recordComparatorInterface.compare(newHighScore.getAsBytes(), highScore.getAsBytes()) == RecordComparator.FOLLOWS) {
                            this.logUtil.putF("Obtained a High Score", this, "isBestScore")
                            return true
                        }
                        index += 1
                    }
                }
            }
            this.logUtil.putF("Not a High Score", this, "isBestScore")
            return false
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.ADD, e)
                throw e
            }
        }
        throw new IllegalStateException()
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(super.toString())
        val list : BasicArrayList = this.getList()
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                val highScore : HighScore = list.objectArray(index).asInstanceOf[HighScore]
                stringBuffer.append(highScore.getScoreString())
                stringBuffer.append(CommonSeps.getInstance().COMMA_SEP)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}

object RecordStoreHighScores {
    private val hashTable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def getInstance(abeClientInformation : AbeClientInformationInterface, gameInfo : GameInfo, highScoreName : String, heading : String, columnTwoHeading : String, recordComparatorInterface : RecordComparator) : HighScores = this.synchronized {
        val highScoresCanBeNull : Object = RecordStoreHighScores.hashTable.get(highScoreName.asInstanceOf[Object])
        if (highScoresCanBeNull == null) {
            val highScores : HighScores = new RecordStoreHighScores(abeClientInformation, gameInfo, highScoreName, heading, columnTwoHeading, recordComparatorInterface)
            RecordStoreHighScores.hashTable.put(highScores.getName(), highScores)
            return highScores
        }
        return highScoresCanBeNull.asInstanceOf[HighScores]
    }

}


