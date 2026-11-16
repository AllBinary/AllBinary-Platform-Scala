/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.game.input.PlatformInputMappingFactory
import _root_.org.allbinary.game.input.mapping.InputMappingInterface
import _root_.org.allbinary.game.input.mapping.PersistentInputMapping
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.paint.ColorFillBasePaintable
import _root_.org.allbinary.game.paint.ColorFillPaintableFactory
import _root_.org.allbinary.game.paint.help.HelpPaintable
import _root_.org.allbinary.game.paint.help.InputMappingHelpPaintable
import _root_.org.allbinary.graphics.paint.ProcessPaintable
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.util.BasicArrayList

class GameInputMappingCanvas(param_abeClientInformation : AbeClientInformationInterface, param_commandListener : CommandListener, param_allBinaryGameLayerManager : AllBinaryGameLayerManager, param_helpPaintable : HelpPaintable) extends GameCommandCanvas(param_commandListener, GameInputMappingCanvas.NAME, param_allBinaryGameLayerManager.getBackgroundBasicColor(), param_allBinaryGameLayerManager.getForegroundBasicColor()) with InputMappingInterface {
    import _root_.org.allbinary.game.displayable.canvas.GameInputMappingCanvas.{NAME as _, DISPLAY as _, DEFAULT as _, *}
    def NAME : String = _root_.org.allbinary.game.displayable.canvas.GameInputMappingCanvas.NAME
    def DISPLAY : Command = _root_.org.allbinary.game.displayable.canvas.GameInputMappingCanvas.DISPLAY
    def DEFAULT : Command = _root_.org.allbinary.game.displayable.canvas.GameInputMappingCanvas.DEFAULT

    private var paintable : ProcessPaintable = null

    private var helpPaintable : InputMappingHelpPaintable = null

    var colorFillPaintable : ColorFillBasePaintable = null

    private var inputMapping : PersistentInputMapping = null

    private val NONE : GameKey = GameKeyFactory.getInstance().NONE

    private var abeClientInformation : AbeClientInformationInterface = null

    private var selectedGameKey : GameKey = this.NONE

    private var selectedInput : Input = this.NONE

    private val inputFactory : InputFactory = InputFactory.getInstance()

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val commandListener : CommandListener = param_commandListener
        val allBinaryGameLayerManager : AllBinaryGameLayerManager = param_allBinaryGameLayerManager
        val helpPaintable : HelpPaintable = param_helpPaintable
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        if (helpPaintable == null) {
            throw new Exception("Help Paintable Exception")
        }
        this.abeClientInformation = abeClientInformation
        this.helpPaintable = helpPaintable.asInstanceOf[InputMappingHelpPaintable]
        this.inputMapping = PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance()
        //                       .getInstance().START_INPUT_MAPPING));
        this.paintable = new ProcessPaintable()
        //      this, allBinaryGameLayerManager.getForegroundBasicColor());
        this.colorFillPaintable = ColorFillPaintableFactory.getInstance().getInstance(allBinaryGameLayerManager.getBackgroundBasicColor(), false)
    }

    override def close() : Unit = {
        super.close()
        this.paintable.process()
        //                     .getInstance().START_DEMO));
        this.selectedGameKey = this.NONE
        this.selectedInput = this.NONE
        this.update()
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        this.addCommand(GameCommandsFactory.getInstance().CLOSE_AND_SHOW_GAME_CANVAS)
        this.addCommand(GameInputMappingCanvas.DEFAULT)
        this.addCommand(GameInputMappingInstructionsCanvas.DISPLAY)
        this.setCommandListener(cmdListener)
    }

    override def keyPressed(keyCode : Int) : Unit = {
        this.keyPressedByDevice(keyCode, 0)
    }

    override def keyReleased(keyCode : Int) : Unit = {
        this.keyReleasedByDevice(keyCode, 0)
    }

    override def keyRepeated(keyCode : Int) : Unit = {
        this.keyRepeatedByDevice(keyCode, 0)
    }

    override def keyPressedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        // this.logUtil.putF(this.commonStrings.START, this, gameInputStrings.KEY_PRESSED);        
        this.addGameKey(keyCode, false)
        super.keyPressedByDevice(keyCode, 0)
    }

    private def addGameKey(keyCode : Int, repeated : Boolean) : Unit = {
        try {
            this.logUtil.putF(new StringMaker().append("Raw Device Key Code: ").append(Integer.toHexString(keyCode)).toString(), this, this.gameInputStrings.ADD_KEY_EVENT)
            var gameKey : GameKey = this.inputToGameKeyMapping.getInstanceForCanvas(this, keyCode)
            //TWB - Hack for MicroEmulator negative values on directional controls
            var input : Input = this.inputFactory.getInstanceById(keyCode)
            this.processInputMapping(gameKey, input)
        } catch {
            case e : Exception => {
                this.logUtil.put("Key Event Error", this, this.gameInputStrings.ADD_KEY_EVENT, e)
            }
        }
    }

    override def processInputMapping(gameKey : GameKey, input : Input) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Start Passed GameKey: ")
        stringBuffer.append(this.stringUtil.toString(gameKey))
        stringBuffer.append(" Input: ")
        stringBuffer.append(this.stringUtil.toString(input))
        this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.PROCESS)
        if (this.selectedGameKey ne this.NONE) {
            this.gameActionCrud(gameKey, input)
        } else {
            this.setSelectedAction(gameKey)
        }
    }

    private def setSelectedAction(gameKey : GameKey) : Unit = {
        this.logUtil.putF(new StringMaker().append("Selected GameKey: ").append(this.stringUtil.toString(gameKey)).toString(), this, "setSelectedAction")
        this.selectedGameKey = gameKey
        this.selectedInput = this.NONE
        this.helpPaintable.update(this.selectedGameKey, this.selectedInput)
        this.repaintBehavior.onChangeRepaint(this)
    }

    private def gameActionCrud(gameKey : GameKey, input : Input) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Start GameKey: ")
        stringBuffer.append(this.stringUtil.toString(this.selectedGameKey))
        stringBuffer.append(" Input: ")
        stringBuffer.append(this.stringUtil.toString(this.selectedInput))
        this.logUtil.putF(stringBuffer.toString(), this, "gameActionCrud")
        // if it is mapped for the selected action
        if (this.selectedInput eq this.NONE) {
            var list : BasicArrayList = this.inputMapping.getInputMapping().getMappedInput(this.selectedGameKey)
            var isInputAlreadyMappedToSelectedAction : Boolean = list.contains(input)
            if (isInputAlreadyMappedToSelectedAction) {
                this.logUtil.putF(new StringMaker().append("Already Mapped Input: ").append(this.stringUtil.toString(input)).toString(), this, "gameActionCrud")
                this.selectedInput = input
                this.helpPaintable.update(this.selectedGameKey, this.selectedInput)
                this.repaintBehavior.onChangeRepaint(this)
            } else {
                this.addNewMapping(gameKey, input)
            }
        } else if (this.inputMapping.isDelete(input)) {
            this.deleteCurrentMapping()
        } else {
            this.setSelectedAction(gameKey)
        }
    }

    private def addNewMapping(gameKey : GameKey, input : Input) : Unit = {
        val METHOD_NAME : String = "addNewMapping"
        //this.logUtil.putF(this.commonStrings.START_LABEL).append("Dissallow if ").append(input).append(" is in { ").append(AndroidKeyFactory.getInstance().MENU).append(" }", this, "addNewMapping");
        this.logUtil.putF(this.commonStrings.START, this, METHOD_NAME)
        var isInputAlreadyMapped : Boolean = this.inputMapping.getInputMapping().isMapped(input)
        if (!isInputAlreadyMapped && !this.inputMapping.isSystemInput(input)) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Add Key Mapping : GameKey: ")
            stringBuffer.append(this.stringUtil.toString(this.selectedGameKey))
            stringBuffer.append(" Input: ")
            stringBuffer.append(this.stringUtil.toString(this.selectedInput))
            this.logUtil.putF(stringBuffer.toString(), this, METHOD_NAME)
            this.inputMapping.getInputMapping().add(this.selectedGameKey, input)
            this.selectedInput = input
            this.update()
        } else {
            this.logUtil.putF("Unable to add Mapping since one already exists or is MENU, HOME, or BACK key and setting selected action to what it is already mapped to", this, METHOD_NAME)
            this.setSelectedAction(gameKey)
        }
    }

    private def deleteCurrentMapping() : Unit = {
        val METHOD_NAME : String = "deleteCurrentMapping"
        var list : BasicArrayList = this.inputMapping.getInputMapping().getMappedInput(this.selectedGameKey)
        if (list.size() > 1) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Start GameKey: ")
            stringBuffer.append("Remove Key Mapping: GameKey: ")
            stringBuffer.append(this.stringUtil.toString(this.selectedGameKey))
            stringBuffer.append(" Input: ")
            stringBuffer.append(this.stringUtil.toString(this.selectedInput))
            this.logUtil.putF(stringBuffer.toString(), this, METHOD_NAME)
            this.inputMapping.getInputMapping().remove(this.selectedGameKey, this.selectedInput)
            this.selectedInput = this.NONE
            this.update()
        } else {
            this.logUtil.putF("Can't Remove Last Key Mapping", this, METHOD_NAME)
        }
    }

    def setDefault() : Unit = {
        this.inputMapping.setDefault(this.abeClientInformation)
        //(InputToGameKeyMapping) PlatformInputMappingFactory.getInstance());
        this.helpPaintable.update(this.NONE, this.NONE)
        this.repaintBehavior.onChangeRepaint(this)
    }

    override def update() : Unit = {
        this.inputMapping.update(this.abeClientInformation)
        //(InputToGameKeyMapping) PlatformInputMappingFactory.getInstance());
        this.helpPaintable.update(this.selectedGameKey, this.selectedInput)
        this.repaintBehavior.onChangeRepaint(this)
    }

    override def paint(graphics : Graphics) : Unit = {
        this.colorFillPaintable.paint(graphics)
        this.helpPaintable.paint(graphics)
        this.paintable.paint(graphics)
        super.paint(graphics)
    }

}

object GameInputMappingCanvas {
    val NAME : String = "GameInputMappingCanvas"

    //Input Mapping
    val DISPLAY : Command = new Command("Controls", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 2)

    val DEFAULT : Command = new Command("Default", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 2)

}


