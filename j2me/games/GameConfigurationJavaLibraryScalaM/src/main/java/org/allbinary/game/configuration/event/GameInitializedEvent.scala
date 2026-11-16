/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.event

import _root_.org.allbinary.game.resource.ResourceLoadingLevel
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class GameInitializedEvent(param_anyType : Object) extends AllBinaryEventObject(param_anyType) {

    private var resourceLoadingLevel : ResourceLoadingLevel = ResourceLoadingLevelFactory.getInstance().LEVEL

    private var level : Int = 0

    //Constructor
    {
        val anyType : Object = param_anyType
    }

    def setLevel(level : Int) : Unit = {
        this.level = level
        this.resourceLoadingLevel = ResourceLoadingLevelFactory.getInstance().LEVEL
    }

    def getLevel() : Int = {
        return this.level
    }

    def setResourceLoadingLevel(resourceLoadingLevel : ResourceLoadingLevel) : Unit = {
        this.resourceLoadingLevel = resourceLoadingLevel
        this.level = this.resourceLoadingLevel.getLevel()
    }

    def getResourceLoadingLevel() : ResourceLoadingLevel = {
        return this.resourceLoadingLevel
    }

}


