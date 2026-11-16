/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.layer.RTSGameStrings
import _root_.org.allbinary.game.layer.RTSInterface
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.TechnologyRTSInterfaceImageItem
import _root_.org.allbinary.game.layer.capital.Capital
import _root_.org.allbinary.game.rts.technology.event.TechEventHandler
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.media.audio.BuildingSound
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface

/**  *  * @author user  */
class TechRTSFormInput(param_groupInterface : Array[Group]) extends RTSFormInput(param_groupInterface) {

    private val EVENT : AllBinaryEventObject = new AllBinaryEventObject(this)

    var noMoneyGameNotificationEvent : GameNotificationEvent = null

    //Constructor
    {
        val groupInterface : Array[Group] = param_groupInterface
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        this.noMoneyGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().NO_MONEY, SmallIntegerSingletonFactory.getInstance().getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.noMoneyGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
    }

    override def processGameSpecific(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, itemIndex : Int) : Unit = {
        super.process(layerManager)
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val stringMaker : StringMaker = new StringMaker()
        val technologyRTSInterfaceImageItem : TechnologyRTSInterfaceImageItem = item.asInstanceOf[TechnologyRTSInterfaceImageItem]
        val rtsInterface : RTSInterface = technologyRTSInterfaceImageItem.getRtsInterface()
        this.logUtil.putF(stringMaker.append("isUpgradeable: ").appendboolean(rtsInterface.isUpgradeable()).toString(), this, commonStrings.PROCESS)
        if (rtsInterface.isUpgradeable()) {
            val cost : Int = rtsInterface.getUpgradeCost()
            val capital : Capital = rtsPlayerLayerInterface.getCapital()
            stringMaker.delete(0, stringMaker.length())
            this.logUtil.putF(stringMaker.appendint(cost).append("<=").appendint(capital.getTotalMoney()).toString(), this, commonStrings.PROCESS)
            if (cost <= capital.getTotalMoney()) {
                rtsPlayerLayerInterface.add(BuildingSound.getInstance())
                capital.removeMoney(cost)
                rtsInterface.upgrade()
                technologyRTSInterfaceImageItem.update()
                //Items must be updated for changes including but not limited to cost
                TechEventHandler.getInstance().fireEvent(this.EVENT)
            } else {
                rtsPlayerLayerInterface.add(ErrorSound.getInstance())
                if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                    GameNotificationEventHandler.getInstance().fireEvent(this.noMoneyGameNotificationEvent)
                }
            }
        }
    }

}


