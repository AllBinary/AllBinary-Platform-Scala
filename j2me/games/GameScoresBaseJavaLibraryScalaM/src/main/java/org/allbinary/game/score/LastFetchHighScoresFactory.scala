/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.logic.NullUtil

/**  *  * @author User  */
class LastFetchHighScoresFactory {
    import _root_.org.allbinary.game.score.LastFetchHighScoresFactory.{*}

    var highScoresArray : Array[HighScores] = NoHighScoresFactory.getInstance().NO_HIGH_SCORES

}

object LastFetchHighScoresFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    /**      * @return the instance      */
    def getInstance() : LastFetchHighScoresFactory = {
        if (LastFetchHighScoresFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            LastFetchHighScoresFactory.instance = new LastFetchHighScoresFactory()
        }
        return LastFetchHighScoresFactory.instance.asInstanceOf[LastFetchHighScoresFactory]
    }

}


