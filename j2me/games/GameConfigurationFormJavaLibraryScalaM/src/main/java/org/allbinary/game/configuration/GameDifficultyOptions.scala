/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.Choice
import _root_.javax.microedition.lcdui.ChoiceGroup
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.MIDPUtil
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.persistance.GameDifficultyFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.screen.CommandForm
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList

class GameDifficultyOptions(param_commandListener : CommandListener, param_title : String, param_list : BasicArrayList, param_backgrounBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CommandForm(param_commandListener, param_title, param_backgrounBasicColor, param_foregroundBasicColor) {

    private val meUtil : MIDPUtil = MIDPUtil.getInstance()

    private var list : BasicArrayList = null

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val title : String = param_title
        val list : BasicArrayList = param_list
        val backgrounBasicColor : BasicColor = param_backgrounBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.list = list
        this.update()
        this.initCommands(commandListener)
        val gameDifficultyFactory : GameDifficultyFactory = GameDifficultyFactory.getInstance()
        this.setSelectedId(gameDifficultyFactory.getLevel())
    }

    override def open() : Unit = {
        super.open()
    }

    override def close() : Unit = {
        super.close()
        this.save()
    }

    def save() : Unit = {
        val gameDifficultyFactory : GameDifficultyFactory = GameDifficultyFactory.getInstance()
        gameDifficultyFactory.setLevel(this.getSelectedId())
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
        this.removeAllCommands()
        this.addCommand(gameCommandsFactory.CLOSE_AND_SHOW_GAME_CANVAS)
        this.setCommandListener(cmdListener)
    }

    override def update() : Unit = {
        this.deleteAll()
        this.add(this.list, "Difficulty", Choice.EXCLUSIVE)
        super.update()
    }

    private def add(list : BasicArrayList, name : String, option : Int) : Unit = {
        val choiceGroup : ChoiceGroup = this.getChoiceGroup(list, name, option)
        if (list.size() > 0) {
            choiceGroup.setSelectedIndex(0, true)
        }
        this.meUtil.appendItem(this, choiceGroup)
    }

    private def getChoiceGroup(list : BasicArrayList, name : String, option : Int) : ChoiceGroup = {
        val METHOD_NAME : String = "addChoiceGroup"
        val NAME : String = "Adding Choice: "
        val choiceGroup : ChoiceGroup = new ChoiceGroup(name, option, StringUtil.getInstance().getArrayInstance(), NullImage.NULL_IMAGE_ARRAY)
        val size : Int = list.size()
        var anyType : Object = null

        {
            var index : Int = 0
            while (index < size) {
                anyType = list.objectArray(index)
                this.logUtil.putF(new StringMaker().append(NAME).append(anyType.toString()).toString(), this, METHOD_NAME)
                choiceGroup.append(anyType.toString(), NullImage.NULL_IMAGE)
                index += 1
            }
        }
        return choiceGroup
    }

    def setSelectedId(id : Int) : Unit = {
        val choiceGroup : ChoiceGroup = this.get(0).asInstanceOf[ChoiceGroup]
        choiceGroup.setSelectedIndex(id, true)
    }

    def getSelectedId() : Int = {
        val choiceGroup : ChoiceGroup = this.get(0).asInstanceOf[ChoiceGroup]
        return choiceGroup.getSelectedIndex()
    }

    def getSelectedText() : Int = {
        val choiceGroup : ChoiceGroup = this.get(0).asInstanceOf[ChoiceGroup]
        val value : Int = Integer.valueOf(choiceGroup.getString(choiceGroup.getSelectedIndex())).intValue()
        return value
    }

}


