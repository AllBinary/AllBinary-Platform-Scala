/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.util.CircularIndexUtil

class HighScoresHelper extends HighScoresHelperBase {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val circularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstanceAt(0, 0)

    var lastIndex : Int = -1

    override def setHighScoresArray(highScoresArrayP : Array[HighScores]) : Unit = {
        super.setHighScoresArray(highScoresArrayP)
        this.circularIndexUtil.setSize(this.highScoresArrayP.length)
    }

    override def getNextHighScores() : HighScores = {
        var highScores : HighScores = this.highScoresArrayP(this.circularIndexUtil.getIndex())
        //just in case infinite loop
        var index : Int = 0

        {
            while (((highScores.getTotal() < 1) || (this.lastIndex == this.circularIndexUtil.getIndex())) && (index < this.highScoresArrayP.length)) {
                this.circularIndexUtil.next()
                highScores = this.highScoresArrayP(this.circularIndexUtil.getIndex())
                //PreLogUtil.put("Selecting: " + highScores.toString(), this, "getSelectHighScores");
                index += 1
            }
        }
        this.lastIndex = this.circularIndexUtil.getIndex()
        //PreLogUtil.put(highScores.toString(), this, "getSelectHighScores");
        return highScores
    }

    override def isAnyHighScores() : Boolean = {
        if (this.highScoresArrayP.length < 1) {
            //PreLogUtil.put("No Scores", this, "isAnyHighScores");
            return false
        }
        var anyScores : Boolean = false
        var highScores : HighScores = null
        //PreLogUtil.put("Searching Scores", this, "isAnyHighScores");

        {
            var index : Int = this.highScoresArrayP.length - 1
            while (index >= 0) {
                highScores = this.highScoresArrayP(index)
                if (highScores.getTotal() > 0) {
                    //PreLogUtil.put("Found: " + highScores.toString(), this, "isAnyHighScores");
                    anyScores = true
                }
                index -= 1
            }
        }
        return anyScores
    }

}


