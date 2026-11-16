/* Generated Code Do Not Modify */
package org.allbinary.view

import _root_.org.allbinary.game.configuration.event.GameInitializedListenerInterface
import _root_.org.allbinary.game.midlet.DemoGameMidletEventListener
import _root_.org.allbinary.midlet.MidletCompositeInterface

trait AllBinaryMidletViewInterface extends MidletCompositeInterface with EmulatorViewInterface with DemoGameMidletEventListener with GameInitializedListenerInterface {

    def onResume() : Unit

    def onPause() : Unit

    def onDestroy() : Unit

}


