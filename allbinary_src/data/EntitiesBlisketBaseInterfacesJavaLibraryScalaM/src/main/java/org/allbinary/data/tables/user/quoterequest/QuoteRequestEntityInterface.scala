/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.quoterequest

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.quoterequest.QuoteRequest
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait QuoteRequestEntityInterface extends BasicDataTableInterface {

    def get(userName : String, id : Int) : QuoteRequest

    def getIds(userName : String) : BasicArrayList

    //public QuoteRequest[] get(String userName);
    def deleteWhere(key : String, value : String) : Unit

    def insert(values : BasicArrayList) : Unit

    def update(userName : String, updatedValues : HashMap[Object, Object]) : Unit

}


