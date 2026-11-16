/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.game.configuration.feature.GameFeature

class RaceTrackGameFeature(param_name : String) extends GameFeature(param_name) {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGameFeature.{MINI_MAP as _, AUTO_FINISH_AI as _, *}
    def MINI_MAP : GameFeature = _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGameFeature.MINI_MAP
    def AUTO_FINISH_AI : GameFeature = _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGameFeature.AUTO_FINISH_AI

    //Constructor
    {
        val name : String = param_name
    }

}

object RaceTrackGameFeature {
    val MINI_MAP : GameFeature = new RaceTrackGameFeature("Mini Map")

    val AUTO_FINISH_AI : GameFeature = new RaceTrackGameFeature("Auto Finish AI")

}


