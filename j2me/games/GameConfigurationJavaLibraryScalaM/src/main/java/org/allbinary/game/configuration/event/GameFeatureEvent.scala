/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class GameFeatureEvent(param_anyType : Object, param_whatChanged : String) extends AllBinaryEventObject(param_anyType) {

    private var whatChanged : String = null

    //Constructor
    {
        val anyType : Object = param_anyType
        val whatChanged : String = param_whatChanged
        this.whatChanged = whatChanged
    }

    def getWhatChanged() : String = {
        return this.whatChanged
    }

    def getGameOption() : Object = {
        return this.getSource()
    }

}


