/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.org.allbinary.game.configuration.event.ChangedGameFeatureListener
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

class Feature(param_name : String) {
    import _root_.org.allbinary.game.configuration.feature.Feature.{*}

    private var name : String = null

    //Constructor
    {
        val name : String = param_name
        this.name = name
        Feature.add(name, this)
        ChangedGameFeatureListener.getInstance().add(this)
    }

    override def toString() : String = {
        return this.getName()
    }

    def getName() : String = {
        return this.name
    }

}

object Feature {
    private var hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def getInstance(name : String) : Feature = {
        return Feature.hashtable.get(name).asInstanceOf[Feature]
    }

    private def add(name : String, gameFeature : Feature) : Unit = {
        Feature.hashtable.put(name, gameFeature)
    }

}


