/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score.displayable

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.TextField
import _root_.org.allbinary.PostGameCommandFactory
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.score.HighScore
import _root_.org.allbinary.game.score.HighScoresHelperBaseInterface
import _root_.org.allbinary.game.score.HighScoresFactoryInterface
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.form.item.CustomTextBox
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.paint.SimpleTextPaintable
import _root_.org.allbinary.input.event.VirtualKeyboardEventHandler
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.InApplicationPurchaseFactory

class HighScoreTextBox(param_highScoresFactoryInterface : HighScoresFactoryInterface, param_highScoresHelper : HighScoresHelperBaseInterface, param_abeClientInformation : AbeClientInformationInterface, param_gameInfo : GameInfo, param_cmdListener : CommandListener, param_name : String, param_highScore : HighScore, param_backgrounBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends CustomTextBox(param_cmdListener, "New High Score Enter Name:", param_name, 12, TextField.ANY, Font.getDefaultFont(), param_backgrounBasicColor, param_foregroundBasicColor) {

    // BasicTextBox
    private val virtualKeyboardEventHandler : VirtualKeyboardEventHandler = VirtualKeyboardEventHandler.getInstance()

    private var highScoreUtil : HighScoreUtil = null

    private val pleaseWait : Paintable = new SimpleTextPaintable(this.commonStrings.PLEASE_WAIT, BasicColorFactory.getInstance().WHITE)

    //private final HighScoresResultsListener highScoresResultsListener;
    private var paintable : Paintable = NullPaintable.getInstance()

    var submitted : Boolean = false

    //Constructor
    {
        val highScoresFactoryInterface : HighScoresFactoryInterface = param_highScoresFactoryInterface
        val highScoresHelper : HighScoresHelperBaseInterface = param_highScoresHelper
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val gameInfo : GameInfo = param_gameInfo
        val cmdListener : CommandListener = param_cmdListener
        val name : String = param_name
        val highScore : HighScore = param_highScore
        val backgrounBasicColor : BasicColor = param_backgrounBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        //this.highScoresResultsListener = highScoresHelper;
        this.highScoreUtil = new HighScoreUtil(highScoresFactoryInterface, highScoresHelper, abeClientInformation, gameInfo, cmdListener, name, highScore)
        //this.logUtil.putF("Score: ").append(score, this, "compare");
        val operatingSystemInterface : GenericOperatingSystem = OperatingSystemFactory.getInstance().getOperatingSystemInstance()
        if (operatingSystemInterface.isOverScan()) {
            var username : String = InApplicationPurchaseFactory.getInstance().getUserName()
            //            {
            this.getTextFieldItem().setString(username)
        }
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        PostGameCommandFactory.getInstance().addCommands(this)
        this.addCommand(HighScoreUtil.SUBMIT_TEXTBOX_COMMAND)
        this.setCommandListener(cmdListener)
    }

    override def open() : Unit = {
        this.virtualKeyboardEventHandler.open()
        this.paintable = NullPaintable.getInstance()
        super.open()
    }

    override def close() : Unit = {
        this.virtualKeyboardEventHandler.close()
        this.paintable = this.pleaseWait
        this.repaintBehavior.onChangeRepaint(this)
        super.close()
        this.removeCommand(HighScoreUtil.SUBMIT_TEXTBOX_COMMAND)
        this.update()
        if (this.submitted) {
            //this.logUtil.putF("Saving HighScores", this, this.commonStrings.CLOSE);
            this.highScoreUtil.saveHighScore()
        } else {
        }
        this.paintable = NullPaintable.getInstance()
        this.repaintBehavior.onChangeRepaint(this)
    }

    override def update() : Unit = {
        val name : String = this.getTextFieldItem().getString()
        this.highScoreUtil.update(name)
        super.update()
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
        this.paintable.paint(graphics)
    }

    def saveHighScore() : Unit = {
        this.highScoreUtil.saveHighScore()
    }

    override def submit() : Unit = {
        this.highScoreUtil.submit(this)
    }

}


