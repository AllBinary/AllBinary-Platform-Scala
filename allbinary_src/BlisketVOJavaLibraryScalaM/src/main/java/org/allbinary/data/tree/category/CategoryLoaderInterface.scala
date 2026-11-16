/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.category

import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.w3c.dom.Document

trait CategoryLoaderInterface extends CategoryModifierTreeInterface {

    //Get the document associated the properties specified
    def getDoc(categoryInterface : CategoryInterface) : Document

    def get(categoryInterface : CategoryInterface) : CategoryInterface

    //public CategoryInterface getUpToLevel(CategoryInterface categoryInterface);
    def getAll(categoryInterface : CategoryInterface) : CategoryInterface

}


