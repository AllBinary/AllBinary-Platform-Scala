/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.paint.ColorFillBasePaintable
import _root_.org.allbinary.game.paint.ColorFillPaintableFactory
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.draw.DrawStringUtil
import _root_.org.allbinary.logic.string.StringUtil

class GameInputMappingInstructionsCanvas(param_commandListener : CommandListener, param_allBinaryGameLayerManager : AllBinaryGameLayerManager) extends GameCommandCanvas(param_commandListener, GameInputMappingInstructionsCanvas.NAME, param_allBinaryGameLayerManager.getBackgroundBasicColor(), param_allBinaryGameLayerManager.getForegroundBasicColor()) {
    import _root_.org.allbinary.game.displayable.canvas.GameInputMappingInstructionsCanvas.{DISPLAY as _, CLOSE as _, NAME as _, *}
    def DISPLAY : Command = _root_.org.allbinary.game.displayable.canvas.GameInputMappingInstructionsCanvas.DISPLAY
    def CLOSE : Command = _root_.org.allbinary.game.displayable.canvas.GameInputMappingInstructionsCanvas.CLOSE
    def NAME : String = _root_.org.allbinary.game.displayable.canvas.GameInputMappingInstructionsCanvas.NAME

    private val drawStringUtil : DrawStringUtil = DrawStringUtil.getInstance()

    //Mapping
    val TITLE : String = "Input Instructions"

    private val instructions : Array[String] = Array[String]("Add Input Mapping:", "1. Select the desired action by generating a currently defined input for a given action.", "(Example: Press the '1' key to select the Fire action)", "2. Make the newly desired input for the selected action.", "(Example: Press 'f' to add it to the selected action)", "Note: If the input is already mapped to another action then it will not be added. You", "will need to deleted from the other action before adding it to another.", "Warning: Not all keys map for a given platform and show as Unknown.", StringUtil.getInstance().EMPTY_STRING, "Remove Input Mapping:", "1. Select the desired action by generating a currently defined input for a given action.", "(Example: Press the key '1' to select the Fire action)", "2. Select a mapped input for the selected action.", "(Example: Press the key '1' to select the '1' key input for the selected Fire action)", "3. Press the Delete Key.")

    private var colorFillPaintable : ColorFillBasePaintable = null

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val commandListener : CommandListener = param_commandListener
        val allBinaryGameLayerManager : AllBinaryGameLayerManager = param_allBinaryGameLayerManager
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.colorFillPaintable = ColorFillPaintableFactory.getInstance().getInstance(allBinaryGameLayerManager.getBackgroundBasicColor(), false)
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        this.addCommand(GameInputMappingInstructionsCanvas.CLOSE)
        this.setCommandListener(cmdListener)
    }

    override def paint(graphics : Graphics) : Unit = {
        //PreLogUtil.put(commonStrings.START, this, canvasStrings.PAINT);
        this.myFontProcessor.process(graphics)
        this.colorFillPaintable.paint(graphics)
        var halfWidth : Int = this.displayInfo.getLastHalfWidth()
        var beginWidth : Int = (graphics.getFont().stringWidth(this.TITLE) >> 1)
        graphics.setColor(this.foregroundColor)
        graphics.drawString(this.TITLE, halfWidth - beginWidth, this.fontHeight, this.anchor)
        //int startIndex = this.helpPaintable.getInputInfo().length + 5;
        this.drawStringUtil.drawCenterStrings(graphics, this.instructions, this.displayInfo.getLastWidth(), this.fontHeight, halfWidth, 3 * this.fontHeight)
        super.paint(graphics)
    }

}

object GameInputMappingInstructionsCanvas {
    val DISPLAY : Command = new Command("Help", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val CLOSE : Command = new Command("Close", StringUtil.getInstance().EMPTY_STRING, Command.SCREEN, 1)

    val NAME : String = "GameInputMappingInstructionsCanvas"

}


