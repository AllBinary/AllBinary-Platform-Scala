/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author user  */
class Points() extends PointsInterface {

    private var pointVector : BasicArrayList = null

    //Constructor
    {
        this.pointVector = new BasicArrayListD()
    }

    def init() : Unit = {
        this.pointVector.clear()
    }

    def getPoints() : BasicArrayList = {
        return this.pointVector
    }

    def addPoints(vector : BasicArrayList) : Unit = {
        this.pointVector.addAll2(vector)
    }

    def isValid() : Boolean = {
        if (this.pointVector.size() > 1) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def getSize() : Int = {
        return this.pointVector.size()
    }

}


