/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.view

import _root_.javax.microedition.lcdui.Displayable
import _root_.javax.microedition.midlet.MIDlet

/**  *  * @author User  */
class NullEmulatorView extends EmulatorViewInterface {
    import _root_.org.allbinary.view.NullEmulatorView.{NULL_EMULATOR_VIEW as _, *}
    def NULL_EMULATOR_VIEW : NullEmulatorView = _root_.org.allbinary.view.NullEmulatorView.NULL_EMULATOR_VIEW

    override def setMidlet(midlet : MIDlet) : Unit = {
    }

    //KeyInputViewCompositeInterface
    override def onEmulatorInitComplete(midletActivity : Object) : Unit = {
    }

    override def onSetDisplayable(displayable : Displayable) : Unit = {
    }

}

object NullEmulatorView {
    val NULL_EMULATOR_VIEW : NullEmulatorView = new NullEmulatorView()

}


