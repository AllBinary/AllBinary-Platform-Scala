/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.analysis

import _root_.java.awt.*

trait ColorRangeInterface {

    def getMinRed() : Int

    def setMinRed(minRed : Int) : Unit

    def getMaxRed() : Int

    def setMaxRed(maxRed : Int) : Unit

    def getMinGreen() : Int

    def setMinGreen(minGreen : Int) : Unit

    def getMaxGreen() : Int

    def setMaxGreen(maxGreen : Int) : Unit

    def getMinBlue() : Int

    def setMinBlue(minBlue : Int) : Unit

    def getMaxBlue() : Int

    def setMaxBlue(maxBlue : Int) : Unit

    def isInRange(color : Color) : Boolean

}


