/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.animation.resource.FeatureResourceAnimationInterfaceFactoryInterface
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.game.resource.FeaturedResourceFactory
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class FeaturedAnimationInterfaceFactoryInterfaceFactory private() extends FeaturedResourceFactory {
    import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory.{*}

    def getRectangle(resource : String) : Rectangle = {
        return this.getRectangleXY(resource, 0, 0)
    }

    def getRectangleXY(resource : String, x : Int, y : Int) : Rectangle = {
        val pointFactory : PointFactory = PointFactory.getInstance()
        val list : BasicArrayList = this.getList()
        val scale : Int = GameConfigurationCentral.getInstance().SCALE.getValue().intValue()
        val size : Int = this.getList().size()

        {
            var index : Int = 0
            while (index < size) {
                val featureInterface : FeatureResourceAnimationInterfaceFactoryInterface = list.objectArray(index).asInstanceOf[FeatureResourceAnimationInterfaceFactoryInterface]
                if (featureInterface.isFeature()) {
                    val rectangle : Rectangle = featureInterface.getRectangle(resource)
                    if (rectangle ne RectangleFactory.SINGLETON) {
                        return new Rectangle(pointFactory.createXY(x, y), ((rectangle.getWidth() * scale) >> 1), ((rectangle.getHeight() * scale) >> 1))
                    }
                }
                index += 1
            }
        }
        /*          * this.logUtil.putF( "No animation available for current feature          * selection or Resource: ").append(resource, "FeaturedAnimationInterfaceFactoryInterfaceFactory", * "getAnimationInterfaceInstance");          */
        throw new Exception(new StringMaker().append("No rectangle available for current feature selection or Resource: ").append(resource).toString())
    }

    def getProcedural(resource : String) : ProceduralAnimationInterfaceFactoryInterface = {
        return this.getBasicAnimationInterfaceFactoryInstance(resource).asInstanceOf[ProceduralAnimationInterfaceFactoryInterface]
    }

    def get(resource : String) : AnimationInterfaceFactoryInterface = {
        return this.getBasicAnimationInterfaceFactoryInstance(resource).asInstanceOf[AnimationInterfaceFactoryInterface]
    }

    private def getBasicAnimationInterfaceFactoryInstance(resource : String) : BasicAnimationInterfaceFactoryInterface = {
        val list : BasicArrayList = this.getList()
        val resourceTypeAvailableList : BasicArrayList = new BasicArrayListD()
        var size : Int = this.getList().size()
        var featureInterface : FeatureResourceAnimationInterfaceFactoryInterface = null
        var animationInterfaceFactoryInterface : BasicAnimationInterfaceFactoryInterface = null

        {
            var index : Int = 0
            while (index < size) {
                featureInterface = list.objectArray(index).asInstanceOf[FeatureResourceAnimationInterfaceFactoryInterface]
                if (featureInterface.isFeature()) {
                    resourceTypeAvailableList.add(featureInterface)
                    animationInterfaceFactoryInterface = featureInterface.getBasicAnimationInterfaceFactoryInstance(resource)
                    if (animationInterfaceFactoryInterface ne NullAnimationFactory.NULL_NOT_FOR_USE_ANIMATION_FACTORY) {
                        return animationInterfaceFactoryInterface
                    }
                }
                index += 1
            }
        }
        /*          * this.logUtil.putF( "No animation available for current feature          * selection or Resource: ").append(resource, "FeaturedAnimationInterfaceFactoryInterfaceFactory", * "getAnimationInterfaceInstance");          */
        if (resourceTypeAvailableList.size() > 0) {
            val NO_ANIMATION_AVAILABLE_FROM : String = "No animation available from: "
            val FOR_FACTORIES : String = " factories: "
            val FOR_RESOURCE : String = " for Resource: "
            val HAS_KEY : String = " has: "
            val RESOURCES_LABEL : String = " resources "
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(NO_ANIMATION_AVAILABLE_FROM)
            stringBuffer.appendint(resourceTypeAvailableList.size())
            stringBuffer.append(CommonSeps.getInstance().FORWARD_SLASH)
            stringBuffer.appendint(size)
            stringBuffer.append(FOR_FACTORIES)
            val size2 : Int = resourceTypeAvailableList.size()

            {
                var index : Int = 0
                while (index < size2) {
                    stringBuffer.append(resourceTypeAvailableList.get(index).toString())
                    stringBuffer.append(CommonSeps.getInstance().COMMA_SEP)
                    index += 1
                }
            }
            stringBuffer.append(FOR_RESOURCE)
            stringBuffer.append(resource)

            {
                var index : Int = 0
                while (index < size) {
                    stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
                    featureInterface = list.objectArray(index).asInstanceOf[FeatureResourceAnimationInterfaceFactoryInterface]
                    if (featureInterface.isFeature()) {
                        stringBuffer.append(StringUtil.getInstance().toString(featureInterface))
                        stringBuffer.append(HAS_KEY)
                        stringBuffer.appendint(featureInterface.getHashtable().size())
                        stringBuffer.append(RESOURCES_LABEL)
                    }
                    index += 1
                }
            }
            throw new Exception(stringBuffer.toString())
        } else {
            val stringBuffer : StringMaker = new StringMaker()

            {
                var index : Int = 0
                while (index < size) {
                    featureInterface = list.objectArray(index).asInstanceOf[FeatureResourceAnimationInterfaceFactoryInterface]
                    stringBuffer.append(featureInterface.toString())
                    stringBuffer.append(CommonSeps.getInstance().SPACE)
                    index += 1
                }
            }
            val result : String = stringBuffer.toString()
            stringBuffer.delete(0, stringBuffer.length())
            throw new Exception(stringBuffer.append("No feature resource type available for Resource: ").append(resource).append(" Resource Factories Available: ").append(result).toString())
        }
        throw new IllegalStateException()
    }

}

object FeaturedAnimationInterfaceFactoryInterfaceFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var INSTANCE : FeaturedAnimationInterfaceFactoryInterfaceFactory = new FeaturedAnimationInterfaceFactoryInterfaceFactory()

    def getInstance() : FeaturedAnimationInterfaceFactoryInterfaceFactory = {
        return FeaturedAnimationInterfaceFactoryInterfaceFactory.INSTANCE
    }

}


