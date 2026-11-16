/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.Choice
import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Item
import _root_.javax.microedition.lcdui.TextField
import _root_.org.allbinary.MIDPUtil
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.feature.GameFeatureChoiceGroups
import _root_.org.allbinary.game.configuration.feature.GameFeatureFormUtil
import _root_.org.allbinary.game.configuration.feature.GameFeatureItemCommandListener
import _root_.org.allbinary.game.configuration.feature.GameFeatureItemStateListener
import _root_.org.allbinary.game.configuration.feature.SensorFeatureFactory
import _root_.org.allbinary.game.configuration.persistance.GameConfigurationPersistanceSingleton
import _root_.org.allbinary.game.configuration.persistance.KeyValuePersistance
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.command.MyCommandsFactory
import _root_.org.allbinary.graphics.displayable.screen.CommandForm
import _root_.org.allbinary.input.gyro.OrientationData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.HashtableUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

class GameOptionsForm(param_commandListener : CommandListener, param_title : String, param_backgrounBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CommandForm(param_commandListener, param_title, param_backgrounBasicColor, param_foregroundBasicColor) {

    /*     public static GameOptionsForm getInstance()     {         return SINGLETON;     }     */
    private val meUtil : MIDPUtil = MIDPUtil.getInstance()

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val title : String = param_title
        val backgrounBasicColor : BasicColor = param_backgrounBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.addConfiguration()
        val gameFeatureFormUtil : GameFeatureFormUtil = GameFeatureFormUtil.getInstance()
        gameFeatureFormUtil.addChoiceGroup(this, GameFeatureChoiceGroups.getExclusiveInstance().get(), Choice.EXCLUSIVE)
        gameFeatureFormUtil.addChoiceGroup(this, GameFeatureChoiceGroups.getMultipleInstance().get(), Choice.MULTIPLE)
        this.initCommands(commandListener)
        this.setItemStateListener(new GameFeatureItemStateListener(this))
        //GameFeatureItemStateListener.getInstance());
        this.addTextFieldsIfSimulated()
    }

    def closeClientInformation(abeClientInformation : AbeClientInformationInterface) : Unit = {
        super.close()
        this.save(abeClientInformation)
    }

    private def addTextFieldsIfSimulated() : Unit = {
        var key : String = OrientationData.getInstance().ORIENTATION_SENSOR_INPUT
        val hashtable : ABHashtable[Object, Object] = GameFeatureChoiceGroups.getExclusiveInstance().get()
        if (hashtable != null) {
            var listCanBeNull : Object = hashtable.get(key)
            if (listCanBeNull != null) {
                val list : BasicArrayList = listCanBeNull.asInstanceOf[BasicArrayList]
                if (list.contains(SensorFeatureFactory.getInstance().SIMULATED_ORIENTATION_SENSORS)) {
                    this.addTextFields()
                }
            }
        }
    }

    private def addTextFields() : Unit = {
        val hashtable : ABHashtable[Object, Object] = GameConfigurationTextInput.getHashtable()
        val size : Int = hashtable.size()
        val objectArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(hashtable)
        var gameConfigurationTextInput : GameConfigurationTextInput = null
        var textField : TextField = null

        {
            var index : Int = 0
            while (index < size) {
                gameConfigurationTextInput = hashtable.get(objectArray(index).asInstanceOf[Object]).asInstanceOf[GameConfigurationTextInput]
                textField = new TextField(gameConfigurationTextInput.getLabel(), gameConfigurationTextInput.getText(), 30, TextField.ANY)
                this.meUtil.appendItem(this, textField)
                index += 1
            }
        }
    }

    private def addConfiguration() : Unit = {
        val METHOD_NAME : String = "addConfiguration"
        val NAME : String = "Name: "
        val list : BasicArrayList = GameConfigurationSingleton.getInstance().getOptionsBasicArrayList()
        val GAUGE_CHANGE : Command = MyCommandsFactory.getInstance().GAUGE_CHANGE
        val stringMaker : StringMaker = new StringMaker()
        val size : Int = list.size()
        var gameConfiguration : GameConfiguration = null
        var gauge : GameConfigurationGauge = null

        {
            var index : Int = 0
            while (index < size) {
                gameConfiguration = list.objectArray(index).asInstanceOf[GameConfiguration]
                stringMaker.delete(0, stringMaker.length())
                this.logUtil.putF(stringMaker.append(NAME).append(gameConfiguration.toString()).toString(), this, METHOD_NAME)
                gauge = new GameConfigurationGauge(gameConfiguration)
                gauge.setDefaultCommand(GAUGE_CHANGE)
                gauge.setItemCommandListener(new GameFeatureItemCommandListener(this))
                // this.setCommandListener(l);
                this.meUtil.appendItem(this, gauge)
                index += 1
            }
        }
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
        this.removeAllCommands()
        this.addCommand(gameCommandsFactory.CLOSE_OPTIONS)
        this.addCommand(gameCommandsFactory.DEFAULT_OPTIONS)
        this.setCommandListener(cmdListener)
    }

    def save(abeClientInformation : AbeClientInformationInterface) : Unit = {
        val size : Int = this.size()
        var item : Item = null

        {
            var index : Int = 0
            while (index < size) {
                item = this.get(index)
                if (item.isInstanceOf[GameConfigurationGauge]) {
                    GameConfigurationUtil.getInstance().update(item.asInstanceOf[GameConfigurationGauge])
                } else if (item.isInstanceOf[TextField]) {
                    GameConfigurationTextInput.update(item.asInstanceOf[TextField])
                }
                index += 1
            }
        }
        GameConfigurationUtil.getInstance().updateCompetitionValue()
        val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        val SCALE : GameConfiguration = GameConfigurationCentral.getInstance().SCALE
        hashtable.put(SCALE.getName(), Integer.toString(SCALE.getValue().intValue()))
        val keyValuePersistance : KeyValuePersistance = GameConfigurationPersistanceSingleton.getInstance()
        keyValuePersistance.clear()
        keyValuePersistance.loadAll(abeClientInformation)
        val list : BasicArrayList = keyValuePersistance.getIds()
        keyValuePersistance.save(abeClientInformation, hashtable)
        val size2 : Int = list.size()
        var integer : Integer = null

        {
            var index : Int = 0
            while (index < size2) {
                integer = list.objectArray(index).asInstanceOf[Integer]
                keyValuePersistance.delete(abeClientInformation, integer.intValue())
                index += 1
            }
        }
    }

}


