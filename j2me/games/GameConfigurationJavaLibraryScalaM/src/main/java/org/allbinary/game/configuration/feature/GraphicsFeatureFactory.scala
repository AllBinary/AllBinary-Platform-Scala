/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.org.allbinary.logic.string.StringUtil

class GraphicsFeatureFactory private() {
    import _root_.org.allbinary.game.configuration.feature.GraphicsFeatureFactory.{*}

    val NONE : GraphicsFeature = new GraphicsFeature(StringUtil.getInstance().NULL_STRING)

    val TRANSPARENT_IMAGE_CREATION : GraphicsFeature = new GraphicsFeature("Transparent Image Creation")

    val IMAGE_GRAPHICS : GraphicsFeature = new GraphicsFeature("Image Graphics")

    val IMAGE_ROTATION_ON_THE_FLY : GraphicsFeature = new GraphicsFeature("Image Rotated On The Fly")

    val IMAGE_TO_ARRAY_GRAPHICS : GraphicsFeature = new GraphicsFeature("Image To Array Graphics")

    val SPRITE_QUARTER_ROTATION_GRAPHICS : GraphicsFeature = new GraphicsFeature("Sprite Quarter Rotation Graphics")

    val SPRITE_FULL_GRAPHICS : GraphicsFeature = new GraphicsFeature("Sprite Full Rotation Graphics")

    val VECTOR_GRAPHICS : GraphicsFeature = new GraphicsFeature("BasicArrayList Graphics")

    val VECTOR_TO_IMAGE_GRAPHICS : GraphicsFeature = new GraphicsFeature("BasicArrayList To Image Graphics")

}

object GraphicsFeatureFactory {
    private val instance : GraphicsFeatureFactory = new GraphicsFeatureFactory()

    def getInstance() : GraphicsFeatureFactory = {
        return GraphicsFeatureFactory.instance
    }

}


