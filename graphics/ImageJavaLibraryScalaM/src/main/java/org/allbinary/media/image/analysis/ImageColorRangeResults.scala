/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.analysis


class ImageColorRangeResults() {

    private var colorRangeInterface : ColorRangeInterface = null

    private var matchingPixelsChecked : Long = 0L

    private var totalPixelsChecked : Long = 0L

    //Constructor
    {
        this.setColorRangeInterface((new ColorRange()).asInstanceOf[ColorRangeInterface])
    }

    def getColorRangeInterface() : ColorRangeInterface = {
        return this.colorRangeInterface
    }

    def setColorRangeInterface(colorRangeInterface : ColorRangeInterface) : Unit = {
        this.colorRangeInterface = colorRangeInterface
    }

    def getMatchingPixelsChecked() : Long = {
        return this.matchingPixelsChecked
    }

    def setMatchingPixelsChecked(matchingPixelsChecked : Long) : Unit = {
        this.matchingPixelsChecked = matchingPixelsChecked
    }

    def addMatchingPixelsChecked() : Unit = {
        this.matchingPixelsChecked += 1
    }

    def getTotalPixelsChecked() : Long = {
        return this.totalPixelsChecked
    }

    def addTotalPixelsChecked() : Unit = {
        this.totalPixelsChecked += 1
    }

    def setTotalPixelsChecked(totalPixelsChecked : Long) : Unit = {
        this.totalPixelsChecked = totalPixelsChecked
    }

    def getPercent() : Float = {
        return (this.getMatchingPixelsChecked().toFloat / this.getTotalPixelsChecked())
    }

}


