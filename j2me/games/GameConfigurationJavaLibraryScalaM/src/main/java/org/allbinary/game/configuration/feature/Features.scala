/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.org.allbinary.game.configuration.event.GameFeatureEvent
import _root_.org.allbinary.game.configuration.event.GameFeatureEventHandler
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class Features private() {
    import _root_.org.allbinary.game.configuration.feature.Features.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var list : BasicArrayList = null

    private var defaultList : BasicArrayList = null

    //Constructor
    {
        this.list = new BasicArrayListD()
        this.defaultList = new BasicArrayListD()
        this.init()
    }

    //For default or reload required features
    def addDefault(gameFeature : Feature) : Unit = {
        //      commonStrings.START_LABEL).append(gameFeature.toString(), //    "GameFeature", "addDefault");
        this.add(gameFeature)
        if (!this.defaultList.contains(gameFeature)) {
            this.defaultList.add(gameFeature)
        }
    }

    def add(gameFeature : Feature) : Unit = {
        if (!this.list.contains(gameFeature)) {
            //            }
            this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(gameFeature.toString()).toString(), this, this.commonStrings.ADD)
            this.list.add(gameFeature)
            GameFeatureEventHandler.getInstance().fireEvent(new GameFeatureEvent(gameFeature, gameFeature.toString()))
        }
    }

    //For default or reload required features
    def removeDefault(gameFeature : Feature) : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(gameFeature.toString()).toString(), this, "removeDefault")
        this.remove(gameFeature)
        this.defaultList.remove(gameFeature)
    }

    def remove(gameFeature : Feature) : Unit = {
        if (this.list.contains(gameFeature)) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.REMOVE)
            this.list.remove(gameFeature)
            GameFeatureEventHandler.getInstance().fireEvent(new GameFeatureEvent(gameFeature, gameFeature.toString()))
        }
    }

    private def init() : Unit = {
        try {
            val gameFeatureFactory : GameFeatureFactory = GameFeatureFactory.getInstance()
            val inputFeatureFactory : InputFeatureFactory = InputFeatureFactory.getInstance()
            val sensorFeatureFactory : SensorFeatureFactory = SensorFeatureFactory.getInstance()
            val touchFeatureFactory : TouchFeatureFactory = TouchFeatureFactory.getInstance()
            this.addDefault(gameFeatureFactory.ARTIFICIAL_INTELLEGENCE_PROCESSOR)
            this.addDefault(gameFeatureFactory.COLLIDABLE_INTERFACE_LAYER_PROCESSOR)
            this.addDefault(gameFeatureFactory.GAME_INPUT_LAYER_PROCESSOR)
            this.addDefault(gameFeatureFactory.TICKABLE_LAYER_PROCESSOR)
            this.addDefault(inputFeatureFactory.MULTI_KEY_PRESS)
            this.addDefault(inputFeatureFactory.REMOVE_DUPLICATE_KEY_PRESSES)
            this.addDefault(gameFeatureFactory.SCREEN_SHAKE)
            this.addDefault(gameFeatureFactory.POST_IMAGE_LOADING_MODIFICATION)
            val operatingSystemInterface : GenericOperatingSystem = OperatingSystemFactory.getInstance().getOperatingSystemInstance()
            if (operatingSystemInterface.isOverScan()) {
                this.addDefault(sensorFeatureFactory.NO_ORIENTATION)
                this.addDefault(touchFeatureFactory.HIDE_SCREEN_BUTTONS)
            } else {
                this.addDefault(sensorFeatureFactory.ORIENTATION_SENSORS)
                this.addDefault(touchFeatureFactory.AUTO_HIDE_SHOW_SCREEN_BUTTONS)
            }
            // defaultVector.addAll(vector);
            this.addDefault(touchFeatureFactory.TOUCH_ENABLED)
            this.addDefault(MainFeatureFactory.getInstance().FULL_SCREEN)
            //this.addDefault(MainFeatureFactory.getInstance().LOAD_ALL);
            this.addDefault(MainFeatureFactory.getInstance().LOAD_ONDEMAND)
        } catch {
            case e : Exception => {
                PreLogUtil.putOE(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
            }
        }
    }

    //For default or reload required features
    def isDefault(gameFeature : Feature) : Boolean = {
        return this.defaultList.contains(gameFeature)
    }

    def isFeature(gameFeature : Feature) : Boolean = {
        return this.list.contains(gameFeature)
    }

    def toggle(gameFeature : Feature) : Unit = {
        if (this.isFeature(gameFeature)) {
            this.remove(gameFeature)
        } else {
            this.add(gameFeature)
        }
    }

}

object Features {
    private var SINGLETON : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : Features = {
        if (Features.SINGLETON eq NullUtil.getInstance().NULL_OBJECT) {
            Features.SINGLETON = new Features()
        }
        return Features.SINGLETON.asInstanceOf[Features]
    }

}


