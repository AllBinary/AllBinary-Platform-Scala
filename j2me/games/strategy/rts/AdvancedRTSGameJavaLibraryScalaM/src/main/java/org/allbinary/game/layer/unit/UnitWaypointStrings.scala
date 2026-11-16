/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.unit

import _root_.org.allbinary.string.CommonLabels

/**  *  * @author User  */
class UnitWaypointStrings {
    import _root_.org.allbinary.game.layer.unit.UnitWaypointStrings.{*}

    val PATHING : String = "Pathing"

    //"Lalala" //"What Now? //"Wander";
    val WANDERING : String = "Order?"

    val THINKING : String = "Thinking"

    //"Analyzing" //"Hmmm?"
    val THINKING_ABOUT_TARGET : String = "Hmmm"

    val TARGET : String = "Target"

    val KILL : String = "Kill!"

    val STOP : String = "Stop"

    val WAYPOINT_DESTROYED_SHORT : String = "Uh Oh"

    val WAYPOINT_DESTROYED : String = "Waypoint Destroyed"

    val ALL_VISITED_SHORT : String = "Arrived"

    val ALL_VISITED : String = "All Visited"

    val ALREADY_THERE_SHORT : String = "Again?"

    val ALREADY_THERE : String = "Already There"

    val NEXT_PATH_NODE : String = CommonLabels.getInstance().NEXT + " Path Node"

    val _ALL_VISITED_SHORT : String = " Arrived"

    //public final final String ALL_VISITED = "All Visited";
    val _ALREADY_THERE_SHORT : String = " Again?"

    //public final String ALREADY_THERE = "Already There";
    val VISITED_MOST_OF_THE_PATH : String = " visited most of the path"

    val RETURNING_AS_WAYPOINT_PATH_LIST : String = " returning as waypointPathsList was runningWaypointPathList"

}

object UnitWaypointStrings {
    private val instance : UnitWaypointStrings = new UnitWaypointStrings()

    /**      * @return the instance      */
    def getInstance() : UnitWaypointStrings = {
        return UnitWaypointStrings.instance
    }

}


