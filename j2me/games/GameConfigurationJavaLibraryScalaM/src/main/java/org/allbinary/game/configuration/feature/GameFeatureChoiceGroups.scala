/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList

class GameFeatureChoiceGroups private() {
    import _root_.org.allbinary.game.configuration.feature.GameFeatureChoiceGroups.{*}

    private var hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def get() : ABHashtable[Object, Object] = {
        return this.hashtable
    }

    def add(name : String, list : BasicArrayList) : Unit = {
        this.hashtable.put(name, list)
    }

}

object GameFeatureChoiceGroups {
    private var gameFeatureChoiceGroupsExclusive : GameFeatureChoiceGroups = new GameFeatureChoiceGroups()

    private var gameFeatureChoiceGroupsMultiple : GameFeatureChoiceGroups = new GameFeatureChoiceGroups()

    def getExclusiveInstance() : GameFeatureChoiceGroups = {
        return GameFeatureChoiceGroups.gameFeatureChoiceGroupsExclusive
    }

    def getMultipleInstance() : GameFeatureChoiceGroups = {
        return GameFeatureChoiceGroups.gameFeatureChoiceGroupsMultiple
    }

}


