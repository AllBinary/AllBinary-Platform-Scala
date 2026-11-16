/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.org.allbinary.thread.ARunnable
import _root_.org.allbinary.image.gui.ImageToolJFrame
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class ImageTool() {
    import _root_.org.allbinary.image.ImageTool.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object ImageTool {
    def main(args : Array[String]) : Unit = {
        _root_.java.awt.EventQueue.invokeLater(new ARunnable {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    try {
                        logUtil.putF(commonStrings.START, this, commonStrings.RUN)
                        new ImageToolJFrame().setVisible(true)
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                        }
                    }
                }

            })
    }

}


