/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.canvas.event

import _root_.javax.swing.tree.MutableTreeNode

class MyCanvasEventSource private () {

    private var command : String = null

    private var treeNode : MutableTreeNode = null

    private var angle : Double = 0

    def this(command : String, angle : Double, treeNode : MutableTreeNode) = {
        this()
        this.command = command
        this.treeNode = treeNode
        this.setAngle(angle)
    }

    def this(command : String, treeNode : MutableTreeNode) = {
        this()
        this.command = command
        this.treeNode = treeNode
    }

    def getCommand() : String = {
        return this.command
    }

    def getTreeNode() : MutableTreeNode = {
        return this.treeNode
    }

    def getAngle() : Double = {
        return this.angle
    }

    def setAngle(angle : Double) : Unit = {
        this.angle = angle
    }

}


