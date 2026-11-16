/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.game

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class MeteredGameObject(param_bufferedImage : Array[BufferedImage], param_minX : Integer, param_maxX : Integer, param_y : Integer) extends MeteredGameObjectInterface {

    private var ratios : Array[_root_.java.lang.Double] = null

    private var good : Boolean = false

    private var dropping : Boolean = false

    private var minX : Integer = null

    private var maxX : Integer = null

    private var y : Integer = null

    private var size : Integer = null

    private val RATIOS_LABEL : String = "Ratios: "

    private val IS_GOOD_LABEL : String = "isGood: "

    private val IS_DROPPPING_LABEL : String = "isDropping: "

    //Constructor
    {
        val bufferedImage : Array[BufferedImage] = param_bufferedImage
        val minX : Integer = param_minX
        val maxX : Integer = param_maxX
        val y : Integer = param_y
        this.setRatios(new Array[_root_.java.lang.Double](bufferedImage.length))
        this.setMinX(minX)
        this.setMaxX(maxX)
        this.setY(y)
        this.setSize(maxX - minX)

        {
            var index : Int = 0
            while (index < bufferedImage.length) {
                var nominator : Double = GraphicsAnalysisUtil.getNominator(bufferedImage(index), this.getMinX(), this.getMaxX(), this.getY())
                this.getRatios()(index) = new _root_.java.lang.Double(nominator / this.getSize())
                index += 1
            }
        }
        if (this.getRatios()(bufferedImage.length - 1).doubleValue() > 0.93F) {
            this.setGood(true)
        } else {
            this.setGood(false)
        }
        if (this.getRatios()(bufferedImage.length - 1).doubleValue() < this.getRatios()(0).doubleValue()) {
            this.setDropping(true)
        } else {
            this.setDropping(false)
        }
    }

    def isGood() : Boolean = {
        return this.good
    }

    def setGood(good : Boolean) : Unit = {
        this.good = good
    }

    def isDropping() : Boolean = {
        return this.dropping
    }

    def setDropping(dropping : Boolean) : Unit = {
        this.dropping = dropping
    }

    def getRatios() : Array[_root_.java.lang.Double] = {
        return this.ratios
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(this.RATIOS_LABEL)

        {
            var index : Int = 0
            while (index < this.getRatios().length) {
                stringBuffer.append(this.getRatios()(index).toString())
                if (index < (this.getRatios().length - 1)) {
                    stringBuffer.append(commonSeps.COMMA_SEP)
                }
                index += 1
            }
        }
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(this.IS_GOOD_LABEL)
        stringBuffer.appendboolean(this.isGood())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(this.IS_DROPPPING_LABEL)
        stringBuffer.appendboolean(this.isDropping())
        return stringBuffer.toString()
    }

    def setRatios(ratios : Array[_root_.java.lang.Double]) : Unit = {
        this.ratios = ratios
    }

    def getMinX() : Integer = {
        return this.minX
    }

    def setMinX(minX : Integer) : Unit = {
        this.minX = minX
    }

    def getMaxX() : Integer = {
        return this.maxX
    }

    def setMaxX(maxX : Integer) : Unit = {
        this.maxX = maxX
    }

    def getY() : Integer = {
        return this.y
    }

    def setY(y : Integer) : Unit = {
        this.y = y
    }

    def getSize() : Integer = {
        return this.size
    }

    def setSize(size : Integer) : Unit = {
        this.size = size
    }

}


