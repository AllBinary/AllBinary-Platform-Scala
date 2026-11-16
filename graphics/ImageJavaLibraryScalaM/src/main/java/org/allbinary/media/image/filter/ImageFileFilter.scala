/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.filter

import _root_.java.io.File
import _root_.javax.swing.filechooser.FileFilter

//TWB - replace with file visitor version
class ImageFileFilter extends FileFilter {

    override def accept(f : File) : Boolean = {
        if (f.isDirectory()) {
            return true
        }
        var s : String = f.getName()
        var i : Int = s.lastIndexOf('.')
        if ((i > 0) && (i < (s.length() - 1))) {
            var ext : String = s.substring(i + 1).toLowerCase()
            if (ext.equals("jpg") || ext.equals("jpeg")) {
                return true
            }
        }
        return false
    }

    override def getDescription() : String = {
        return "Accepts .jpg and .jpeg files"
    }

}


