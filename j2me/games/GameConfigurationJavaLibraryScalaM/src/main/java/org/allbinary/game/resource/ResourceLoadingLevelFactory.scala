/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.resource


class ResourceLoadingLevelFactory {
    import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory.{*}

    val LOAD_EARLY : ResourceLoadingLevel = new ResourceLoadingLevel("Load Early", Integer.MAX_VALUE)

    val LOAD_TOUCH : ResourceLoadingLevel = new ResourceLoadingLevel("Load Touch", Integer.MAX_VALUE - 1)

    val LOAD_GAME : ResourceLoadingLevel = new ResourceLoadingLevel("Load Game", Integer.MAX_VALUE - 2)

    val LEVEL : ResourceLoadingLevel = new ResourceLoadingLevel("Level", Integer.MAX_VALUE - 99)

    val MAX_LEVEL : ResourceLoadingLevel = new ResourceLoadingLevel("Max Level", Integer.MAX_VALUE - 100)

    //private final int LOAD_ = Integer.MAX_VALUE;
    val LOAD_ALL : ResourceLoadingLevel = new ResourceLoadingLevel("Load All", -1)

    private val RESOURCE_LOADING_LEVEL_ARRAY : Array[ResourceLoadingLevel] = Array[ResourceLoadingLevel](this.LOAD_ALL, this.MAX_LEVEL, this.LEVEL, this.LOAD_GAME, this.LOAD_TOUCH, this.LOAD_EARLY)

    def getLevelString(level : Int) : String = {

        {
            var index : Int = 0
            while (index < this.RESOURCE_LOADING_LEVEL_ARRAY.length) {
                if (level == this.RESOURCE_LOADING_LEVEL_ARRAY(index).getLevel()) {
                    return this.RESOURCE_LOADING_LEVEL_ARRAY(index).getName()
                }
                index += 1
            }
        }
        return Integer.toString(level)
    }

}

object ResourceLoadingLevelFactory {
    private val instance : ResourceLoadingLevelFactory = new ResourceLoadingLevelFactory()

    def getInstance() : ResourceLoadingLevelFactory = {
        return ResourceLoadingLevelFactory.instance
    }

}


