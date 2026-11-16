/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class DemoGameMidletEvent(param_anyType : Object, param_demoGameMidletState : DemoGameMidletState) extends AllBinaryEventObject(param_anyType) {

    private var demoGameMidletState : DemoGameMidletState = null

    //Constructor
    {
        val anyType : Object = param_anyType
        val demoGameMidletState : DemoGameMidletState = param_demoGameMidletState
        this.demoGameMidletState = demoGameMidletState
    }

    def init(anyType : Object) : Unit = {
        this.setSource(anyType)
    }

    def setDemoGameMidletState(demoGameMidletState : DemoGameMidletState) : Unit = {
        this.demoGameMidletState = demoGameMidletState
    }

    def getDemoGameMidletState() : DemoGameMidletState = {
        return this.demoGameMidletState
    }

}


