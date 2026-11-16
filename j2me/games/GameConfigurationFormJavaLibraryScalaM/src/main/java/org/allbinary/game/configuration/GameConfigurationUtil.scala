/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.Item
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class GameConfigurationUtil {
    import _root_.org.allbinary.game.configuration.GameConfigurationUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val GAUGE_UPDATE : String = "Gauge Update: "

    private val FROM : String = " from: "

    private val TO : String = " to: "

    private var COMPETITION_VALUE : Int = 1

    def change(gameOptionsForm : GameOptionsForm, gauge : GameConfigurationGauge) : Unit = {
        this.update(gauge)
        var gameConfigurationSingleton : GameConfigurationSingleton = GameConfigurationSingleton.getInstance()
        var gameConfiguration : GameConfiguration = gameConfigurationSingleton.getInstanceByName(gauge.getLabel())
        this.updateChallange(gameOptionsForm, gameConfiguration)
    }

    def update(gauge : GameConfigurationGauge) : Unit = {
        var gameConfigurationSingleton : GameConfigurationSingleton = GameConfigurationSingleton.getInstance()
        var gameConfiguration : GameConfiguration = gameConfigurationSingleton.getInstanceByName(gauge.getLabel())
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        var value : Integer = smallIntegerSingletonFactory.getAt(gauge.getValue() + gameConfiguration.getMinValue().intValue())
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.GAUGE_UPDATE)
        stringBuffer.append(gameConfiguration.getName())
        stringBuffer.append(this.FROM)
        stringBuffer.appendint(gameConfiguration.getValue().intValue())
        stringBuffer.append(this.TO)
        stringBuffer.appendint(value.intValue())
        this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.UPDATE)
        gameConfiguration.setValue(value)
    }

    def setDefault(gauge : GameConfigurationGauge) : Unit = {
        var gameConfigurationSingleton : GameConfigurationSingleton = GameConfigurationSingleton.getInstance()
        var gameConfiguration : GameConfiguration = gameConfigurationSingleton.getInstanceByName(gauge.getLabel())
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Gauge Default: ")
        stringBuffer.append(gameConfiguration.getName())
        stringBuffer.append(this.TO)
        stringBuffer.appendint(gameConfiguration.getDefaultValue().intValue())
        this.logUtil.putF(stringBuffer.toString(), this, "setDefault")
        gauge.setValue(gameConfiguration.getDefaultValue().intValue() - gameConfiguration.getMinValue().intValue())
        gameConfiguration.setValue(gameConfiguration.getDefaultValue())
    }

    def updateChallange(gameOptionsForm : GameOptionsForm, gameConfiguration : GameConfiguration) : Unit = {
        var gameConfigurationSingleton : GameConfigurationSingleton = GameConfigurationSingleton.getInstance()
        var gameConfigurationCentral : GameConfigurationCentral = GameConfigurationCentral.getInstance()
        if (gameConfiguration eq gameConfigurationCentral.CHALLENGE_LEVEL) {
            this.logUtil.putF(this.commonStrings.START, this, "updateChallange")
            gameConfigurationCentral.COLLIDE_DAMAGE.setValue(gameConfiguration.getValue())
            gameConfigurationCentral.ATTACK_CHALLENGE_LEVEL.setValue(gameConfiguration.getValue())
            gameConfigurationCentral.DURABILITY_CHALLENGE_LEVEL.setValue(gameConfiguration.getValue())
            gameConfigurationCentral.SPEED_CHALLENGE_LEVEL.setValue(gameConfiguration.getValue())
            val size : Int = gameOptionsForm.size()

            {
                var index : Int = 0
                while (index < size) {
                    var item : Item = gameOptionsForm.get(index)
                    if (item.isInstanceOf[GameConfigurationGauge]) {
                        var gauge : GameConfigurationGauge = item.asInstanceOf[GameConfigurationGauge]
                        var name : String = item.getLabel()
                        var nextGameConfiguration : GameConfiguration = gameConfigurationSingleton.getInstanceByName(name)
                        if (nextGameConfiguration eq gameConfigurationCentral.COLLIDE_DAMAGE) {
                            gauge.setValue(gameConfigurationCentral.COLLIDE_DAMAGE.getValue().intValue() - gameConfiguration.getMinValue().intValue())
                        } else if (nextGameConfiguration eq gameConfigurationCentral.DURABILITY_CHALLENGE_LEVEL) {
                            gauge.setValue(gameConfigurationCentral.DURABILITY_CHALLENGE_LEVEL.getValue().intValue() - gameConfiguration.getMinValue().intValue())
                        } else if (nextGameConfiguration eq gameConfigurationCentral.ATTACK_CHALLENGE_LEVEL) {
                            gauge.setValue(gameConfigurationCentral.ATTACK_CHALLENGE_LEVEL.getValue().intValue() - gameConfiguration.getMinValue().intValue())
                        } else if (nextGameConfiguration eq gameConfigurationCentral.SPEED_CHALLENGE_LEVEL) {
                            gauge.setValue(gameConfigurationCentral.SPEED_CHALLENGE_LEVEL.getValue().intValue() - gameConfiguration.getMinValue().intValue())
                        }
                    }
                    index += 1
                }
            }
        }
    }

    def updateCompetitionValue() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "updateCompetitionValue")
        var gameConfigurationCentral : GameConfigurationCentral = GameConfigurationCentral.getInstance()
        this.COMPETITION_VALUE = ((gameConfigurationCentral.COLLIDE_DAMAGE.getValue().intValue() + gameConfigurationCentral.ATTACK_CHALLENGE_LEVEL.getValue().intValue()) + gameConfigurationCentral.DURABILITY_CHALLENGE_LEVEL.getValue().intValue()) + gameConfigurationCentral.SPEED_CHALLENGE_LEVEL.getValue().intValue()
        this.COMPETITION_VALUE = (this.COMPETITION_VALUE >> 2)
    }

    def getCompetitionValue() : Int = {
        return this.COMPETITION_VALUE
    }

}

object GameConfigurationUtil {
    private val instance : GameConfigurationUtil = new GameConfigurationUtil()

    def getInstance() : GameConfigurationUtil = {
        return GameConfigurationUtil.instance
    }

}


