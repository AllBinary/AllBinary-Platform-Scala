/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.org.allbinary.game.configuration.persistance.GameConfigurationPersistanceSingleton
import _root_.org.allbinary.game.configuration.persistance.KeyValuePersistance
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList

class GameConfigurationCentral private() {
    import _root_.org.allbinary.game.configuration.GameConfigurationCentral.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private static String[] ORIENTATIONS = {"Vertical", CommonPhoneStrings.getInstance().UP, CommonPhoneStrings.getInstance().DOWN, CommonPhoneStrings.getInstance().LEFT, CommonPhoneStrings.getInstance().RIGHT};
    var SCALE : GameConfiguration = null

    var ORIENTATION : GameConfiguration = null

    var SENSOR_UPDATE_RATE : GameConfiguration = null

    var VIBRATION : GameConfiguration = null

    var CHALLENGE_LEVEL : GameConfiguration = null

    var COLLIDE_DAMAGE : GameConfiguration = null

    var DURABILITY_CHALLENGE_LEVEL : GameConfiguration = null

    var SPEED_CHALLENGE_LEVEL : GameConfiguration = null

    var ATTACK_CHALLENGE_LEVEL : GameConfiguration = null

    var CONTROL_LEVEL : GameConfiguration = null

    var PLAYER_INPUT_WAIT : GameConfiguration = null

    // enemy activity level
    var SPEED : GameConfiguration = null

    // GameConfiguration(SmallIntegerSingletonFactory.getInstance(0));
    var SOUND_VOLUME : GameConfiguration = null

    var MAX_GAME_OBJECTS : GameConfiguration = null

    var MAX_LAYERS : GameConfiguration = null

    //angle increment                    30 12 10 9  6  4  2   1  
    private var gameControlFidelity : Int = 36

    //Constructor
    {
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        this.SCALE = new GameConfiguration("Scale", smallIntegerSingletonFactory.getAt(2), smallIntegerSingletonFactory.getAt(2), smallIntegerSingletonFactory.getAt(3))
        this.ORIENTATION = new GameConfiguration("Orientation", smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(8))
        this.SENSOR_UPDATE_RATE = new GameConfiguration("Sensor Update Rate", smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(3))
        this.VIBRATION = new GameConfiguration("Vibration", smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(3))
        this.CHALLENGE_LEVEL = new GameConfiguration("Global Challenge Level", smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10))
        this.COLLIDE_DAMAGE = new GameConfiguration("Collide Damage Challenge Level", smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10))
        this.DURABILITY_CHALLENGE_LEVEL = new GameConfiguration("Enemy Durability Challenge Level", smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10))
        this.SPEED_CHALLENGE_LEVEL = new GameConfiguration("Enemy Speed Challenge Level", smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10))
        this.ATTACK_CHALLENGE_LEVEL = new GameConfiguration("Enemy Attack Challenge Level", smallIntegerSingletonFactory.getAt(3), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10))
        this.CONTROL_LEVEL = new GameConfiguration("Control Fidelity", smallIntegerSingletonFactory.getAt(5), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10))
        this.PLAYER_INPUT_WAIT = new GameConfiguration("Input Wait", smallIntegerSingletonFactory.getAt(5), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10))
        // enemy activity level
        this.SPEED = new GameConfiguration("Game Speed (Device Specific)", smallIntegerSingletonFactory.getAt(5), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(10))
        // GameConfiguration(smallIntegerSingletonFactory.getInstance(0));
        this.SOUND_VOLUME = new GameConfiguration("Sound Volume", smallIntegerSingletonFactory.getAt(6), smallIntegerSingletonFactory.getAt(0), smallIntegerSingletonFactory.getAt(10))
        this.MAX_GAME_OBJECTS = new GameConfiguration("Max Game Objects", smallIntegerSingletonFactory.getAt(20), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(50))
        this.MAX_LAYERS = new GameConfiguration("Max Layers", smallIntegerSingletonFactory.getAt(20), smallIntegerSingletonFactory.getAt(1), smallIntegerSingletonFactory.getAt(50))
    }

    def load(abeClientInformation : AbeClientInformationInterface) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
            val keyValuePersistance : KeyValuePersistance = GameConfigurationPersistanceSingleton.getInstance()
            keyValuePersistance.clear()
            keyValuePersistance.loadAll(abeClientInformation)
            val list : BasicArrayList = keyValuePersistance.getIds()
            if (list.size() > 0) {
                val hashtable : ABHashtable[Object, Object] = keyValuePersistance.get(0)
                val anyType : Object = this.SCALE.getName().asInstanceOf[Object]
                val value : String = hashtable.get(anyType).asInstanceOf[String]
                this.SCALE.setValue(smallIntegerSingletonFactory.getAt(Integer.valueOf(value).intValue()))
            } else {
                this.logUtil.putF("No Game Configuration To Load", this, commonStrings.LOAD)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.LOAD, e)
            }
        }
    }

    def setGameControlFidelity(gameControlFidelity : Int) : Unit = {
        this.gameControlFidelity = gameControlFidelity
    }

    def getGameControlFidelity() : Int = {
        //(FIDELITY[fidelity + 1]);
        return this.gameControlFidelity
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val commonStrings : CommonSeps = CommonSeps.getInstance()
        // stringBuffer.append(this.INPUT_WAIT.getValue());
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.SCALE.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.SCALE.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.ORIENTATION.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.ORIENTATION.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.SENSOR_UPDATE_RATE.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.SENSOR_UPDATE_RATE.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.VIBRATION.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.VIBRATION.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.CHALLENGE_LEVEL.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.CHALLENGE_LEVEL.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.COLLIDE_DAMAGE.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.COLLIDE_DAMAGE.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.DURABILITY_CHALLENGE_LEVEL.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.DURABILITY_CHALLENGE_LEVEL.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.SPEED_CHALLENGE_LEVEL.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.SPEED_CHALLENGE_LEVEL.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.ATTACK_CHALLENGE_LEVEL.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.ATTACK_CHALLENGE_LEVEL.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.CONTROL_LEVEL.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.CONTROL_LEVEL.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.SPEED.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.SPEED.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.MAX_GAME_OBJECTS.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.MAX_GAME_OBJECTS.getValue().intValue())
        stringBuffer.append(commonStrings.COMMA_SEP)
        stringBuffer.append(this.MAX_LAYERS.getName())
        stringBuffer.append(commonStrings.EQUALS)
        stringBuffer.appendint(this.MAX_LAYERS.getValue().intValue())
        // stringBuffer.append(this.SOUND_VOLUME.getValue());
        return stringBuffer.toString()
    }

}

object GameConfigurationCentral {
    private var SINGLETON : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameConfigurationCentral = {
        if (GameConfigurationCentral.SINGLETON eq NullUtil.getInstance().NULL_OBJECT) {
            GameConfigurationCentral.SINGLETON = new GameConfigurationCentral()
        }
        return GameConfigurationCentral.SINGLETON.asInstanceOf[GameConfigurationCentral]
    }

}


