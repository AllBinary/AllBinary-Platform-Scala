/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.users

import _root_.org.allbinary.data.tables.TableMappingInterface

//import org.allbinary.business.user.commerce.money.Money;
trait StoreFrontUsersStatisticsInterface extends TableMappingInterface {

    def getNumberOfUsers() : _root_.java.lang.Long

    def getNumberOfUsersByRole(role : String) : _root_.java.lang.Long

}


