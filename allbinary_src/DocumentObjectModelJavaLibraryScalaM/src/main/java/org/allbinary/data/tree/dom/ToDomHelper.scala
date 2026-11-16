/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.org.allbinary.logic.string.StringUtil

class ToDomHelper private() {
    import _root_.org.allbinary.data.tree.dom.ToDomHelper.{*}

}

object ToDomHelper {
    def convertNull(param_value : String) : String = {
        var value : String = param_value
        if (value == null) {
            value = StringUtil.getInstance().NULL_STRING
        }
        return value
    }

}


