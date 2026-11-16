/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.util.CircularIndexUtil

class HighScoresHelper2 extends HighScoresHelperBase {

    private val circularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstanceAt(0, 0)

    private var selectedHighScores : HighScores = NullHighScoresSingletonFactory.getInstance()

    override def setSelectedHighScores(selectedHighScores : HighScores) : Unit = {
        this.selectedHighScores = selectedHighScores
    }

    override def getSelectedHighScores() : HighScores = {
        return this.selectedHighScores
    }

    override def setHighScoresArray(highScoresArrayP : Array[HighScores]) : Unit = {
        super.setHighScoresArray(highScoresArrayP)
        this.circularIndexUtil.setSize(this.highScoresArrayP.length)
        this.selectHighScores()
    }

    override def selectHighScores() : Unit = {
        if (this.highScoresArrayP.length == 0) {
            this.setSelectedHighScores(NullHighScoresSingletonFactory.getInstance())
            return
        }
        this.circularIndexUtil.next()
        var highScores : HighScores = this.highScoresArrayP(this.circularIndexUtil.getIndex())
        var index : Int = 0

        {
            while ((highScores.getTotal() < 1) && (index < this.highScoresArrayP.length)) {
                highScores = this.highScoresArrayP(this.circularIndexUtil.next())
                index += 1
            }
        }
        this.setSelectedHighScores(highScores)
    }

}


