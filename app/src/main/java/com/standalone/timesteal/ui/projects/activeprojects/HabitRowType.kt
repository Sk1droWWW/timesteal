package com.standalone.timesteal.ui.projects.activeprojects

import android.content.Context
import android.view.View
import android.widget.Toast
import com.standalone.timesteal.ui.projects.activeprojects.ViewHolderFactory.ProjectViewHolder

class HabitRowType(private val context: Context) : RowType {
    private val onClickListener: View.OnClickListener
        get() = View.OnClickListener {
            Toast.makeText(context, "HabitRowType", Toast.LENGTH_SHORT).show()
        }
    override val itemViewType: Int
        get() {
            return RowType.HABIT_ROW_TYPE
        }

    override fun onBindViewHolder(viewHolder: Any) {
        val projectViewHolder: ProjectViewHolder? = viewHolder as ProjectViewHolder?
        projectViewHolder!!.button.setOnClickListener(onClickListener)
    }
}