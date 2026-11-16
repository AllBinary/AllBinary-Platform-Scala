/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.game.input.PlayerGameInputCompositeInterface

class FormPlayerGameInputProcessor(param_playerGameInputCompositeInterface : PlayerGameInputCompositeInterface) extends Processor {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var playerGameInputCompositeInterface : PlayerGameInputCompositeInterface = null

    //Constructor
    {
        val playerGameInputCompositeInterface : PlayerGameInputCompositeInterface = param_playerGameInputCompositeInterface
        this.playerGameInputCompositeInterface = playerGameInputCompositeInterface
    }

    override def process() : Unit = {
        //PreLogUtil.put(commonStrings.START, this, this.commonStrings.PROCESS);
        this.playerGameInputCompositeInterface.getPlayerGameInput().update()
    }

}


