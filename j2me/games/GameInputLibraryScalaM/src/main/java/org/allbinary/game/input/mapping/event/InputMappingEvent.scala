/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping.event

import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class InputMappingEvent(param_anyType : Object) extends AllBinaryEventObject(param_anyType) {

    private var inputToGameKeyMapping : InputToGameKeyMapping = InputToGameKeyMapping.getNullInstance()

    //Constructor
    {
        val anyType : Object = param_anyType
    }

    def setInputToGameKeyMapping(inputToGameKeyMapping : InputToGameKeyMapping) : Unit = {
        this.inputToGameKeyMapping = inputToGameKeyMapping
    }

    def getInputToGameKeyMapping() : InputToGameKeyMapping = {
        return this.inputToGameKeyMapping
    }

}


