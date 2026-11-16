/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.help

import _root_.java.net.URL
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.help.HelpSet

class JavaHelpSetNotifier private() {
    import _root_.org.allbinary.logic.java.help.JavaHelpSetNotifier.{*}

}

object JavaHelpSetNotifier {
    private var vector : BasicArrayList = new BasicArrayListD()

    private def get() : BasicArrayList = {
        return JavaHelpSetNotifier.vector
    }

    def isNotified(helpSet : HelpSet) : Boolean = {
        var isNotified : Boolean = false
        var url : URL = helpSet.getHelpSetURL()
        var size : Int = JavaHelpSetNotifier.vector.size()
        var urlArray : Array[Object] = JavaHelpSetNotifier.vector.toArray()

        {
            var i : Int = 0
            while (i < size) {
                var nextURL : URL = urlArray(i).asInstanceOf[URL]
                if (url.toString().compareTo(nextURL.toString()) == 0) {
                    isNotified = true
                }
                i += 1
            }
        }
        JavaHelpSetNotifier.vector.add(url)
        return isNotified
    }

}


