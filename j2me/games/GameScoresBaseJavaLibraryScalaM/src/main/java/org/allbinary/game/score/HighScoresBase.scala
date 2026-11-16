/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.string.CommonStrings

class HighScoresBase() extends HighScoresFactoryInterface {

    var commonStrings : CommonStrings = CommonStrings.getInstance()

    override def fetchHighScores(gameInfo : GameInfo, highScoresResultsListener : HighScoresResultsListener) : Unit = {
        throw new RuntimeException()
    }

    override def fetchHighScoresPreload(gameInfo : GameInfo, highScoresResultsListener : HighScoresResultsListener, preload : Boolean) : Unit = {
        throw new RuntimeException()
    }

    override def createHighScoresHelper() : HighScoresHelperBaseInterface = {
        throw new RuntimeException()
    }

}


