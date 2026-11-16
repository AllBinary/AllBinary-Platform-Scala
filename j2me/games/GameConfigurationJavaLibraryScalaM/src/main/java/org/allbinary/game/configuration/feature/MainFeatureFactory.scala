/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature


class MainFeatureFactory {
    import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory.{*}

    val FULL_SCREEN : Feature = new Feature("Full Screen")

    val TITLE_BAR : Feature = new Feature("Title Bar")

    val STATIC : Feature = new Feature("Static Dependent Feature")

    val LOAD_ONDEMAND : Feature = new Feature("Load OnDemand")

    val LOAD_ALL : Feature = new Feature("Load All")

}

object MainFeatureFactory {
    private val instance : MainFeatureFactory = new MainFeatureFactory()

    def getInstance() : MainFeatureFactory = {
        return MainFeatureFactory.instance
    }

}


