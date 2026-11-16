/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ai

import _root_.org.allbinary.ai.ArtificialIntelligence
import _root_.org.allbinary.game.displayable.canvas.CanvasUtil
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class BasicAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends ArtificialIntelligence with GameKeyEventSourceInterface {
    import _root_.org.allbinary.game.ai.BasicAI.{AI_VISITOR as _, ID as _, *}
    def AI_VISITOR : Integer = _root_.org.allbinary.game.ai.BasicAI.AI_VISITOR
    def ID : Integer = _root_.org.allbinary.game.ai.BasicAI.ID

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()

    private var ownerLayerInterface : AllBinaryLayer = null

    private var gameInput : GameInput = null

    private var lastKey : Int = -1

    /*     private BasicAI()     {        this.ownerLayerInterface = null;        this.gameInput = null;     }     */
    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.ownerLayerInterface = ownerLayerInterface
        this.gameInput = gameInput
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def processKeyAI(key : Int) : Unit = {
        if (key != -1) {
            this.gameInput.add(this.gameKeyEventFactory.getInstanceForKey(this, key))
        }
    }

    def setLastKey(lastKey : Int) : Unit = {
        this.lastKey = lastKey
    }

    def getLastKey() : Int = {
        return this.lastKey
    }

    def getOwnerLayerInterface() : AllBinaryLayer = {
        return this.ownerLayerInterface
    }

    /*     protected void setOwnerLayerInterface(AllBinaryLayer ownerLayerInterface)     {         this.ownerLayerInterface = ownerLayerInterface;     }      public void setGameInput(GameInput gameInput)     {         this.gameInput = gameInput;     }     */
    def getGameInput() : GameInput = {
        return this.gameInput
    }

    def getName() : String = {
        return this.getClass().getName()
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append(this.getName())
        stringBuffer.append(" LastKey: ")
        stringBuffer.append(CanvasUtil.getKeyName(this.getLastKey()))
        return stringBuffer.toString()
    }

    override def getSourceId() : Int = {
        return 1
    }

}

object BasicAI {
    val AI_VISITOR : Integer = SmallIntegerSingletonFactory.getInstance().getAt(2)

    val ID : Integer = SmallIntegerSingletonFactory.getInstance().getAt(1)

}


