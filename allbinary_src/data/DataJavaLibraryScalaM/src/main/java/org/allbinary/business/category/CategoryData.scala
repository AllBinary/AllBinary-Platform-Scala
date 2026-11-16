/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.org.allbinary.logic.io.file.CommonDataFileStrings

class CategoryData private() {
    import _root_.org.allbinary.business.category.CategoryData.{*}

    val PARENT : String = "CATEGORY_PARENT"

    val NAME : String = "CATEGORY_NAME"

    val PATH : String = "CATEGORY_PATH"

    val LABEL : String = "CATEGORY_LABEL"

    val VIEW : String = "CATEGORY_VIEW_CATEGORY"

    val LEVEL : String = "CATEGORY_LEVEL"

    val REQUEST : String = "request"

    val ROOTCATEGORY : String = "Category"

    //public final String STORENAMEELEMENT = "STORE";
    val UNCRYPTED_EXTENSION : String = CommonDataFileStrings.getInstance().UNCRYPTED_EXTENSION

    val ENCRYPTED_EXTENSION : String = CommonDataFileStrings.getInstance().ENCRYPTED_EXTENSION

}

object CategoryData {
    private val instance : CategoryData = new CategoryData()

    def getInstance() : CategoryData = {
        return CategoryData.instance
    }

}


