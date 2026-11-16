/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.users


class StoreFrontUsersStatisticsData private() {
    import _root_.org.allbinary.business.context.modules.storefront.statistics.users.StoreFrontUsersStatisticsData.{*}

    val NAME : String = "STOREFRONT_USERS_STATISTICS_NAME"

    val NUMBEROFUSERS : String = "STOREFRONT_USERS_STATISTICS_NUMBER_OF_USERS"

}

object StoreFrontUsersStatisticsData {
    private val instance : StoreFrontUsersStatisticsData = new StoreFrontUsersStatisticsData()

    def getInstance() : StoreFrontUsersStatisticsData = {
        return StoreFrontUsersStatisticsData.instance
    }

}


