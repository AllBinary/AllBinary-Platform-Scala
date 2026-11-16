/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.ag.layer.hud.basic.notification.GameNotificationHud
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEvent
import _root_.org.allbinary.game.input.PlayerGameInput
import _root_.org.allbinary.game.input.form.NullRTSFormInputFactory
import _root_.org.allbinary.game.input.form.RTSFormInput
import _root_.org.allbinary.game.layer.capital.Capital
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.media.audio.Sound

/**  *  * @author User  */
class NullRTSLayer extends NullPathFindingLayer with RTSPlayerLayerInterface {
    import _root_.org.allbinary.game.layer.NullRTSLayer.{NULL_RTS_LAYER as _, *}
    def NULL_RTS_LAYER : NullRTSLayer = _root_.org.allbinary.game.layer.NullRTSLayer.NULL_RTS_LAYER

    override def getName() : String = {
        throw new RuntimeException()
    }

    override def processInput(layerManager : AllBinaryLayerManager) : Unit = {
        throw new RuntimeException()
    }

    override def initInputProcessors() : Unit = {
        throw new RuntimeException()
    }

    override def getGameNotificationHud() : GameNotificationHud = {
        throw new RuntimeException()
    }

    override def getCurrentScrollSelectionForm() : ScrollSelectionForm = {
        throw new RuntimeException()
    }

    override def setCurrentScrollSelectionForm(currentScrollSelectionForm : ScrollSelectionForm) : Unit = {
        throw new RuntimeException()
    }

    override def getBuildingScrollSelectionForm() : ScrollSelectionForm = {
        throw new RuntimeException()
    }

    override def getPlayerGameInput() : PlayerGameInput = {
        throw new RuntimeException()
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        throw new RuntimeException()
    }

    override def onDestroyed(destroyedEvent : DestroyedEvent) : Unit = {
        throw new RuntimeException()
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        throw new RuntimeException()
    }

    override def getCapital() : Capital = {
        throw new RuntimeException()
    }

    override def getRTSFormInput() : RTSFormInput = {
        return NullRTSFormInputFactory.getInstance()
    }

    override def add(sound : Sound) : Unit = {
        throw new RuntimeException()
    }

    override def getPlayerOwnedRTSLayers() : PlayerOwnedRTSLayers = {
        throw new RuntimeException()
    }

    override def implmentsArtificialIntelligenceCompositeInterface() : Boolean = {
        throw new RuntimeException()
    }

}

object NullRTSLayer {
    val NULL_RTS_LAYER : NullRTSLayer = new NullRTSLayer()

}


