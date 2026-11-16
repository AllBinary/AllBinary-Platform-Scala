/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.store.theme

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.visual.theme.ThemeValidation
import _root_.org.allbinary.logic.visual.transform.info.CompositeTransformInfoInterface

trait StoreThemeCategoryInterface extends CategoryInterface with TableMappingInterface with ValidationInterface with CompositeTransformInfoInterface {

    def addTheme(themeValidation : ThemeValidation) : Unit

    def getThemes() : BasicArrayList

}


