/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.contraints.size

import _root_.org.w3c.dom.Node

class TwoDimensionalConstraint(param_node : Node) extends TwoDimensionalConstraintInterface {

    private var widthSizeConstraintInterface : SizeConstraintInterface = null

    private var heightSizeConstraintInterface : SizeConstraintInterface = null

    //Constructor
    {
        val node : Node = param_node
    }

    def getHeight() : SizeConstraintInterface = {
        return this.heightSizeConstraintInterface
    }

    def getWidth() : SizeConstraintInterface = {
        return this.widthSizeConstraintInterface
    }

    def setHeight(heightSizeConstraintInterface : SizeConstraintInterface) : Unit = {
        this.heightSizeConstraintInterface = heightSizeConstraintInterface
    }

    def setWidth(widthSizeConstraintInterface : SizeConstraintInterface) : Unit = {
        this.widthSizeConstraintInterface = widthSizeConstraintInterface
    }

}


