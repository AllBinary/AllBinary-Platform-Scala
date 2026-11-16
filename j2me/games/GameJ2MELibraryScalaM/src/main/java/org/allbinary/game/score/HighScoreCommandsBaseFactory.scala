/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class HighScoreCommandsBaseFactory(param_HIGH_SCORE_COMMANDS : Array[Command]) {

    val logUtil : LogUtil = LogUtil.getInstance()

    var HIGH_SCORE_COMMANDS : Array[Command] = null

    //Constructor
    {
        val HIGH_SCORE_COMMANDS : Array[Command] = param_HIGH_SCORE_COMMANDS
        //this.logUtil.putF(this.commonStrings.START).append("not J2ME", this, this.commonStrings.CONSTRUCTOR);
        this.HIGH_SCORE_COMMANDS = HIGH_SCORE_COMMANDS
    }

    def isHighScoreCommand(command : Command) : Boolean = {

        {
            var index : Int = this.HIGH_SCORE_COMMANDS.length - 1
            while (index >= 0) {
                if (command eq this.HIGH_SCORE_COMMANDS(index)) {
                    return true
                }
                index -= 1
            }
        }
        return false
    }

    def getIndex(command : Command) : Int = {

        {
            var index : Int = this.HIGH_SCORE_COMMANDS.length - 1
            while (index >= 0) {
                if (command eq this.HIGH_SCORE_COMMANDS(index)) {
                    return index
                }
                index -= 1
            }
        }
        throw new Exception("No Such Command")
    }

}


