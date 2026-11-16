/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.util.HashMap
import _root_.admin.taghelpers.BasicGroupItemsHelperFactory
import _root_.admin.taghelpers.BasicGroupItemsRequestHelperFactory

class BasicGroupItemsTag() extends TableTag {

    private var propertiesHashMap : HashMap[Object, Object] = null

    //Constructor
    {
        this.setTagHelperFactory(new BasicGroupItemsHelperFactory())
        this.setTagRequestHelperFactory(new BasicGroupItemsRequestHelperFactory())
    }

}


