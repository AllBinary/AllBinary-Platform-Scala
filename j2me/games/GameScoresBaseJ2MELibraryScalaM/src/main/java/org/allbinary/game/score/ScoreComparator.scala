/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.DataInputStream
import _root_.java.io.EOFException
import _root_.java.io.IOException
import _root_.javax.microedition.rms.RecordComparator
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class ScoreComparator(param_isHighestBest : Boolean) extends RecordComparator {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var isHighestBest : Boolean = false

    //private String searchName;
    //Constructor
    {
        val isHighestBest : Boolean = param_isHighestBest
        this.isHighestBest = isHighestBest
    }

    def getBestScore() : Long = {
        return (if (this.isHighestBest) _root_.java.lang.Long.MAX_VALUE else 0)
    }

    //Although this imp of RecordComparator works
    override def compare(recordOne : Array[Byte], recordTwo : Array[Byte]) : Int = {
        val byteArrayInputStreamOne : ByteArrayInputStream = new ByteArrayInputStream(recordOne)
        val inputStreamOne : DataInputStream = new DataInputStream(byteArrayInputStreamOne)
        val byteArrayInputStreamTwo : ByteArrayInputStream = new ByteArrayInputStream(recordTwo)
        val inputStreamTwo : DataInputStream = new DataInputStream(byteArrayInputStreamTwo)
        var scoreOne : Long = 0
        var scoreTwo : Long = 0
        try {
            inputStreamOne.readUTF()
            inputStreamTwo.readUTF()
            scoreOne = inputStreamOne.readLong()
            scoreTwo = inputStreamTwo.readLong()
        } catch {
            case e : EOFException => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "compare", e)
            }
            case e : IOException => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "compare", e)
            }
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "compare", e)
            }
        }
        if (this.isHighestBest) {
            return this.getHighTooLow(scoreOne, scoreTwo)
        } else {
            return this.getLowTooHigh(scoreOne, scoreTwo)
        }
        throw new IllegalStateException()
    }

    //high too low
    def getHighTooLow(scoreOne : Long, scoreTwo : Long) : Int = {
        if (scoreOne > scoreTwo) {
            //this.logUtil.putF(scoreOne + " Follows2 " + scoreTwo, this, "compare");
            return RecordComparator.PRECEDES
        } else if (scoreOne < scoreTwo) {
            //this.logUtil.putF(scoreOne + " Precedes2 " + scoreTwo, this, "compare");
            return RecordComparator.FOLLOWS
        } else {
            //this.logUtil.putF(scoreOne + " ==2 " + scoreTwo, this, "compare");
            return RecordComparator.EQUIVALENT
        }
        throw new IllegalStateException()
    }

    //low too high
    def getLowTooHigh(scoreOne : Long, scoreTwo : Long) : Int = {
        if (scoreOne < scoreTwo) {
            //this.logUtil.putF(scoreOne + " Precedes2 " + scoreTwo, this, "compare");
            return RecordComparator.PRECEDES
        } else if (scoreOne > scoreTwo) {
            //this.logUtil.putF(scoreOne + " Follows2 " + scoreTwo, this, "compare");
            return RecordComparator.FOLLOWS
        } else {
            //this.logUtil.putF(scoreOne + " ==2 " + scoreTwo, this, "compare");
            return RecordComparator.EQUIVALENT
        }
        throw new IllegalStateException()
    }

}


