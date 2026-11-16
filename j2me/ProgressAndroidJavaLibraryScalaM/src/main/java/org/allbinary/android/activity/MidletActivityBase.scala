/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.android.activity

import _root_.android.app.Activity
import _root_.android.view.MotionEvent
import _root_.android.view.View
import _root_.org.allbinary.android.GenericMotionEventVerifyInterface
import _root_.org.allbinary.game.configuration.event.GameFeatureEvent
import _root_.org.allbinary.game.configuration.event.GameFeatureListenerInterface
import _root_.org.allbinary.game.configuration.event.GameInitializedEvent
import _root_.org.allbinary.game.configuration.event.GameInitializedListenerInterface
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

/**  *  * @author User  */
class MidletActivityBase extends Activity with GameFeatureListenerInterface with GameInitializedListenerInterface with SimpleProgressActivityInterface with KeyInputViewCompositeInterface with GenericMotionEventVerifyInterface {

    override def onGameFeatureChange(gameFeatureEvent : GameFeatureEvent) : Unit = {
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
    }

    override def onGameInitialized(gameInitializedEvent : GameInitializedEvent) : Unit = {
    }

    override def onSetProgress(value : Int, text : String) : Unit = {
    }

    override def onDismissProgress(animationSequence : Array[Int]) : Unit = {
    }

    override def onShowProgress(indeterminate : Boolean, animationSequence : Array[Int]) : Unit = {
    }

    override def getRootView() : View = {
        throw new RuntimeException()
    }

    override def getView() : View = {
        throw new RuntimeException()
    }

    override def setKeyInputView(keyInputView : View) : Unit = {
    }

    override def onGenericMotionEvent(event : MotionEvent) : Boolean = {
        throw new RuntimeException()
    }

}


