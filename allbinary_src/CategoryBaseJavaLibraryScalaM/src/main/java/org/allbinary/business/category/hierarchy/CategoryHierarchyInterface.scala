/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.hierarchy

import _root_.org.allbinary.business.category.CategoryInterface

trait CategoryHierarchyInterface {

    def getLevel() : Int

    def getLevelString() : String

    def getRoot() : CategoryInterface

    def getParent() : CategoryInterface

    def setLevel(level : Int) : Unit

    def setRoot(categoryInterface : CategoryInterface) : Unit

    def setParent(categoryInterface : CategoryInterface) : Unit

}


