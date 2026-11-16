/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.filter

import _root_.java.io.FileFilter
import _root_.org.allbinary.logic.io.file.visitor.IncludeFileExtensionsBooleanFileVisitor
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicFileFilterUtil private() {
    import _root_.org.allbinary.logic.io.file.filter.BasicFileFilterUtil.{*}

}

object BasicFileFilterUtil {
    def getInstance(extension : String) : FileFilter = {
        val vector : BasicArrayList = new BasicArrayListD()
        vector.add(extension)
        val includeFileExtensionsBooleanFileVisitor : IncludeFileExtensionsBooleanFileVisitor = new IncludeFileExtensionsBooleanFileVisitor(vector)
        return (new VisitorFileFilter(includeFileExtensionsBooleanFileVisitor)).asInstanceOf[FileFilter]
    }

}


