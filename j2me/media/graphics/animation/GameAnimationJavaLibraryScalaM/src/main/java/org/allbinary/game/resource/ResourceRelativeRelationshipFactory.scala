/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.resource

import _root_.org.allbinary.graphics.RelativeRelationship
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class ResourceRelativeRelationshipFactory extends ResourceRelativeRelationshipFactoryInterface {

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    private val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    private var initialized : Boolean = false

    override def init(level : Int) : Unit = {
        this.setInitialized(true)
    }

    override def getResourceRelativeRelationshipList(resource : String) : BasicArrayList = {
        val listCanBeNull : Object = this.hashtable.get(resource)
        if (listCanBeNull == null) {
            return this.basicArrayListUtil.getImmutableInstance()
        }
        return listCanBeNull.asInstanceOf[BasicArrayList]
    }

    override def addResourceRelativeRelationship(resource : String, hardPoint : RelativeRelationship) : Unit = {
        var list : BasicArrayList = this.getResourceRelativeRelationshipList(resource)
        if (list eq this.basicArrayListUtil.getImmutableInstance()) {
            list = new BasicArrayListD()
        }
        list.add(hardPoint)
        this.hashtable.put(resource, list)
    }

    override def isLoadingLevel(level : Int) : Boolean = {
        return false
    }

    override def isFeature() : Boolean = {
        return false
    }

    def setInitialized(initialized : Boolean) : Unit = {
        this.initialized = initialized
    }

    def isInitialized() : Boolean = {
        return this.initialized
    }

}


