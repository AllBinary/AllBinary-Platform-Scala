/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.score

import _root_.org.allbinary.game.score.Scoreable

class ScoreableAddOnlyForHud(param_scoreVectorGraphic : ScoreHudWidget) extends Scoreable(0) {

    private var scoreHudWidget : ScoreHudWidget = null

    //Constructor
    {
        val scoreVectorGraphic : ScoreHudWidget = param_scoreVectorGraphic
        this.scoreHudWidget = scoreVectorGraphic
        this.getScoreHudWidget().set(0)
    }

    override def removePoints(points : Int) : Unit = {
    }

    override def addPoints(points : Int) : Unit = {
        super.addPoints(points)
        this.getScoreHudWidget().add(points)
    }

    def getScoreHudWidget() : ScoreHudWidget = {
        return this.scoreHudWidget
    }

}


