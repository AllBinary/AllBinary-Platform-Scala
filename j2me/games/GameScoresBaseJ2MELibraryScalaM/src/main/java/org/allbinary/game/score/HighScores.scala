/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class HighScores(param_name : String, param_heading : String, param_columnTwoHeading : String) extends HighScoresInterface {

    private var orderedHighScoresList : BasicArrayList = new BasicArrayListD()

    // = "Score"
    private var name : String = null

    private var heading : String = null

    private val columnOneHeading : String = "Name"

    private var columnTwoHeading : String = null

    //Constructor
    {
        val name : String = param_name
        val heading : String = param_heading
        val columnTwoHeading : String = param_columnTwoHeading
        this.name = name
        this.heading = heading
        this.columnTwoHeading = columnTwoHeading
    }

    def setList(orderedHighScoresList : BasicArrayList) : Unit = {
        this.orderedHighScoresList = orderedHighScoresList
    }

    override def getList() : BasicArrayList = {
        return this.orderedHighScoresList
    }

    def getName() : String = {
        return this.name
    }

    override def getTotal() : Int = {
        return this.getList().size()
    }

    override def addHighScore(newHighScore : HighScore) : Unit = {
        this.orderedHighScoresList.add(newHighScore)
    }

    def getHeading() : String = {
        return this.heading
    }

    def getColumnOneHeading() : String = {
        return this.columnOneHeading
    }

    def getColumnTwoHeading() : String = {
        return this.columnTwoHeading
    }

    override def isBestScore(newHighScore : HighScore) : Boolean = {
        return false
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("HighScores: ")
        //stringBuffer.append(this.name);
        stringBuffer.append(this.heading)
        //stringBuffer.append(this.columnTwoHeading);
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(CommonLabels.getInstance().TOTAL_LABEL)
        stringBuffer.appendint(this.orderedHighScoresList.size())
        return stringBuffer.toString()
    }

}


