/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.resource

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureControlledInterface
import _root_.org.allbinary.game.configuration.feature.GraphicsFeatureFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *   * @author user  */
class FeaturedResourceFactory() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val list : BasicArrayList = new BasicArrayListD()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val ANIMATION_FEATURES : String = "Animation Features: Vector: "

    private val IMAGE_LABEL : String = " Image: "

    private val IMAGE_GRAPHICS_ARRAY : String = "Image Array: "

    private val IMAGE_GRAPHICS_ROTATION : String = "Image Rotate: "

    private val SPRITE_QUARTER : String = " Sprite Quarter: "

    private val SPRITE_FULL : String = " Sprite Full: "

    private val IS_LOADING_LEVEL_LABEL : String = " isLoadingLevel "

    private val IS_FEATURE : String = " isFeature: "

    private val GAME_FEATURE_CONTROLLED : String = "GameFeatureControlledInterface: "

    def init(level : Int) : Unit = {
        var size : Int = this.list.size()

        {
            var index : Int = 0
            while (index < size) {
                var featureInterface : GameFeatureControlledInterface = this.list.objectArray(index).asInstanceOf[GameFeatureControlledInterface]
                var isLoadingLevel : Boolean = featureInterface.isLoadingLevel(level)
                var isFeature : Boolean = featureInterface.isFeature()
                this.logUtil.putF(new StringMaker().append(this.GAME_FEATURE_CONTROLLED).append(featureInterface.toString()).append(this.IS_LOADING_LEVEL_LABEL).append(ResourceLoadingLevelFactory.getInstance().getLevelString(level)).append(CommonSeps.getInstance().COLON_SEP).appendboolean(isLoadingLevel).append(this.IS_FEATURE).appendboolean(isFeature).toString(), this, this.commonStrings.INIT)
                if (isLoadingLevel && isFeature) {
                    //                        .append(featureInterface.toString()).toString(), //                        this, this.commonStrings.INIT);
                    featureInterface.init(level)
                }
                index += 1
            }
        }
        var features : Features = Features.getInstance()
        var graphicsFeatureFactory : GraphicsFeatureFactory = GraphicsFeatureFactory.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.ANIMATION_FEATURES)
        stringBuffer.appendboolean(features.isFeature(graphicsFeatureFactory.VECTOR_GRAPHICS))
        stringBuffer.append(this.IMAGE_LABEL)
        stringBuffer.appendboolean(features.isFeature(graphicsFeatureFactory.IMAGE_GRAPHICS))
        this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.INIT)
        if (features.isFeature(graphicsFeatureFactory.IMAGE_GRAPHICS)) {
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append(this.IMAGE_GRAPHICS_ARRAY)
            stringBuffer.appendboolean(features.isFeature(graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS))
            stringBuffer.append(this.IMAGE_GRAPHICS_ROTATION)
            stringBuffer.appendboolean(features.isFeature(graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS))
            stringBuffer.append(this.SPRITE_QUARTER)
            stringBuffer.appendboolean(features.isFeature(graphicsFeatureFactory.SPRITE_QUARTER_ROTATION_GRAPHICS))
            stringBuffer.append(this.SPRITE_FULL)
            stringBuffer.appendboolean(features.isFeature(graphicsFeatureFactory.SPRITE_FULL_GRAPHICS))
            this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.INIT)
        }
    }

    def clear() : Unit = {
        this.list.clear()
    }

    def add(featureInterface : GameFeatureControlledInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(StringUtil.getInstance().toString(featureInterface)).toString(), this, this.commonStrings.ADD)
        this.list.add(featureInterface)
    }

    def getList() : BasicArrayList = {
        return this.list
    }

}


