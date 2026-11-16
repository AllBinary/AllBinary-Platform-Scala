/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.osgi

import _root_.javax.swing.*
import _root_.org.osgi.framework.Bundle
import _root_.org.osgi.framework.BundleContext
import _root_.bundle.input.automation.InputAutomationBundleActivator
import _root_.org.allbinary.gui.dialog.BasicTextJDialog

class DesktopBundle() {
    import _root_.org.allbinary.input.automation.osgi.DesktopBundle.{*}

    private var bundle : Bundle = null

    //Constructor
    {
        var bundleContext : BundleContext = InputAutomationBundleActivator.getBundleContext()
        if (bundleContext != null) {
            var bundleArray : Array[Bundle] = bundleContext.getBundles()

            {
                var index : Int = 0
                while (index < bundleArray.length) {
                    var bundle : Bundle = bundleArray(index)
                    var symbolicName : String = bundle.getSymbolicName()
                    if (symbolicName.compareTo(DesktopBundle.DESKTOP_SYMBOLIC_NAME) == 0) {
                        this.bundle = bundle
                    }
                    index += 1
                }
            }
        } else {
            var textJDialog : JDialog = new BasicTextJDialog("BundlContext is Null")
            textJDialog.setVisible(true)
        }
    }

    def start() : Unit = {
        this.bundle.start()
    }

}

object DesktopBundle {
    private val DESKTOP_SYMBOLIC_NAME : String = "org.knopflerfish.bundle.desktop"

}


