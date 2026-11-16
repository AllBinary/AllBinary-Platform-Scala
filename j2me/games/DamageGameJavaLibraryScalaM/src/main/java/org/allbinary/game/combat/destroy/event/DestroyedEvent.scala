/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.destroy.event

import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.displayable.canvas.NullGameCanvas
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class DestroyedEvent(param_combatGameCanvas : AllBinaryGameCanvas) extends AllBinaryEventObject(DestroyedEventHandler.getInstance()) {

    private var allBinaryGameCanvas : AllBinaryGameCanvas = NullGameCanvas.getInstance()

    private var allBinaryLayerInterface : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    //Constructor
    {
        val combatGameCanvas : AllBinaryGameCanvas = param_combatGameCanvas
        // this.setLayerInterface(allBinaryLayerInterface);
        this.setAllBinaryGameCanvas(combatGameCanvas)
    }

    def getAllBinaryGameCanvas() : AllBinaryGameCanvas = {
        return this.allBinaryGameCanvas
    }

    def getLayerInterface() : AllBinaryLayer = {
        return this.allBinaryLayerInterface
    }

    private def setAllBinaryGameCanvas(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        this.allBinaryGameCanvas = allBinaryGameCanvas
    }

    /*  private void setLayerInterface(AllBinaryLayer allBinaryLayerInterface) {   this.allBinaryLayerInterface = allBinaryLayerInterface;  }  */
    def setLayerInterfaceForCircularStaticPool(allBinaryLayerInterface : AllBinaryLayer) : Unit = {
        this.allBinaryLayerInterface = allBinaryLayerInterface
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("DestroyedEvent: \n")
        stringBuffer.append("AllBinaryLayerInterface: ")
        stringBuffer.append(this.allBinaryLayerInterface.toString())
        stringBuffer.append("\nAllBinaryGameCanvas: ")
        stringBuffer.append(StringUtil.getInstance().toString(this.getAllBinaryGameCanvas()))
        return stringBuffer.toString()
    }

}


