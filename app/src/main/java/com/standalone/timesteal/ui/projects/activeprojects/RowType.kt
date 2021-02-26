package com.standalone.timesteal.ui.projects.activeprojects


interface RowType {
    val itemViewType: Int

    fun onBindViewHolder(viewHolder: Any)

    companion object {
        const val PROJECT_ROW_TYPE = 0
        const val HABIT_ROW_TYPE = 1
    }
}