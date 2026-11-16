/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.android.activity

import _root_.android.view.View

/**  *  * @author User  */
class NullKeyInputViewComposite extends KeyInputViewCompositeInterface {
    import _root_.org.allbinary.android.activity.NullKeyInputViewComposite.{NULL_KEY_INPUT_VIEW_COMPOSITE as _, *}
    def NULL_KEY_INPUT_VIEW_COMPOSITE : NullKeyInputViewComposite = _root_.org.allbinary.android.activity.NullKeyInputViewComposite.NULL_KEY_INPUT_VIEW_COMPOSITE

    override def setKeyInputView(keyInputView : View) : Unit = {
    }

    override def getRootView() : View = {
        throw new RuntimeException()
    }

    override def getView() : View = {
        throw new RuntimeException()
    }

    //    }
    override def runOnUiThread(action : Runnable) : Unit = {
    }

}

object NullKeyInputViewComposite {
    val NULL_KEY_INPUT_VIEW_COMPOSITE : NullKeyInputViewComposite = new NullKeyInputViewComposite()

}


