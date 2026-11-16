/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.contraints.display.browser

import _root_.org.w3c.dom.Node

class DisplayInBrowserContraints(param_node : Node) extends DisplayInBrowserContraintsInterface {

    private var frameable : Boolean = false

    private var mountable : Boolean = false

    private var quickFrameable : Boolean = false

    private var mountedLink : String = null

    //Constructor
    {
        val node : Node = param_node
    }

    def isMountable() : Boolean = {
        return this.mountable
    }

    def setMountable(mountable : Boolean) : Unit = {
        this.mountable = mountable
    }

    def isFrameable() : Boolean = {
        return this.frameable
    }

    def setFrameable(frameable : Boolean) : Unit = {
        this.frameable = frameable
    }

    def isQuickFrameable() : Boolean = {
        return this.quickFrameable
    }

    def setQuickFrameable(quickFrameable : Boolean) : Unit = {
        this.quickFrameable = quickFrameable
    }

    def getMountedLink() : String = {
        return this.mountedLink
    }

    def setMountedLink(mountedLink : String) : Unit = {
        this.mountedLink = mountedLink
    }

}


