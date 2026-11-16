/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.store.theme

import _root_.java.util.Comparator

class ThemeComparator() extends Comparator[Object] {

    def compare(anyType : Object, object2 : Object) : Int = {
        var string : String = anyType.asInstanceOf[String]
        var string2 : String = object2.asInstanceOf[String]
        return string.compareTo(string2)
    }

}


