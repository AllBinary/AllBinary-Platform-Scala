/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.ag.layer.hud.basic.notification.GameNotificationHudCompositeInterface
import _root_.org.allbinary.game.input.BuildMenuCompositeInterface
import _root_.org.allbinary.game.input.form.RTSFormInput
import _root_.org.allbinary.game.layer.capital.Capital
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEventListenerInterface
import _root_.org.allbinary.game.input.PlayerGameInputCompositeInterface
import _root_.org.allbinary.game.tick.TickableInterface
import _root_.org.allbinary.media.audio.Sound

trait RTSPlayerLayerInterface extends GameNotificationHudCompositeInterface with BuildMenuCompositeInterface with PlayerGameInputCompositeInterface with DestroyedEventListenerInterface with TickableInterface with PathFindingLayerInterface {

    def getCapital() : Capital

    def getRTSFormInput() : RTSFormInput

    def add(sound : Sound) : Unit

    def getPlayerOwnedRTSLayers() : PlayerOwnedRTSLayers

    def implmentsArtificialIntelligenceCompositeInterface() : Boolean

}


