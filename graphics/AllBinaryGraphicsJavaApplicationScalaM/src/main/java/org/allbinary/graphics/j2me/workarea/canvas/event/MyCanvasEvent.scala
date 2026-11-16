/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.canvas.event

import _root_.javax.swing.tree.MutableTreeNode

class MyCanvasEvent(param_source : Object) extends _root_.java.util.EventObject(param_source) {

    //Constructor
    {
        val source : Object = param_source
    }

    override def getSource() : Object = {
        return super.getSource()
    }

    override def toString() : String = {
        return super.toString()
    }

    def getCommand() : String = {
        var myEventSource : MyCanvasEventSource = this.getSource().asInstanceOf[MyCanvasEventSource]
        return myEventSource.getCommand()
    }

    def getTreeNode() : MutableTreeNode = {
        var myEventSource : MyCanvasEventSource = this.getSource().asInstanceOf[MyCanvasEventSource]
        return myEventSource.getTreeNode()
    }

    def getAngle() : Double = {
        var myEventSource : MyCanvasEventSource = this.getSource().asInstanceOf[MyCanvasEventSource]
        return myEventSource.getAngle()
    }

}


