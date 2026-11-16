/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.resource

import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.RelativeRelationship
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.relationship.RelativeLayerRelationship
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class FeaturedResourceRelativeRelationshipFactory private() extends FeaturedResourceFactory {
    import _root_.org.allbinary.game.resource.FeaturedResourceRelativeRelationshipFactory.{*}

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    def getRelativeRelationshipList(resource : String, layer : AllBinaryLayer) : BasicArrayList = {
        val featureReleaseList : BasicArrayList = this.getList()
        var size : Int = this.getList().size()

        {
            var index : Int = 0
            while (index < size) {
                var featureInterface : ResourceRelativeRelationshipFactoryInterface = featureReleaseList.objectArray(index).asInstanceOf[ResourceRelativeRelationshipFactoryInterface]
                if (featureInterface.isFeature()) {
                    var list : BasicArrayList = featureInterface.getResourceRelativeRelationshipList(resource)
                    if (list ne this.basicArrayListUtil.getImmutableInstance()) {
                        return this.duplicate(list, layer)
                    }
                }
                index += 1
            }
        }
        throw new Exception(new StringMaker().append("Not available for current feature selection or Resource: ").append(resource).toString())
    }

    private def duplicate(list : BasicArrayList, layer : AllBinaryLayer) : BasicArrayList = {
        val pointFactory : PointFactory = PointFactory.getInstance()
        val newList : BasicArrayList = new BasicArrayListD()
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                var relativeRelationship : RelativeRelationship = list.objectArray(index).asInstanceOf[RelativeRelationship]
                newList.add(new RelativeLayerRelationship(layer, pointFactory.createXY(relativeRelationship.getX(), relativeRelationship.getY()), BasicArrayListUtil.getInstance().getImmutableInstance()))
                index += 1
            }
        }
        return newList
    }

}

object FeaturedResourceRelativeRelationshipFactory {
    private var INSTANCE : FeaturedResourceRelativeRelationshipFactory = new FeaturedResourceRelativeRelationshipFactory()

    def getInstance() : FeaturedResourceRelativeRelationshipFactory = {
        return FeaturedResourceRelativeRelationshipFactory.INSTANCE
    }

}


