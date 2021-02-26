package com.standalone.timesteal.ui.projects.activeprojects

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.standalone.timesteal.ui.projects.activeprojects.ViewHolderFactory
import com.standalone.timesteal.ui.projects.activeprojects.ViewHolderFactory.Companion.create


class MultipleTypesAdapter(private val dataSet: List<RowType>) :
        RecyclerView.Adapter<> {

    override fun getItemViewType(position: Int): Int {
        return dataSet[position].itemViewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFactory {
        return create(parent, viewType)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolderFactory, position: Int) {
        dataSet[position].onBindViewHolder(holder)
    }
}