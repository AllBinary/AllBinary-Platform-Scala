/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature


class GameFeatureFactory private() {
    import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory.{*}

    val SOUND : GameFeature = new GameFeature("Sound")

    val MUSIC : GameFeature = new GameFeature("Music")

    val SCREEN_SHAKE : Feature = new Feature("Screen Shake")

    val POST_IMAGE_LOADING_MODIFICATION : Feature = new Feature("Post Image Loading Modification (Scaling, Rotation, or Other)")

    val HEALTH_BARS : GameFeature = new GameFeature("Health Bars")

    val DAMAGE_FLOATERS : GameFeature = new GameFeature("Damage Floaters")

    val GAME_INPUT_LAYER_PROCESSOR : GameFeature = new GameFeature("Game Input Layer Processor")

    val ARTIFICIAL_INTELLEGENCE_PROCESSOR : GameFeature = new GameFeature("Artificial Intelligence Layer Processor")

    val COLLIDABLE_INTERFACE_LAYER_PROCESSOR : GameFeature = new GameFeature("Collidable Interface Layer Processor")

    val TICKABLE_LAYER_PROCESSOR : GameFeature = new GameFeature("Tickable Layer Processor")

    val CHEATING : GameFeature = new GameFeature("Cheating")

    val DROPPED_ITEMS : GameFeature = new GameFeature("Drops")

    val DROPPED_ITEMS_FROM_DEATH : GameFeature = new GameFeature("Drops from Dead")

    // GameFeature("Pickups");
    val TEST_DESTROYED_LAYER_PROCESSOR : GameFeature = new GameFeature("Destroyed Layer Processor")

    val COLLISIONS_WITH_SOURCE : GameFeature = new GameFeature("Allow Collisions With Source")

    val COLLISIONS_FORCED_TWO_DIMENSIONAL : GameFeature = new GameFeature("Collisions Forced Two Dimensional")

}

object GameFeatureFactory {
    private val instance : GameFeatureFactory = new GameFeatureFactory()

    def getInstance() : GameFeatureFactory = {
        return GameFeatureFactory.instance
    }

}


