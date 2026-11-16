/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.event

import _root_.org.allbinary.game.configuration.feature.Feature
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BaseChangedGameFeatureListener extends GameFeatureListenerInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val gameFeatureUtil : GameFeatureUtil = GameFeatureUtil.getInstance()

    val list : BasicArrayList = new BasicArrayListD()

    private var changed : Boolean = true

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(CommonStrings.getInstance().NOT_IMPLEMENTED, this)
    }

    override def onGameFeatureChange(gameFeatureEvent : GameFeatureEvent) : Unit = {
        this.logUtil.putF(new StringMaker().append(this.gameFeatureUtil.GAME_FEATURE_CHANGED).append(gameFeatureEvent.getWhatChanged()).toString(), this, this.gameFeatureUtil.ON_GAME_FEATURE_CHANGE)
        this.list.add(gameFeatureEvent.getGameOption())
        this.setChanged(true)
    }

    def add(gameFeature : Feature) : Unit = {
        this.list.add(gameFeature)
    }

    def remove(gameFeature : Feature) : Unit = {
        this.list.remove(gameFeature)
    }

    def setChanged(initialized : Boolean) : Unit = {
        this.changed = initialized
        if (!this.isChanged()) {
            this.list.clear()
        }
    }

    def isChangedFeature(gameFeature : Feature) : Boolean = {
        val isChanged : Boolean = this.list.contains(gameFeature)
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("GameFeature: ")
        stringBuffer.append(StringUtil.getInstance().toString(gameFeature))
        stringBuffer.append(" isFeature: ")
        stringBuffer.appendboolean(Features.getInstance().isFeature(gameFeature))
        stringBuffer.append(" isChanged: ")
        stringBuffer.appendboolean(isChanged)
        this.logUtil.putF(stringBuffer.toString(), this, "isChanged")
        return isChanged
    }

    def isChanged() : Boolean = {
        return this.changed
    }

}


