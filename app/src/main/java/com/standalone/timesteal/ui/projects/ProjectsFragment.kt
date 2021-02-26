package com.standalone.timesteal.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.standalone.timesteal.R
import com.standalone.timesteal.ui.projects.activeprojects.HabitRowType
import com.standalone.timesteal.ui.projects.activeprojects.MultipleTypesAdapter
import com.standalone.timesteal.ui.projects.activeprojects.ProjectRowType
import com.standalone.timesteal.ui.projects.activeprojects.RowType
import kotlin.random.Random


class ProjectsFragment : Fragment() {

    private lateinit var projectsViewModel: ProjectsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        projectsViewModel =
                ViewModelProvider(this).get(ProjectsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_projects, container, false)
        val textView: TextView = root.findViewById(R.id.text_projects)
        val recyclerView: RecyclerView = root.findViewById(R.id.projects_recycler_view)

        val adapter = MultipleTypesAdapter(randomItemsGenerator())
        recyclerView.adapter = adapter

        projectsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }

    private fun randomItemsGenerator(): List<RowType> {
        val items: MutableList<RowType> = ArrayList()
        for (i in 0..10) {
            when (Random.nextInt(from = 0, until = 1)) {
                0 -> this.context?.let { ProjectRowType(it) }?.let { items.add(it) }
                1 -> this.context?.let { HabitRowType(it) }?.let { items.add(it) }
            }
        }

        return items
    }
}