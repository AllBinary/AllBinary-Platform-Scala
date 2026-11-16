/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature


class InputFeatureFactory private() {
    import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory.{*}

    val REMOVE_DUPLICATE_KEY_PRESSES : InputFeature = new InputFeature("Remove Duplicate Key Presses")

    val INPUT_MAPPING : InputFeature = new InputFeature("Input Mapping")

    val MULTI_KEY_PRESS : InputFeature = new InputFeature("Multi Key Press")

    val SINGLE_KEY_REPEAT_PRESS : InputFeature = new InputFeature("Single Key Repeat Press")

    val SINGLE_KEY_PRESS : InputFeature = new InputFeature("Single Key Press")

    def isSingleKeyProcessing() : Boolean = {
        var features : Features = Features.getInstance()
        if (features.isFeature(this.SINGLE_KEY_REPEAT_PRESS) || features.isFeature(this.SINGLE_KEY_PRESS)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}

object InputFeatureFactory {
    private val instance : InputFeatureFactory = new InputFeatureFactory()

    def getInstance() : InputFeatureFactory = {
        return InputFeatureFactory.instance
    }

}


