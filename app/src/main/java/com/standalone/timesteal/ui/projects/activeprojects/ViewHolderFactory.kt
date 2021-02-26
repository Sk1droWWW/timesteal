package com.standalone.timesteal.ui.projects.activeprojects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.standalone.timesteal.R


class ViewHolderFactory {
    companion object {
        fun create(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
            return when (viewType) {
                RowType.PROJECT_ROW_TYPE -> {
                    val projectTypeView: View = LayoutInflater.from(parent.context)
                        .inflate(R.layout.project_card, parent, false)
                    ProjectViewHolder(projectTypeView)
                }
                RowType.HABIT_ROW_TYPE -> {
                    val habitTypeView: View = LayoutInflater.from(parent.context)
                        .inflate(R.layout.habit_card, parent, false)
                    HabitViewHolder(habitTypeView)
                }
                else -> null
            }
        }
    }

    class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var button: Button = itemView.findViewById(R.id.rv_project_btn)
        var name: TextView = itemView.findViewById(R.id.project_name_tv)
        var projectLabel: TextView = itemView.findViewById(R.id.project_label_tv)

    }

    class HabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var button: Button = itemView.findViewById(R.id.rv_habit_btn)
        var name: TextView = itemView.findViewById(R.id.habit_name_tv)
        var habitLabel: TextView = itemView.findViewById(R.id.habit_label_tv)

    }
}
