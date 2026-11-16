/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.quoterequest


class QuoteRequestData private() {
    import _root_.org.allbinary.business.quoterequest.QuoteRequestData.{*}

    val ID : String = "QUOTEREQUEST_ID"

    val PROJECT_INFO : String = "QUOTEREQUEST_PROJECT_INFO"

    val CUSTOMER_COMMENTS : String = "QUOTEREQUEST_CUSTOMER_COMMENTS"

    val BUDGET : String = "QUOTEREQUEST_BUDGET"

    val TIMEFRAME : String = "QUOTEREQUEST_TIMEFRAME"

    val COMMENTS : String = "QUOTEREQUEST_COMMENTS"

}

object QuoteRequestData {
    private val instance : QuoteRequestData = new QuoteRequestData()

    def getInstance() : QuoteRequestData = {
        return QuoteRequestData.instance
    }

}


