/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GameConfigurationSingleton private() {
    import _root_.org.allbinary.game.configuration.GameConfigurationSingleton.{*}

    private var list : BasicArrayList = null

    private var hashtable : ABHashtable[Object, Object] = null

    //Constructor
    {
        this.list = new BasicArrayListD()
        this.hashtable = StdUtil.getInstance().createHashtable()
    }

    def getInstanceByName(name : String) : GameConfiguration = {
        return this.hashtable.get(name).asInstanceOf[GameConfiguration]
    }

    def getOptionsBasicArrayList() : BasicArrayList = {
        return this.list
    }

    def add(gameConfiguration : GameConfiguration) : Unit = {
        this.list.add(gameConfiguration)
    }

    def getHashtable() : ABHashtable[Object, Object] = {
        return this.hashtable
    }

}

object GameConfigurationSingleton {
    private var SINGLETON : GameConfigurationSingleton = new GameConfigurationSingleton()

    def getInstance() : GameConfigurationSingleton = {
        return GameConfigurationSingleton.SINGLETON
    }

}


