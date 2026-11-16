/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.string.CommonStrings

class NullHighScoresSingletonFactory {
    import _root_.org.allbinary.game.score.NullHighScoresSingletonFactory.{*}

}

object NullHighScoresSingletonFactory {
    private val SINGLETON : HighScores = new HighScores(CommonStrings.getInstance().LOADING, "High Scores Not Loaded", CommonStrings.getInstance().PERIODS)

    def getInstance() : HighScores = {
        return NullHighScoresSingletonFactory.SINGLETON
    }

}


