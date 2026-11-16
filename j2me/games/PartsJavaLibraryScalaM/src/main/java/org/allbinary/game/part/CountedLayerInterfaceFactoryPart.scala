/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.part

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactory
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.math.PrimitiveLongUtil
import _root_.org.allbinary.util.ABHashtable

class CountedLayerInterfaceFactoryPart(param_total : Int, param_countedPickedUpLayerInterfaceFactory : CountedPickedUpLayerInterfaceFactory) extends PartInterface with UpdateMyFontInterface {
    import _root_.org.allbinary.game.part.CountedLayerInterfaceFactoryPart.{NULL_COUNTED_LAYER_INTERFACE_FACTORY as _, *}
    def NULL_COUNTED_LAYER_INTERFACE_FACTORY : CountedLayerInterfaceFactoryPart = _root_.org.allbinary.game.part.CountedLayerInterfaceFactoryPart.NULL_COUNTED_LAYER_INTERFACE_FACTORY

    private val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    private var animationInterface : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

    private var total : Int = 0

    //private String totalString;
    private var totalString : Array[Char] = NullUtil.getInstance().NULL_CHAR_ARRAY

    private var xOffset : Int = 0

    private var countedPickedUpLayerInterfaceFactory : CountedPickedUpLayerInterfaceFactory = CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY

    private var primitiveLongUtil : PrimitiveLongUtil = null

    //Constructor
    {
        val total : Int = param_total
        val countedPickedUpLayerInterfaceFactory : CountedPickedUpLayerInterfaceFactory = param_countedPickedUpLayerInterfaceFactory
        this.primitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(1000)
        this.init(total, countedPickedUpLayerInterfaceFactory)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.setXOffset(font.charsWidth(this.totalString, 0, this.primitiveLongUtil.getCurrentTotalDigits()) + (font.getSize() >> 1))
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    private def init(total : Int, countedPickedUpLayerInterfaceFactory : CountedPickedUpLayerInterfaceFactory) : Unit = {
        this.setCountedPickedUpLayerInterfaceFactory(countedPickedUpLayerInterfaceFactory)
        this.total = total
    }

    def getInstance(hashtable : ABHashtable[Object, Object], x : Int, y : Int, z : Int) : AllBinaryLayer = {
        if (this.total > 0) {
            this.setTotal(this.total - 1)
            return this.getCountedPickedUpLayerInterfaceFactory().getNextInstance(hashtable, x, y, z)
        } else {
            throw new Exception("No more left. Could use a listener to automatically remove")
        }
        throw new IllegalStateException()
    }

    def getTotal() : Int = {
        return this.total
    }

    def setTotal(total : Int) : Unit = {
        this.total = total
        //this.totalString = this.primitiveLongUtil.getString(total);
        this.totalString = this.primitiveLongUtil.getCharArray(total)
        //this.setTotalStringWidth(font.stringWidth(totalString));
        this.myFontProcessor = this.updateMyFontProcessor
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

    override def getAnimationInterface() : Animation = {
        return this.animationInterface
    }

    def setAnimationInterface(animationInterface : Animation) : Unit = {
        this.animationInterface = animationInterface
    }

    /**      * @return the totalStringWidth      */
    def getXOffset() : Int = {
        return this.xOffset
    }

    /**      * @param totalStringWidth the totalStringWidth to set      */
    private def setXOffset(totalStringWidth : Int) : Unit = {
        this.xOffset = totalStringWidth
    }

    /*    public String getTotalString()    {       return totalString;    }      */
    def getTotalString() : Array[Char] = {
        return this.totalString
    }

    /**      * @return the countedPickedUpLayerInterfaceFactory      */
    def getCountedPickedUpLayerInterfaceFactory() : CountedPickedUpLayerInterfaceFactory = {
        return this.countedPickedUpLayerInterfaceFactory
    }

    /**      * @param countedPickedUpLayerInterfaceFactory the      * countedPickedUpLayerInterfaceFactory to set      */
    def setCountedPickedUpLayerInterfaceFactory(countedPickedUpLayerInterfaceFactory : CountedPickedUpLayerInterfaceFactory) : Unit = {
        this.countedPickedUpLayerInterfaceFactory = countedPickedUpLayerInterfaceFactory
    }

}

object CountedLayerInterfaceFactoryPart {
    val NULL_COUNTED_LAYER_INTERFACE_FACTORY : CountedLayerInterfaceFactoryPart = new CountedLayerInterfaceFactoryPart(0, CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY)

}


